package es.vcarmen.socialtech;

import java.io.Serializable;

/**
 * Created by Daniel Sierra Ráez
 */

public class Contacto implements Serializable {
    private String key;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    private String formacion;
    private String provincia;
    private boolean sexo;
    private int edad;

    public Contacto() {
    }

    public Contacto(String nombre, String apellidos, String telefono, String email, String formacion, String provincia, boolean sexo, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.formacion = formacion;
        this.provincia = provincia;
        this.sexo = sexo;
        this.edad = edad;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFormacion() {
        return formacion;
    }

    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Contacto: " +
                "nombre '" + nombre + '\'' + ", apellidos '" + apellidos + '\'' + ", telefono '" + telefono + '\'' +
                ", email '" + email + '\'' + ", formacion '" + formacion + '\'' + ", provincia '" + provincia + '\'' +
                ", sexo " + sexo + ", edad '" + edad + '\'';
    }
}
