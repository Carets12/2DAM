/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.vdcarmen.pojo;

/**
 *
 * @author matinal
 */
public class Alumno {
    
    private int id;
    private String nombre;
    private String apellido;

    public Alumno() {
        
    }        
    
    public Alumno(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Alumno(String juan, String sin_Miedo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }                

    @Override
    public String toString() {
        return "Alumno: " + "id: " + id + ", nombre: " + nombre + ", apellido: " + apellido;
    }
        
}
