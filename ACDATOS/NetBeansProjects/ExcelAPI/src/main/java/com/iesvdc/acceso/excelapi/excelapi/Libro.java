
package com.iesvdc.acceso.excelapi.excelapi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 *Esta clase almacena información de libros para generar ficheros de Excel.
 * Un libro se compone de hojas.
 * 
 * @author Daniel Sierra Ráez
 */
public class Libro {
    private List<Hoja> hojas;
    private String nombreArchivo;
    private Hoja hoja = new Hoja();

    public Libro() {
        this.hojas = new ArrayList<>();
        this.nombreArchivo = "nuevo.xlsx";
    }

    public Libro(String nombreArchivo) {
        this.hojas = new ArrayList<>();
        this.nombreArchivo = nombreArchivo;      
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    /**
     * Añade una hoja
     * @param hoja 
     * @return  
     */    
    public boolean addHoja(Hoja hoja){
        return this.hojas.add(hoja);
    }
      
    /**
     * Borra una hoja
     * @param index
     * @return 
     * @throws com.iesvdc.acceso.excelapi.excelapi.ExcelAPIException 
     */   
    public Hoja removeHoja(int index) throws ExcelAPIException{
        if(index < 0 || index > this.hojas.size()){
            throw new ExcelAPIException("Libro()::removeHoja(): Posición no válida ");
        }
        return this.hojas.remove(index);
    }
    
    /**
     * Devuelve la posición de la hoja
     * @param index
     * @return 
     * @throws com.iesvdc.acceso.excelapi.excelapi.ExcelAPIException 
     */         
    public Hoja indexHoja(int index) throws ExcelAPIException{
        if(index < 0 || index > this.hojas.size()){
            throw new ExcelAPIException("Libro()::indexHoja(): Posición no válida ");
        }            
       return this.hojas.get(index);
    }
    
    public void load(){
        
    }
    
    public void load(String filename){
        this.nombreArchivo = filename;
        this.load();
    }
    
    public void save() throws ExcelAPIException{       
        SXSSFWorkbook wb = new SXSSFWorkbook();
    
        //Sheet sh = wb.createSheet("Hola Mundo"); 
        /*for (int i = 0; i < this.hojas.size(); i++){
            Hoja hoja = this.hojas.get(i);
        }*/
        for (Hoja hoja: this.hojas) {  
             Sheet sh = wb.createSheet(hoja.getTitulo());             
            for (int i = 0; i < hoja.getFilas(); i++) {
                Row row = sh.createRow(i);
                for (int j = 0; j < hoja.getColumnas(); j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(hoja.getDatos(i, j));                          
                }
            }   
        }            
                
        try (FileOutputStream out = new FileOutputStream(this.nombreArchivo)) {         
            wb.write(out);
            
           // out.close();                        
        } catch (IOException ex) {
            // Logger.getLogger(HolaMundoExcel.class.getName()).log(Level.SEVERE, null, ex);
            /*System.out.println("ERROR al crear el archivo: "+
                    ex.getLocalizedMessage());*/
            throw new ExcelAPIException("Error al guardar el arhivo");
        } finally {
            wb.dispose();
        }
        
    }
    
    public void save(String filename) throws ExcelAPIException{
        this.nombreArchivo = filename;
        this.save();
        
    }
    
    private void testExtension(){
        if ((hoja.getTitulo()) == (nombreArchivo = "*.xlsx")){
            
        }
        String titulo = hoja.getTitulo();
       // titulo = nombreArchivo.subString(nombreArchivo.length -3, nombreArchivo.length);
    //xls.xlsx
    }
    
}
