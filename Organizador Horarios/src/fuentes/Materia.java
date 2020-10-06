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

    public Materia(String nombreMateria) {
        this.nombreMateria = nombreMateria;
        dias = new ArrayList<>();
    }
    
    public void addDia(Dia dia,int horaInicio, int horaFinal){
        HorarioMateria horarioMateria = new HorarioMateria(dia,horaInicio,horaFinal);
        dias.add(horarioMateria);
    }

    public boolean hayConflicto(Materia materia){
        for(HorarioMateria horarioMateria: dias){
            for(HorarioMateria horarioMateria2: materia.dias){
                if(horarioMateria.colisiona(horarioMateria2))
                    return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String materiaString = nombreMateria + '\n';
        for(HorarioMateria dia: dias){
            materiaString+= dia.toString() + '\n';
        }
        return materiaString;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nombreMateria);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Materia other = (Materia) obj;
        if (!Objects.equals(this.nombreMateria, other.nombreMateria)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
        

    
}
