package GUIs;

import fuentes.Dia;
import fuentes.Horario;
import fuentes.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hp
 */
public class UtilsGUI {
    static String[][] tableToArray(JTable tabla){
        int numFilas = tabla.getRowCount();
        int numColumnas = tabla.getColumnCount();
        String[][] tablaMatriz = new String[numFilas][numColumnas];
        for(int i = 0; i < numFilas; i++){
            for(int j = 0; j < numColumnas; j++)
                tablaMatriz[i][j] = (String) tabla.getValueAt(i, j);
        }
        
        return tablaMatriz;
    }
    
    static List<Materia> tableToList(JTable tabla){
        List<Materia> listaMaterias = new ArrayList<>();
        for(int i = 0; i < tabla.getRowCount(); i++){
            Materia materia = new Materia(rowToArray(tabla,i));
            listaMaterias.add(materia);
        }
        return listaMaterias;
    }
    
    static String[] rowToArray(JTable tabla, int rowNum){
        int numColumnas = tabla.getRowCount();
        String[] fila = new String[numColumnas];
        for(int i = 0; i < numColumnas; i++){
            fila[i] = (String) tabla.getValueAt(rowNum, i);
        }
        return fila;
    }
   
    static void mostrarHorarioEnTabla(Horario horario, JTable tabla){
        DefaultTableModel modelo = new DefaultTableModel(horario.toArray(),Horario.titulosColumnas);
        tabla.setModel(modelo);        
    }
    
    static void mostrarListaEnTabla(ArrayList<Materia> listaMaterias, JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        for(Materia materia: listaMaterias){
            String[] arregloMateria = materia.toArray();
            modelo.addRow(arregloMateria);
        }
        tabla.setModel(modelo);
    }
}
