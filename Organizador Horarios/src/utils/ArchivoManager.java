/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import fuentes.Horario;
import fuentes.Materia;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Adrian Coloma
 */
public abstract class ArchivoManager {
    public static String extensionHorario = "hor";
    public static String extensionLista = "lis";
    
    public static ArchivoManager getInstance(){
        return new ArchivoManagerXML();
    }
    public abstract Horario cargarHorario(String path);
    public abstract ArrayList<Materia> cargarLista(String path);
    public abstract void guardarHorario(Horario horario, String path);
    public abstract void guardarLista(ArrayList<Materia> listaMaterias, String path);
     
    public String obtenerPath(String textoBoton, String extension){
        JFileChooser fileChooser = new JFileChooser(new File("."));
        fileChooser.setFileFilter(new FileNameExtensionFilter(extension, extension));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int resultado = fileChooser.showDialog(null, textoBoton);
        
        if(resultado == JFileChooser.CANCEL_OPTION)
            return null;
        
        return fileChooser.getSelectedFile().toString();
    }
}
