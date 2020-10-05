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
        ListaMaterias lista = new ListaMaterias();
        Materia mat1 = new Materia("Fisica", Dia.LUNES, "10:0", "20:0");
        lista.add(mat1);
        System.out.println(lista.toString());
        
        System.out.println(mat1.dia.getHoraFinal().toString());
       
    }
    
}
