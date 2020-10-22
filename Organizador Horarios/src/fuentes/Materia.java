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

/**
 *
 * @author David Arteaga, Ariel Pillajo, Adrian Coloma
 */
public class Materia implements Serializable{
    
    public String nombreMateria;
    ArrayList<HorarioMateria> dias;

    public Materia() {
        dias = new ArrayList<>();
    }

    
    public Materia(String nombreMateria) {
        this.nombreMateria = nombreMateria;
        dias = new ArrayList<>();
    }
    
    public Materia(String[] arregloMateria){
        this.nombreMateria = arregloMateria[0];
        this.dias = new ArrayList<>();
        for(int i = 1; i < arregloMateria.length; i++){
            if(arregloMateria[i] != null && !arregloMateria[i].equals("")){
                StringTokenizer st = new StringTokenizer(arregloMateria[i],"-");
                this.addDia(Dia.getDia(i - 1), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

        }
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
                if(horarioMateria.colisiona(horarioMateria2))
                    return true;
            }
        }
        return false;
    }
    
    public String[] toArray(){
        String[] arregloMateria = new String[6];
        arregloMateria[0] = nombreMateria;
        for(HorarioMateria horarioMateria: dias){
            arregloMateria[horarioMateria.dia.getNumero() + 1] = String.format("%d-%d", horarioMateria.horaInicio,horarioMateria.horaFinal);
        }
        return arregloMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }
    
    @Override
    public String toString() {
        String materiaString = nombreMateria + '\n';
        for(HorarioMateria dia: dias){
            materiaString+= dia.toString() + '\n';
        }
        return materiaString;
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
    
 
}
