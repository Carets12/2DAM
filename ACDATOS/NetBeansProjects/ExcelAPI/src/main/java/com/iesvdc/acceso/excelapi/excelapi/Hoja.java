
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
    
    /**
     * Crea una hoja de calculo nueva
     */

    public Hoja() {
        this.datos = new String[5][5];
        this.titulo = "";
        
    }
    
    /**
    *Crea una hoja nueva de tamaño nFilas por nColumnas
    *@param nFilas el número de celdas que iene cada fila
    *@param nColumnas el número de celdas que tiene cada fila
    */
    
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
