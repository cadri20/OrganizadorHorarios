package utils;

import GUIs.UtilsGUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author cadri
 */
public class ExcelUtils {
    
    public static void crearArchivoExcel(JTable tabla, String rutaArchivo, String nombreHoja) throws IOException{
        crearArchivoExcel(UtilsGUI.tableToArray(tabla), rutaArchivo, nombreHoja);
    }
    
    public static void crearArchivoExcel(String[][] tabla, String rutaArchivo,String nombreHoja) throws FileNotFoundException, IOException{
        File file = new File(rutaArchivo + ".xlsx");
        
        try (FileOutputStream fileOuS = new FileOutputStream(file)) {
            XSSFWorkbook libro = crearWorkbook(tabla, nombreHoja);
            libro.write(fileOuS);
            fileOuS.flush();
        }
           
    }
    
    private static XSSFWorkbook crearWorkbook(String[][] tabla, String nombreHoja){
        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja = libro.createSheet(nombreHoja);
        
        for(int i = 0; i < tabla.length; i++){
            XSSFRow row = hoja.createRow(i);
            for(int j = 0; j < tabla[0].length; j++){
                XSSFCell celda = row.createCell(j);
                celda.setCellValue(tabla[i][j]);
            }
        }        
        
        return libro;
    }
}
