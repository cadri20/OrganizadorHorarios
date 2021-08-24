/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import fuentes.Horario;
import fuentes.Materia;
import java.util.ArrayList;

/**
 *
 * @author Adrian Coloma
 */
public abstract class ArchivoManager {
    public static String extensionHorario = "hor";
    public static String extensionLista = "lis";
    
    public abstract Horario cargarHorario(String path);
    public abstract ArrayList<Materia> cargarLista(String path);
    public abstract void guardarHorario(Horario horario, String path);
    public abstract void guardarLista(ArrayList<Materia> listaMaterias, String path);
    public abstract String obtenerPath(String textoBoton, String extension);
}
