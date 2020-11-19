package utils;

import GUIs.UtilsGUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author cadri
 */
public class ExcelUtils {

    public static void crearArchivoExcel(JTable tabla, String rutaArchivo, String nombreHoja, boolean unirCeldas) throws IOException {
        String[][] tablaConTitulos = new String[tabla.getRowCount() + 1][tabla.getColumnCount()];
        tablaConTitulos[0] = UtilsGUI.getTitulos(tabla);
        String[][] tablaArray = UtilsGUI.tableToArray(tabla);
        for (int i = 1; i < tablaConTitulos.length; i++) {
            tablaConTitulos[i] = tablaArray[i - 1];
        }
        crearArchivoExcel(tablaConTitulos, rutaArchivo, nombreHoja, unirCeldas);
    }

    public static void crearArchivoExcel(String[][] tabla, String rutaArchivo, String nombreHoja, boolean unirCeldas) throws FileNotFoundException, IOException {
        File file = new File(rutaArchivo + ".xlsx");
        if (file.exists()) {
            int opcionSeleccionada = JOptionPane.showConfirmDialog(null, "El archivo ya existe, ¿Desea sobreescribirlo?", "Archivo existente", JOptionPane.YES_NO_OPTION);
            if (opcionSeleccionada == 1) {
                return;
            }
        }
        try (FileOutputStream fileOuS = new FileOutputStream(file)) {
            XSSFWorkbook libro = crearWorkbook(tabla, nombreHoja, unirCeldas);
            libro.write(fileOuS);
            fileOuS.flush();
        }

    }

    private static XSSFWorkbook crearWorkbook(String[][] tabla, String nombreHoja, boolean unirCeldas) {
        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja = libro.createSheet(nombreHoja);
        CellStyle estilo = bordes(libro);
        for (int i = 0; i < tabla.length; i++) {
            XSSFRow row = hoja.createRow(i);
            for (int j = 0; j < tabla[0].length; j++) {
                XSSFCell celda = row.createCell(j);
                celda.setCellValue(tabla[i][j]);
                celda.setCellStyle(estilo);
            }
        }

        for (int j = 0; j < tabla[0].length; j++) {
            hoja.autoSizeColumn(j);
        }
        if(unirCeldas)
            unirCeldas(hoja, tabla.length, tabla[0].length);
        return libro;
    }

    public static CellStyle bordes(XSSFWorkbook libro){
        CellStyle estilo = libro.createCellStyle();
        estilo.setBorderBottom(BorderStyle.THIN);
        estilo.setBorderTop(BorderStyle.THIN);
        estilo.setBorderLeft(BorderStyle.THIN);
        estilo.setBorderRight(BorderStyle.THIN);
        estilo.setAlignment(HorizontalAlignment.CENTER);
        estilo.setVerticalAlignment(VerticalAlignment.CENTER);
        estilo.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        estilo.setFillPattern(FillPatternType.BIG_SPOTS);
        return estilo;
    }
    
    public static void unirCeldas(XSSFSheet hoja, int numFilas, int numColumnas) {
        for (int j = 0; j < numColumnas; j++) {
            String materiaActual = null;
            int filaMateriaEmpieza = 0;
            int celdasQueSeUniran = 0;
            for (int i = 0; i < numFilas; i++) {
                XSSFRow fila = hoja.getRow(i);
                XSSFCell celda = fila.getCell(j);

                String contenidoCelda = celda.getStringCellValue();
                boolean sonIguales = contenidoCelda.equals(materiaActual);

                if (!sonIguales) {
                    if (materiaActual != null && filaMateriaEmpieza != i - 1 && !materiaActual.isEmpty()) {
                        unirCeldasEnFila(hoja, filaMateriaEmpieza, i - 1, j);
                    }
                    materiaActual = contenidoCelda;
                    filaMateriaEmpieza = i;
                    celdasQueSeUniran = 1;
                } else {
                    celdasQueSeUniran++;
                    if(i == numFilas - 1 && celdasQueSeUniran > 1 && !materiaActual.isEmpty()){
                        unirCeldasEnFila(hoja, filaMateriaEmpieza, i, j);                        
                    }
                }
            }
        }
    }

    public static void unirCeldasEnFila(XSSFSheet hoja, int filaInicio, int filaFinal, int columna) {
        hoja.addMergedRegion(new CellRangeAddress(filaInicio, filaFinal, columna, columna));
    }
    
}
