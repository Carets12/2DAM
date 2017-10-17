package com.iesvirgendelcarmen.dam.listviewdemo;

/**
 * Created by matinal on 16/10/17.
 */

public class Persona{

    private String nombre;
    private String apellidos;

    public Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return
                "nombre '" + nombre + '\'' +
                ", apellidos '" + apellidos + '\''
                ;
    }
}
