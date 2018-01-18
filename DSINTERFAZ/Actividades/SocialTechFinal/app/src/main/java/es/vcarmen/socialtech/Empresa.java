package es.vcarmen.socialtech;

import java.io.Serializable;

/**
 * Created by Daniel Sierra Ráez
 */

public class Empresa implements Serializable {

    private String nombre;
    private String direccion;
    private String localidad;
    private String provincia;
    private String telefonoCorporativo;
    private String emailCorporativo;
    private String observaciones;
    private String contacto;

    public Empresa() {
    }

    public Empresa(String nombre, String direccion, String localidad, String provincia, String telefonoCorporativo, String emailCorporativo, String observaciones, String contacto) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.telefonoCorporativo = telefonoCorporativo;
        this.emailCorporativo = emailCorporativo;
        this.observaciones = observaciones;
        this.contacto = contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefonoCorporativo() {
        return telefonoCorporativo;
    }

    public void setTelefonoCorporativo(String telefonoCorporativo) {
        this.telefonoCorporativo = telefonoCorporativo;
    }

    public String getEmailCorporativo() {
        return emailCorporativo;
    }

    public void setEmailCorporativo(String emailCorporativo) {
        this.emailCorporativo = emailCorporativo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contaco) {
        this.contacto = contaco;
    }

    @Override
    public String toString() {
        return "Empresa: " + "nombre '" + nombre + '\'' + ", direccion '" + direccion + '\'' +
                ", localidad '" + localidad + '\'' + ", provincia '" + provincia + '\'' +
                ", telefonoCorporativo '" + telefonoCorporativo + '\'' + ", emailCorporativo '" + emailCorporativo + '\'' +
                ", observaciones '" + observaciones + '\'' + ", contacto '" + contacto + '\'';
    }
}
