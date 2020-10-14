package utils;
import fuentes.*;
import GUIs.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
/**
 *
 * @author Hp
 */
public class ArchivoUtils {
    public static void guardarHorario(Horario horario, String path){
        try {
            ObjectOutputStream salida = new ObjectOutputStream(Files.newOutputStream(Paths.get(path)));
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
    public static String obtenerPath(){
        JFileChooser fileChooser = new JFileChooser(new File("."));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int resultado = fileChooser.showOpenDialog(null);
        
        if(resultado == JFileChooser.CANCEL_OPTION)
            System.exit(1);
        
        return fileChooser.getSelectedFile().toString();
    }
}
