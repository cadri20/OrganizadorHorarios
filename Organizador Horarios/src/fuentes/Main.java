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
public class Main {
    
     public static void main(String[] args) {
       ListaMaterias listaMaterias = new ListaMaterias();
       Materia mat1 = new Materia("Fisica");
       mat1.addDia(Dia.LUNES, 10, 11);
       mat1.addDia(Dia.JUEVES, 12, 13);
     
       listaMaterias.add(mat1);
       Horario horario = new Horario(listaMaterias);
       
       
    }
    
}
