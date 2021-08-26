package GUIs;

import fuentes.*;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import utils.ArchivoManager;
import utils.ExcelUtils;

/**
 *
 * @author Hp
 */
public class JFramePrincipal extends javax.swing.JFrame {
    ArrayList<Materia> listaMaterias;
    Materia materia;
    Horario horario;
    boolean estaElHorarioOrdenado;
    ResaltadorTabla resaltador;
    private ArchivoManager archivoManager;
    
    public JFramePrincipal() {
        initComponents();
        listaMaterias = new ArrayList<>();
        materia = new Materia();
        estaElHorarioOrdenado = false;
        ExcelUtils.mapearColores();
        archivoManager = ArchivoManager.getInstance();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBAgregarMateria = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableListaMaterias1 = new javax.swing.JTable();
        jBBorrarMateria = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHorario = new javax.swing.JTable();
        jBGenerarHorario = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jBHorarioOrdenado = new javax.swing.JButton();
        jBAsignarColor = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuGuardarHorario = new javax.swing.JMenuItem();
        jMenuCargarHorario = new javax.swing.JMenuItem();
        jMenuGuardarLista = new javax.swing.JMenuItem();
        jMenuCargarLista = new javax.swing.JMenuItem();
        jMenuExportarExcel = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBAgregarMateria.setText("Agregar Materia");
        jBAgregarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarMateriaActionPerformed(evt);
            }
        });

        jTableListaMaterias1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Materia", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"
            }
        ));
        jScrollPane3.setViewportView(jTableListaMaterias1);

        jBBorrarMateria.setText("Borrar Materia");
        jBBorrarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBorrarMateriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jBAgregarMateria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBBorrarMateria)
                        .addGap(206, 206, 206)))
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregarMateria)
                    .addComponent(jBBorrarMateria))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Materia", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"
            }
        ));
        jScrollPane1.setViewportView(jTableHorario);

        jBGenerarHorario.setText("Generar Horario");
        jBGenerarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGenerarHorarioActionPerformed(evt);
            }
        });

        jButton1.setText("Hora Minima");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Hora Maxima");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jBHorarioOrdenado.setText("Ordenar Horario");
        jBHorarioOrdenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHorarioOrdenadoActionPerformed(evt);
            }
        });

        jBAsignarColor.setText("Asignar color");
        jBAsignarColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAsignarColorActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");

        jMenuGuardarHorario.setText("Guardar Horario");
        jMenuGuardarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGuardarHorarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuGuardarHorario);

        jMenuCargarHorario.setText("Cargar Horario");
        jMenuCargarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCargarHorarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCargarHorario);

        jMenuGuardarLista.setText("Guardar Lista");
        jMenuGuardarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGuardarListaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuGuardarLista);

        jMenuCargarLista.setText("Cargar Lista");
        jMenuCargarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCargarListaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCargarLista);

        jMenuExportarExcel.setText("Exportar a Excel");
        jMenuExportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExportarExcelActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuExportarExcel);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBAsignarColor)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 952, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBHorarioOrdenado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(27, 27, 27))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBGenerarHorario)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(39, 39, 39)
                        .addComponent(jButton2)
                        .addGap(42, 42, 42)
                        .addComponent(jBHorarioOrdenado)
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jBGenerarHorario)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBAsignarColor)
                                .addGap(164, 164, 164))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAgregarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarMateriaActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTableListaMaterias1.getModel();
        String[] filaNula = new String[modelo.getColumnCount()];
        Arrays.fill(filaNula, null);
        modelo.addRow(filaNula);
    }//GEN-LAST:event_jBAgregarMateriaActionPerformed

    private void jBGenerarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGenerarHorarioActionPerformed
        try{
        ArrayList<Materia> listaMateria = (ArrayList) UtilsGUI.tableToList(jTableListaMaterias1);
        horario = new Horario(listaMateria);
        UtilsGUI.mostrarHorarioEnTabla(horario, jTableHorario);
        estaElHorarioOrdenado = false;      
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(this, "No se han agregado materias a la lista","Lista vacía", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBGenerarHorarioActionPerformed

    private void jMenuGuardarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGuardarHorarioActionPerformed
        archivoManager.guardarHorario(horario, archivoManager.obtenerPath("Guardar", archivoManager.extensionHorario));
    }//GEN-LAST:event_jMenuGuardarHorarioActionPerformed

    private void jMenuCargarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCargarHorarioActionPerformed
        String path = archivoManager.obtenerPath("Abrir", archivoManager.extensionHorario);
        if(path != null){
            horario = archivoManager.cargarHorario(path);
            UtilsGUI.mostrarHorarioEnTabla(horario, jTableHorario);    
            resaltador = new ResaltadorTabla(horario);
            jTableHorario.setDefaultRenderer(Object.class, resaltador);
        }       
        
    }//GEN-LAST:event_jMenuCargarHorarioActionPerformed

    private void jMenuGuardarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGuardarListaActionPerformed
        ArrayList<Materia> listaMateria = (ArrayList) UtilsGUI.tableToList(jTableListaMaterias1);
        archivoManager.guardarLista(listaMateria, archivoManager.obtenerPath("Guardar", archivoManager.extensionLista));
    }//GEN-LAST:event_jMenuGuardarListaActionPerformed

    private void jMenuCargarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCargarListaActionPerformed
        String path = archivoManager.obtenerPath("Abrir", archivoManager.extensionLista);
        if(path != null){
            ArrayList<Materia> listaMateria = archivoManager.cargarLista(path);
            UtilsGUI.mostrarListaEnTabla(listaMateria, jTableListaMaterias1);
        }
    }//GEN-LAST:event_jMenuCargarListaActionPerformed

    private void jBBorrarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarMateriaActionPerformed
        int filaSeleccionada = jTableListaMaterias1.getSelectedRow();
        if(filaSeleccionada != -1){
            DefaultTableModel modelo = (DefaultTableModel) jTableListaMaterias1.getModel();
            modelo.removeRow(filaSeleccionada);
        }
            
    }//GEN-LAST:event_jBBorrarMateriaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(this, "Hora minima: " + horario.getHoraMinima());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(this, "Hora maxima: " + horario.getHoraMaxima());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBHorarioOrdenadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHorarioOrdenadoActionPerformed
        jTableHorario.setModel(new DefaultTableModel(horario.getHorarioOrdenado(),Horario.titulosColumnasConHoras));
        estaElHorarioOrdenado = true;
    }//GEN-LAST:event_jBHorarioOrdenadoActionPerformed

    private void jMenuExportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExportarExcelActionPerformed
        String path = archivoManager.obtenerPath("Guardar", "xlsx");
        if(path == null)
            return;
        
        try {
            ExcelUtils.crearArchivoExcel(jTableHorario, path, "Horario",estaElHorarioOrdenado,horario);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        
        }
    }//GEN-LAST:event_jMenuExportarExcelActionPerformed

    private void jBAsignarColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAsignarColorActionPerformed
        int filaSeleccionada = jTableHorario.getSelectedRow();
        String nombreMateriaSeleccionada = (String) jTableHorario.getValueAt(filaSeleccionada, 0);
        Materia materiaSeleccionada = horario.getMateria(nombreMateriaSeleccionada);
        Color colorSeleccionado = JColorChooser.showDialog(rootPane, "Selecciona un color", materiaSeleccionada.getColor());
        
        if(colorSeleccionado == null)
            return;
        
        materiaSeleccionada.setColor(colorSeleccionado);
        
        //UtilsGUI.asignarColor(jTableHorario, horario);
        //ResaltadorTabla resaltador = new ResaltadorTabla(filaSeleccionada, 0, colorSeleccionado);
        //jTableHorario.setDefaultRenderer(Object.class, resaltador);
        resaltador = new ResaltadorTabla(horario);
        jTableHorario.setDefaultRenderer(Object.class, resaltador);
        
    }//GEN-LAST:event_jBAsignarColorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregarMateria;
    private javax.swing.JButton jBAsignarColor;
    private javax.swing.JButton jBBorrarMateria;
    private javax.swing.JButton jBGenerarHorario;
    private javax.swing.JButton jBHorarioOrdenado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCargarHorario;
    private javax.swing.JMenuItem jMenuCargarLista;
    private javax.swing.JMenuItem jMenuExportarExcel;
    private javax.swing.JMenuItem jMenuGuardarHorario;
    private javax.swing.JMenuItem jMenuGuardarLista;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableHorario;
    private javax.swing.JTable jTableListaMaterias1;
    // End of variables declaration//GEN-END:variables
}
