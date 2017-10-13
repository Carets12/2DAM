/*

 */
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

    public Hoja() {
        this.datos = new String[0][0];
        this.titulo = "";
        
    }
    
    

    public Hoja(int nFilas, int nColumnas) {
        this.datos = new String[nFilas][nColumnas];
        this.titulo="";
        
    }
    
    
    public Hoja(String titulo, int nFilas, int nColumnas) {
        this.datos = new String[nFilas][nColumnas];
         this.titulo=titulo;
        
    }

    public String getDatos(int fila, int columna) {
        return datos[fila][columna];
    }

    public void setDatos(String dato, int fila, int columna) {
        this.datos[fila][columna] = dato;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}
