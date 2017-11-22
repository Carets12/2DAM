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
public class ProfesorAsignaturas {
    
    private int asignatura;
    private int profesor;
    private int horaSemanales;

    public ProfesorAsignaturas() {
        
    }       

    public ProfesorAsignaturas(int asignatura, int profesor, int horaSemanales) {
        this.asignatura = asignatura;
        this.profesor = profesor;
        this.horaSemanales = horaSemanales;
    }

    public int getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(int asignatura) {
        this.asignatura = asignatura;
    }

    public int getProfesor() {
        return profesor;
    }

    public void setProfesor(int profesor) {
        this.profesor = profesor;
    }

    public int getHoraSemanales() {
        return horaSemanales;
    }

    public void setHoraSemanales(int horaSemanales) {
        this.horaSemanales = horaSemanales;
    }

    @Override
    public String toString() {
        return "ProfesorAsignaturas: " + "asignatura: " + asignatura + ", profesor: " + profesor + ", horaSemanales: " + horaSemanales + '}';
    }         
    
}
