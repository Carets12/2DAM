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
public class AlumnoAsignatura {

    private int asignatura;
    private int alumno;
    private int faltas;    

    public AlumnoAsignatura() {
        
    }        

    public AlumnoAsignatura(int asignatura, int alumno, int faltas) {
        this.asignatura = asignatura;
        this.alumno = alumno;
        this.faltas = faltas;
    }

    public int getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(int asignatura) {
        this.asignatura = asignatura;
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    @Override
    public String toString() {
        return "AlumnoAsignatura: " + "asignatura: " + asignatura + ", alumno: " + alumno + ", faltas: " + faltas;
    }
           
}
