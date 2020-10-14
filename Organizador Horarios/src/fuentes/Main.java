/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuentes;

import GUIs.JFramePrincipal;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author David Arteaga, Ariel Pillajo, Adrian Coloma
 */
public class Main {
    public static Horario horario;
    public static void main(String[] args) {
        /*ArrayList<Materia> listaMaterias = new ArrayList<Materia>();
        Materia mat1 = new Materia("Fisica");
        mat1.addDia(Dia.LUNES, 10, 11);
        mat1.addDia(Dia.JUEVES, 12, 13);

        Materia mat2 = new Materia("Matematicas");
        mat2.addDia(Dia.LUNES, 14, 15);
        mat2.addDia(Dia.VIERNES, 12, 16);

        Materia mat3 = new Materia("Quimica");
        mat3.addDia(Dia.LUNES, 14, 16);
        */
        Materia mat4 = new Materia("Fisica");
        mat4.addDia(Dia.MARTES, 9, 13);
        /*
        Materia mat5 = new Materia("Geometria");
        mat5.addDia(Dia.MARTES, 12, 13);

        listaMaterias.add(mat1);
        listaMaterias.add(mat2);
        listaMaterias.add(mat3);
        listaMaterias.add(mat4);
        listaMaterias.add(mat5);

        horario = new Horario(listaMaterias);
        System.out.println(horario.toString());
        for (String[] arreglo : horario.toArray()) {
            System.out.println(Arrays.toString(arreglo));
        }
        */
        Materia mat6 = new Materia(mat4.toArray());
        System.out.println(mat6.toString());
        new JFramePrincipal().setVisible(true);
    }

    
}
