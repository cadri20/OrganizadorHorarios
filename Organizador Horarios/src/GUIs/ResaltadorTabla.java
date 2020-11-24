package GUIs;

import fuentes.Horario;
import fuentes.Materia;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author cadri
 */
public class ResaltadorTabla extends DefaultTableCellRenderer {

    Horario horario;

    public ResaltadorTabla(Horario horario){
        this.horario = horario;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(horario != null){
            String nombreMateria = (String) value;
            Materia materiaSeleccionada = horario.getMateria(nombreMateria);
            if(materiaSeleccionada != null)
                setBackground(materiaSeleccionada.getColor());
            else{
                setBackground(Color.WHITE);
            }
        }else{
            System.out.println("horario es nulo");
        }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }


}
