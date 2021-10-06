/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuentes;

import java.io.Serializable;

/**
 *
 * @author Adrian Coloma
 */
public class HorarioMateria implements Serializable{
    
    public Dia dia;
    public int horaInicio;
    public int horaFinal;

    public HorarioMateria(Dia dia, int horaInicio, int horaFinal) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }
    
    public boolean colisiona(HorarioMateria horarioMateria){
        if(dia.equals(horarioMateria.dia)){
            boolean esteHorarioEntreElOtro = perteneceIntervalo(horaInicio,horaFinal,horarioMateria.horaInicio,horarioMateria.horaFinal);
            boolean elOtroEntreEsteHorario = perteneceIntervalo(horarioMateria.horaInicio,horarioMateria.horaFinal,horaInicio,horaFinal);
            boolean tienenLimitesIguales = horaInicio == horarioMateria.horaInicio && horaFinal == horarioMateria.horaFinal;
            if(esteHorarioEntreElOtro || elOtroEntreEsteHorario || tienenLimitesIguales)               
                return true;
        }
        return false;
    }
    
    public boolean perteneceIntervalo(int num1, int num2, int limInf, int limSup){
        if(num1 > limInf && num1 < limSup || num2 > limInf && num2 < limSup)
            return true;
        else
            return false;
    }

    @Override
    public String toString(){
        return String.format("Dia = %s Horas = %d-%d",dia,horaInicio,horaFinal);
    }
    
    public int[] filas(int horaMinimaHorario){
        int[] filas = new int[this.horaFinal - this.horaInicio];
        int horaInicioRelativa = horaInicio - horaMinimaHorario;
        //int horaFinalRelativa = horaFinal - 1 - horaMinimaHorario;
        int n = 0;
        for(int i = 0; i < filas.length ; i++){
            filas[i]  = horaInicioRelativa + n;
            n++;
        }
        
        return filas;
    }
    
    public int getTotalHoras(){
        return horaFinal - horaInicio;
    }
}
