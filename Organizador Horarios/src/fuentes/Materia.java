/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuentes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.StringTokenizer;
import java.awt.Color;
/**
 *
 * @author Adrian Coloma
 */
public class Materia implements Serializable{
    
    public String nombreMateria;
    public ArrayList<HorarioMateria> dias;
    private Color color;
    private int prioridad;
    private int creditos;
           
    private HorarioMateria causaConflictoActual = null;

    public Materia() {
        dias = new ArrayList<>();
        this.prioridad = 0;
    }

    
    public Materia(String nombreMateria) {
        this(nombreMateria, Color.WHITE, 0);
    }
    
    public Materia(String nombre, Color color){
        this(nombre, color, 0);
    }
    public Materia(String nombre, Color color, int prioridad){
        this.nombreMateria = nombre;
        this.color = color;
        this.prioridad = prioridad;
        dias = new ArrayList<>();
    }
    
    public Materia(String[] arregloMateria){
        this.nombreMateria = arregloMateria[0];
        this.dias = new ArrayList<>();
        for(int i = 1; i < 6; i++){
            if(arregloMateria[i] != null && !arregloMateria[i].equals("")){
                StringTokenizer st = new StringTokenizer(arregloMateria[i],"-");
                this.addDia(Dia.getDia(i - 1), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

        }
        
        String stringPrioridad = arregloMateria[7];
        if(stringPrioridad != null)
            this.prioridad = Integer.parseInt(arregloMateria[7]);
        else
            this.prioridad = 0;
        
        String stringCreditos = arregloMateria[8];
        
        if(stringCreditos != null)
            this.creditos = Integer.parseInt(arregloMateria[8]);
        else
            this.creditos= 0;
    }
    public void addDia(Dia dia,int horaInicio, int horaFinal){
        HorarioMateria horarioMateria = new HorarioMateria(dia,horaInicio,horaFinal);
        dias.add(horarioMateria);
    }

    public boolean hayConflicto(Materia materia){
        if(nombreMateria.equals(materia.nombreMateria))
            return true;
                    
        for(HorarioMateria horarioMateria: dias){
            for(HorarioMateria horarioMateria2: materia.dias){
                if(horarioMateria.colisiona(horarioMateria2)){
                    causaConflictoActual = horarioMateria;
                    return true;
                }
            }
        }
        return false;
    }
    
    public HorarioMateria getConflictoActual(){
        return causaConflictoActual;
    }
    
    public Object[] toArray(){
        Object[] arregloMateria = new String[Horario.titulosColumnas.length];
        arregloMateria[0] = nombreMateria;
        for(HorarioMateria horarioMateria: dias){
            arregloMateria[horarioMateria.dia.getNumero() + 1] = String.format("%d-%d", horarioMateria.horaInicio,horarioMateria.horaFinal);
        }
        
        arregloMateria[7] = prioridad == 0 ? null : Integer.toString(prioridad);
        arregloMateria[8] = creditos == 0 ? null : Integer.toString(creditos);
        return arregloMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }
    
    @Override
    public String toString() {
        /*
        String materiaString = nombreMateria + '\n';
        for(HorarioMateria dia: dias){
            materiaString+= dia.toString() + '\n';
        }
        return materiaString;*/
        
        return nombreMateria;
    }

    public int getHoraMayor(){
        ArrayList<Integer> horasFinales = new ArrayList<>();
        for(HorarioMateria dia: dias){
            horasFinales.add(dia.horaFinal);
        }
        return Collections.max(horasFinales);
    }
    
    public int getHoraMenor(){
        ArrayList<Integer> horasIniciales = new ArrayList<>();
        for(HorarioMateria dia: dias){
            horasIniciales.add(dia.horaInicio);
        }
        return Collections.min(horasIniciales);        
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof Materia) )
            return false;
        Materia materiaComparada = (Materia) obj;
        
        return nombreMateria.equals(materiaComparada.nombreMateria);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nombreMateria);
        return hash;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        if(color == null)
            return Color.WHITE;
        else
            return color;
    }
    
    public int getTotalHoras(){
        int totalHoras = 0;
        for(HorarioMateria horario: dias){
            totalHoras += horario.getTotalHoras();
        }
        
        return totalHoras;
    }

    public int getPrioridad() {
        return prioridad;
    }
    
    public int compararPrioridad(Materia materia){
        return Integer.compare(prioridad, materia.prioridad);
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
}
