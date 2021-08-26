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
class ArchivoManagerJava extends ArchivoManager{
    @Override
    public void guardarHorario(Horario horario, String path){
        try {
            ObjectOutputStream salida = new ObjectOutputStream(Files.newOutputStream(Paths.get(path + "." + extensionHorario)));
            salida.writeObject(horario);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoManagerJava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Horario cargarHorario(String path){
        Horario horario = null;
        try {
            ObjectInputStream entrada = new ObjectInputStream(Files.newInputStream(Paths.get(path)));
            horario = (Horario) entrada.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ArchivoManagerJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArchivoManagerJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        return horario;
    }
    
    @Override
    public void guardarLista(ArrayList<Materia> listaMaterias, String path){
        try {
            ObjectOutputStream salida = new ObjectOutputStream(Files.newOutputStream(Paths.get(path + "." + extensionLista)));
            salida.writeObject(listaMaterias);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoManagerJava.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    @Override
    public ArrayList<Materia> cargarLista(String path){
        ArrayList<Materia> listaMaterias = null;
        try {
            ObjectInputStream entrada = new ObjectInputStream(Files.newInputStream(Paths.get(path)));
            listaMaterias = (ArrayList<Materia>) entrada.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ArchivoManagerJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArchivoManagerJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaMaterias;    
    }
    
}
