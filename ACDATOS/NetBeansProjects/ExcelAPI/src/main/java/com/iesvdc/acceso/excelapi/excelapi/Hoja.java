
package com.iesvdc.acceso.excelapi.excelapi;

/**
 * Esta clase almacena información del texto de 
 * una hoja de cálculo.
 * 
 * @author Daniel Sierra Ráez
 */
public class Hoja {
    
    private String[][] datos;
    private String titulo;
    private int nFilas;
    private int nColumnas;
    
    /**
     * Crea una hoja de calculo nueva
     */

    public Hoja() {
        this.datos = new String[5][5];
        this.titulo = "";
        this.nFilas = 5;
        this.nColumnas = 5;
        
    }
    
    /**
    *Crea una hoja nueva de tamaño nFilas por nColumnas
    *@param nFilas el número de celdas que iene cada fila
    *@param nColumnas el número de celdas que tiene cada fila
    */
    
    public Hoja(int nFilas, int nColumnas) {
        this.datos = new String[nFilas][nColumnas];
        this.titulo="";
        this.nFilas = nFilas;
        this.nColumnas = nColumnas;
        
    }
    
    public Hoja(String titulo, int nFilas, int nColumnas) {
        this.datos = new String[nFilas][nColumnas];
         this.titulo=titulo;
         this.nFilas = nFilas;
        this.nColumnas = nColumnas;
        
    }

    public String getDatos(int fila, int columna) throws ExcelAPIException {
        //TO-DO excepción si accedemos a una posición no válida "if, lanzar excepción y return"
        //ni mayor de 5 ni menor de 0
        if(fila < 0 || columna < 0 || fila > this.nFilas || columna > this.nColumnas){
           throw new ExcelAPIException("Hoja()::getDatos(fila,columna): Posición no válida ");
        }
        return datos[fila][columna];
    }

    public void setDatos(String dato, int fila, int columna) throws ExcelAPIException {
        //TO-DO excepción si accedemos a una posición no válida "if, lanzar excepción"
        if(fila < 0 || columna < 0 || fila > this.nFilas || columna > this.nColumnas){
           throw new ExcelAPIException("Hoja()::setDatos(dato,fila,columna): Posición no válida ");
        }
        this.datos[fila][columna] = dato;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getFilas() {
        return nFilas;
    }

    public int getColumnas() {
        return nColumnas;
    }
     
}
