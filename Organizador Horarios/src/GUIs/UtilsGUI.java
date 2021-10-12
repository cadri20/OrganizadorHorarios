package GUIs;

import fuentes.Dia;
import fuentes.Horario;
import fuentes.HorarioMateria;
import fuentes.Materia;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cadri
 */
public class UtilsGUI {
    public static String[][] tableToArray(JTable tabla){
        int numFilas = tabla.getRowCount();
        int numColumnas = tabla.getColumnCount();
        String[][] tablaMatriz = new String[numFilas][numColumnas];
        for(int i = 0; i < numFilas; i++){
            for(int j = 0; j < numColumnas; j++)
                tablaMatriz[i][j] = (String) tabla.getValueAt(i, j);
        }
        
        return tablaMatriz;
    }
    
    public static List<Materia> tableToList(JTable tabla){
        List<Materia> listaMaterias = new ArrayList<>();
        for(int i = 0; i < tabla.getRowCount(); i++){
            Materia materia = new Materia(rowToArray(tabla,i));
            listaMaterias.add(materia);
        }
        return listaMaterias;
    }
    
    public static String[] rowToArray(JTable tabla, int rowNum){
        int numColumnas = tabla.getColumnCount();
        String[] fila = new String[numColumnas];
        for(int i = 0; i < numColumnas; i++){
            Object valor = tabla.getValueAt(rowNum, i);
            if(valor instanceof Integer)
                fila[i] = Integer.toString((Integer) valor);
            else
                fila[i] = (String) valor;
        }
        return fila;
    }
   
    public static void mostrarHorarioEnTabla(Horario horario, JTable tabla){
        DefaultTableModel modelo = new DefaultTableModel(horario.toArray(),Horario.titulosColumnas);
        tabla.setModel(modelo);        
    }
    
    public static void mostrarListaEnTabla(ArrayList<Materia> listaMaterias, JTable tabla){
        if(listaMaterias == null){
            JOptionPane.showMessageDialog(null, "La lista de materias es nula");
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        for(Materia materia: listaMaterias){
            String[] arregloMateria = materia.toArray();
            modelo.addRow(arregloMateria);
        }
        tabla.setModel(modelo);
    }
    
    public static void mostrarConflictos(String[][] conflictos, JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        for (String[] conflicto : conflictos) {          
            modelo.addRow(conflicto);
        }
        tabla.setModel(modelo);
    }
    public static String[] getTitulos(JTable tabla){
        String[] titulos = new String[tabla.getColumnCount()];
        for(int i = 0; i < titulos.length; i++){
            titulos[i] = tabla.getColumnName(i);
        }
        return titulos;
    }
    
    public static void asignarColor(JTable tabla, Horario horario){
        int filaSeleccionada = tabla.getSelectedRow();
        String nombreMateriaSeleccionada = (String) tabla.getValueAt(filaSeleccionada, 0);
        Materia materiaSeleccionada = horario.getMateria(nombreMateriaSeleccionada);
        Color colorSeleccionado = JColorChooser.showDialog(null, nombreMateriaSeleccionada, Color.WHITE);
        
        materiaSeleccionada.setColor(colorSeleccionado);        
    }
    
    public static void colorearCelda(JTable tabla, int fila, int columna, Color color){
        tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                 if(row == fila && column == columna)
                     setBackground(color);
                 return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
            
        });
    }
    
    public class ResaltadorTabla extends DefaultTableCellRenderer{
        Horario horario;

        public ResaltadorTabla(Horario horario) {
            this.horario = horario;
        }
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            String valorCelda = (String) value;
            Materia materia = horario.getMateria(valorCelda);
            if(materia != null)
                setBackground(materia.getColor());
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        }

        
    }
}
