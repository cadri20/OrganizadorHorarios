package utils;
import fuentes.*;
import GUIs.*;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Hp
 */
public class ArchivoUtils {
    public static String extensionHorario = "hor";
    public static String extensionLista = "lis";
    public static void guardarHorario(Horario horario, String path){
        try {
            ObjectOutputStream salida = new ObjectOutputStream(Files.newOutputStream(Paths.get(path + "." + extensionHorario)));
            salida.writeObject(horario);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Horario cargarHorario(String path){
        Horario horario = null;
        try {
            ObjectInputStream entrada = new ObjectInputStream(Files.newInputStream(Paths.get(path)));
            horario = (Horario) entrada.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return horario;
    }
    
    public static void guardarLista(ArrayList<Materia> listaMaterias, String path){
        try {
            ObjectOutputStream salida = new ObjectOutputStream(Files.newOutputStream(Paths.get(path + "." + extensionLista)));
            salida.writeObject(listaMaterias);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static ArrayList<Materia> cargarLista(String path){
        ArrayList<Materia> listaMaterias = null;
        try {
            ObjectInputStream entrada = new ObjectInputStream(Files.newInputStream(Paths.get(path)));
            listaMaterias = (ArrayList<Materia>) entrada.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaMaterias;    
    }
    
    public static String obtenerPath(String textoBoton, String extension){
        JFileChooser fileChooser = new JFileChooser(new File("."));
        fileChooser.setFileFilter(new FileNameExtensionFilter(extension, extension));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int resultado = fileChooser.showDialog(null, textoBoton);
        
        if(resultado == JFileChooser.CANCEL_OPTION)
            return null;
        
        return fileChooser.getSelectedFile().toString();
    }
}
