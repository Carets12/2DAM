
package com.iesvdc.acceso.excelapi.excelapi;

import java.util.ArrayList;
import java.util.List;

/**
 *Esta clase almacena información de libros para generar ficheros de Excel.
 * Un libro se compone de hojas.
 * 
 * @author Daniel Sierra Ráez
 */
public class Libro {
    private List<Hoja> hojas;
    private String nombreArchivo;

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
    
    public void save(){
        
    }
    
    public void save(String filename){
        this.nombreArchivo = filename;
        this.save();
        
    }
    
}
