/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuentes;

/**
 *
 * @author David Arteaga, Ariel Pillajo, Adrian Coloma
 */
public class HorarioMateria {
    
    Dia dia;
    int horaInicio;
    int horaFinal;

    public HorarioMateria(Dia dia, int horaInicio, int horaFinal) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }
    
    public boolean colisiona(HorarioMateria horarioMateria){
        if(dia.equals(horarioMateria.dia)){
            if(perteneceIntervalo(horaInicio,horarioMateria.horaInicio,horarioMateria.horaFinal) || perteneceIntervalo(horaFinal,horarioMateria.horaInicio,horarioMateria.horaFinal))               
                return true;
        }
        return false;
    }
    
    public boolean perteneceIntervalo(int num, int limInf, int limSup){
        if(num > limInf && num < limSup)
            return true;
        else
            return false;
    }

    @Override
    public String toString(){
        return String.format("Dia = %s Horas = %d-%d",dia,horaInicio,horaFinal);
    }
    
    
    
}
