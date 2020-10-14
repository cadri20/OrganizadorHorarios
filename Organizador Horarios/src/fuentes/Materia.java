/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuentes;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author David Arteaga, Ariel Pillajo, Adrian Coloma
 */
public class Materia{
    
    String nombreMateria;
    ArrayList<HorarioMateria> dias;

    public Materia() {
    }

    
    public Materia(String nombreMateria) {
        this.nombreMateria = nombreMateria;
        dias = new ArrayList<>();
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

    
}
