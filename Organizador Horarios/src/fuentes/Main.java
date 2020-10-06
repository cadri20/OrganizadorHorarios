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
public class Main {
    
     public static void main(String[] args) {
       ArrayList<Materia> listaMaterias = new ArrayList<Materia>();
       Materia mat1 = new Materia("Fisica");
       mat1.addDia(Dia.LUNES, 10, 11);
       mat1.addDia(Dia.JUEVES, 12, 13);
       
       Materia mat2 = new Materia("Matematicas");
       mat2.addDia(Dia.LUNES, 14, 15);
       mat2.addDia(Dia.VIERNES, 12, 16);
       
       Materia mat3 = new Materia("Quimica");
       mat3.addDia(Dia.LUNES, 14, 16);
       
       listaMaterias.add(mat1);
       listaMaterias.add(mat2);
       listaMaterias.add(mat3);
       
       Horario horario = new Horario(listaMaterias);
       System.out.println(mat2.hayConflicto(mat1));
       System.out.println(horario.toString());
    }
    
}
