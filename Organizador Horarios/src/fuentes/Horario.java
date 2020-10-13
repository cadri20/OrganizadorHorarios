package fuentes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Hp
 */
public class Horario {
    Collection<Materia> horario;
    static String[] titulosColumnas = {"Materia","Lunes","Martes","Miércoles","Jueves","Viernes"};
    public Horario(ArrayList<Materia> materias){
        horario = organizarHorario(materias);
    }
    
    private Collection<Materia> organizarHorario(ArrayList<Materia> materias){
        Collections.shuffle(materias); //Se ordena aleatoriamente a la lista de materias (Para que obtenerse diferentes horarios
        ArrayList<Materia> listaOrganizada = new ArrayList<Materia>(); //En esta lista se iran agregando las materias 
        for(Materia materiaAIngresar: materias){ //Se itera en la lista de materias
            if(listaOrganizada.isEmpty()){ 
                listaOrganizada.add(materiaAIngresar); //La primera materia en la lista se ingresa sin ninguna comparación
            }else{
                boolean colisiona = false; // Centinela para saber si la materia que se va a ingresar colisiona con alguna de las que ya esta en la listaOrganizada
                for(Materia materiaActual: listaOrganizada){ //Se itera dentro de la listaOrganizada para comparar su contenido con la materia que se quiere ingresar
                    if(materiaAIngresar.hayConflicto(materiaActual)){
                        colisiona = true;             // Si la materia a ingresar tiene conflicto con una de la listaOrganizada se detiene el bucle
                        break;   
                    }
                }
                if(!colisiona)
                    listaOrganizada.add(materiaAIngresar); //Si la materia a ingresar no colisionó con ninguna de la listaOrganizada entonces se la ingresa
            }
        }
        return listaOrganizada;
    }
    
    public String[][] toArray(){
        int cantMaterias = horario.size();
        String[][] horarioMatriz = new String[cantMaterias][5];
        int i = 0;
        for(Materia materia: horario){
            horarioMatriz[i] = materia.toArray();
            i++;
        }
        return horarioMatriz;
    }
    
    @Override
    public String toString() {
        String horarioString = "";
        for(Materia materia: horario)
            horarioString+= materia;
        return horarioString ;
    }
    
    
    
}
