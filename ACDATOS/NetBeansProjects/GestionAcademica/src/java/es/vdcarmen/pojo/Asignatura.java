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
public class Asignatura {
    
    private int id;
    private String nombre;
    private String curso;
    private String ciclo;

    public Asignatura() {
        
    }    

    public Asignatura(int id, String nombre, String curso, String ciclo) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
        this.ciclo = ciclo;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    @Override
    public String toString() {
        return "Asignatura: " + "id: " + id + ", nombre: " + nombre + ", curso: " + curso + ", ciclo: " + ciclo;
    }     
    
}
