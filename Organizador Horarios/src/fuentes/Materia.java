/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuentes;

import java.util.ArrayList;

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

    public boolean comparar(Materia materia){
        return false;
    }
    
    
    
    
    
    
        

    
}
