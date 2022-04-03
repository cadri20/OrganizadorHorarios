package fuentes;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author Hp
 */
public class Horario implements Serializable{
    private List<Materia> horario;
    public static String[] titulosColumnas = {"Materia","Lunes","Martes","Miércoles","Jueves","Viernes","Sabado","Prioridad", "Creditos"};
    public static String[] titulosColumnasConHoras = {"Horas","Lunes","Martes","Miércoles","Jueves","Viernes","Sabado"};
    private Map<Materia[], HorarioMateria> colisiones;
    
    public static int SIN_MAX_CREDITOS = -1;
    public Horario(ArrayList<Materia> materias, boolean conPrioridades, int maxCreditos){      
        this(materias, true, conPrioridades, maxCreditos);
    }
    
    public Horario(ArrayList<Materia> materias, boolean organizar, boolean conPrioridades, int maxCreditos){
        colisiones = new HashMap<>();
        if(organizar){
            if (!materias.isEmpty())
                horario = organizarHorario(materias, conPrioridades, maxCreditos);
            else
                throw new IllegalArgumentException("La lista esta vacía");
        }else{
            horario = materias;
        }
    }    
    
    private List<Materia> organizarHorario(ArrayList<Materia> materias, boolean conPrioridades, int maxCreditos){
        if(!conPrioridades){
            Collections.shuffle(materias);           
        }else{
            Collections.sort(materias, Collections.reverseOrder((Materia materia1, Materia materia2) -> {
                return materia1.compararPrioridad(materia2);
            }));
        }
        
        return organizarHorario(materias, maxCreditos);
            
    }
    
    private List<Materia> organizarHorario(ArrayList<Materia> materias, int maxCreditos){   
        ArrayList<Materia> listaOrganizada = new ArrayList<Materia>(); //En esta lista se iran agregando las materias 
        for(Materia materiaAIngresar: materias){ //Se itera en la lista de materias
            if(listaOrganizada.isEmpty()){ 
                listaOrganizada.add(materiaAIngresar); //La primera materia en la lista se ingresa sin ninguna comparación
            }else{
                boolean colisiona = false; // Centinela para saber si la materia que se va a ingresar colisiona con alguna de las que ya esta en la listaOrganizada
                for(Materia materiaActual: listaOrganizada){ //Se itera dentro de la listaOrganizada para comparar su contenido con la materia que se quiere ingresar
                    if(materiaAIngresar.hayConflicto(materiaActual)){
                        colisiona = true;             // Si la materia a ingresar tiene conflicto con una de la listaOrganizada se detiene el bucle
                        HorarioMateria conflictoActual = materiaAIngresar.getConflictoActual();
                        if(conflictoActual != null)
                            colisiones.put(new Materia[]{materiaAIngresar, materiaActual}, materiaAIngresar.getConflictoActual());
                        break;   
                    }
                }
                if(!colisiona){
                    if(maxCreditos != SIN_MAX_CREDITOS){
                        int creditosDespues = totalCreditos(listaOrganizada) + materiaAIngresar.getCreditos();
                        if(creditosDespues > maxCreditos)
                            return listaOrganizada;
                    }
                    listaOrganizada.add(materiaAIngresar); //Si la materia a ingresar no colisionó con ninguna de la listaOrganizada entonces se la ingresa
                }
            }
        }
        return listaOrganizada;
    }
    
    public Object[][] toArray(){
        int cantMaterias = horario.size();
        Object[][] horarioMatriz = new String[cantMaterias][titulosColumnas.length];
        int i = 0;
        for(Materia materia: horario){
            horarioMatriz[i] = materia.toArray();
            i++;
        }
        return horarioMatriz;
    }
    
    public int getHoraMaxima(){
        ArrayList<Integer> horasMaximas = new ArrayList<>();
        for(Materia materia: horario){
            horasMaximas.add(materia.getHoraMayor());
        }
        
        return Collections.max(horasMaximas);
    }
    
    public int getHoraMinima(){
        ArrayList<Integer> horasMinimas = new ArrayList<>();
        for(Materia materia: horario){
            horasMinimas.add(materia.getHoraMenor());
        }
        
        return Collections.min(horasMinimas);
    }
    
    public String[][] getHorarioOrdenado(){
        int horaMinima = getHoraMinima();
        int horaMaxima = getHoraMaxima();
        int filas = horaMaxima - horaMinima;
        int columnas = titulosColumnas.length;
        String[][] horarioOrdenado = new String[filas][columnas];
        for(Materia materia: horario){
            for(HorarioMateria dia: materia.dias){
                for(int fila: dia.filas(horaMinima)){
                    horarioOrdenado[fila][dia.dia.getNumero() + 1] = materia.nombreMateria;
                }
            }
        }
        int m = 0;
        
        //Se rellena la primera columna con las horas del horario
        for(String hora: horas(filas,horaMinima)){
            horarioOrdenado[m][0] = hora;
            m++;
        }
        
        return horarioOrdenado;
    }
    
    private String[] horas(int filas, int horaMinima){
        String[] horas = new String[filas];
        int n = 0;
        for(int i = 0; i < horas.length; i++){
            horas[i] = String.format("%d-%d", horaMinima + n, horaMinima + n + 1);
            n++;
        }
        return horas;
    }
    @Override
    public String toString() {
        String horarioString = "";
        for(Materia materia: horario)
            horarioString+= materia;
        return horarioString ;
    }
    
    public Materia getMateria(String nombreMateria){
        for(Materia materia: horario){
            if(materia.nombreMateria.equals(nombreMateria))
                return materia;
        }
        
        return null;
    }
    
    public List<Materia> getMaterias(){
        return horario;
    }
    
    private int totalHoras(List<Materia> materias){
        int totalHoras = 0;
        for(Materia materia: materias){
            totalHoras += materia.getTotalHoras();
        }
        
        return totalHoras;
    }
    public int getTotalHoras(){
        return totalHoras(horario);
    }
    
    private int totalCreditos(List<Materia> materias){
        int totalCreditos = 0;
        for(Materia materia: materias)
            totalCreditos += materia.getCreditos();
        
        return totalCreditos;        
    }
    public int getTotalCreditos(){
        return totalCreditos(horario);
    }

    public String[][] getColisiones() {
        String[][] cadenasColisiones = new String[colisiones.size()][3];
        int filaActual = 0;
        
        for(Entry<Materia[], HorarioMateria> colision : colisiones.entrySet()){
            cadenasColisiones[filaActual][0] = colision.getValue().toString();
            cadenasColisiones[filaActual][1] = colision.getKey()[0].toString();
            cadenasColisiones[filaActual][2] = colision.getKey()[1].toString();
            
            filaActual++;
        }
        
        return cadenasColisiones;
    }
    
}
