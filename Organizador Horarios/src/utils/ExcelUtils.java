package utils;

import GUIs.UtilsGUI;
import fuentes.Horario;
import fuentes.Materia;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.CustomIndexedColorMap;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author cadri
 */
public class ExcelUtils {

    public static void crearArchivoExcel(JTable tabla, String rutaArchivo, String nombreHoja, boolean unirCeldas,Horario horario) throws IOException {
        String[][] tablaConTitulos = new String[tabla.getRowCount() + 1][tabla.getColumnCount()];
        tablaConTitulos[0] = UtilsGUI.getTitulos(tabla);
        String[][] tablaArray = UtilsGUI.tableToArray(tabla);
        for (int i = 1; i < tablaConTitulos.length; i++) {
            tablaConTitulos[i] = tablaArray[i - 1];
        }
    
        crearArchivoExcel(tablaConTitulos, rutaArchivo, nombreHoja, unirCeldas, horario);

    }

    public static void crearArchivoExcel(String[][] tabla, String rutaArchivo, String nombreHoja, boolean unirCeldas, Horario horario) throws FileNotFoundException, IOException {
        File file = new File(rutaArchivo + ".xlsx");
        if (file.exists()) {
            int opcionSeleccionada = JOptionPane.showConfirmDialog(null, "El archivo ya existe, ¿Desea sobreescribirlo?", "Archivo existente", JOptionPane.YES_NO_OPTION);
            if (opcionSeleccionada == 1) {
                return;
            }
        }
        try (FileOutputStream fileOuS = new FileOutputStream(file)) {
            XSSFWorkbook libro = crearWorkbook(tabla, nombreHoja, unirCeldas,horario);
            libro.write(fileOuS);
            fileOuS.flush();
        }

    }

    private static XSSFWorkbook crearWorkbook(String[][] tabla, String nombreHoja, boolean unirCeldas,Horario horario) {
        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja = libro.createSheet(nombreHoja);
        
        for (int i = 0; i < tabla.length; i++) {
            XSSFRow row = hoja.createRow(i);
            for (int j = 0; j < tabla[0].length; j++) {
                XSSFCell celda = row.createCell(j);
                String valor = tabla[i][j];
                celda.setCellValue(valor);
                CellStyle estilo = bordes(libro);
        
                Materia materia = horario.getMateria(valor);
                
                if(materia != null){
                    addColor(materia.getColor(),libro,estilo);
                }else
                    addColor(Color.WHITE,libro,estilo);
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
    
    public static void addColor(Color color, XSSFWorkbook libro, CellStyle estilo){
        Set<Color> coloresMapeados = mapaColores.keySet();
        Color colorMasParecido = obtenerColorMasParecido(color, coloresMapeados);
        IndexedColors colorExcel = mapaColores.get(colorMasParecido);
        estilo.setFillForegroundColor(colorExcel.getIndex());
        estilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    
    }
    
    private static Map<Color,IndexedColors> mapaColores = new HashMap<>();
    public static void mapearColores(){
        
        mapaColores.put(Color.BLUE, IndexedColors.BLUE);
        mapaColores.put(Color.RED, IndexedColors.RED);
        mapaColores.put(Color.PINK, IndexedColors.PINK);
        mapaColores.put(Color.YELLOW, IndexedColors.YELLOW);
        mapaColores.put(Color.ORANGE, IndexedColors.ORANGE);
        mapaColores.put(Color.CYAN, IndexedColors.TURQUOISE);
        mapaColores.put(Color.GREEN, IndexedColors.GREEN);
        mapaColores.put(Color.WHITE, IndexedColors.WHITE);
        mapaColores.put(new Color(51,255,0), IndexedColors.BRIGHT_GREEN);
        mapaColores.put(new Color(255,255,102), IndexedColors.LIGHT_YELLOW);
        mapaColores.put(Color.MAGENTA, IndexedColors.PINK1);
        mapaColores.put(new Color(102,0,255), IndexedColors.INDIGO);
        mapaColores.put(new Color(255,102,255), IndexedColors.ROSE);
    }
    
    public static Color obtenerColorMasParecido(Color colorComparado, Set<Color> colores){
        Color colorMasParecido = null;
        int distanciaMenor = 0;
        for(Color color: colores){
            int distancia = distanciaRGB(color,colorComparado);
            if(colorMasParecido == null || distancia < distanciaMenor){
                colorMasParecido = color;
                distanciaMenor = distancia;
            }
        }
        return colorMasParecido;
    }
    
    public static int distanciaRGB(Color color1, Color color2){
        return Math.abs(color1.getRed() - color2.getRed()) + Math.abs(color1.getGreen() - color2.getGreen()) +
                Math.abs(color1.getBlue() - color2.getBlue());
    }
    
}
