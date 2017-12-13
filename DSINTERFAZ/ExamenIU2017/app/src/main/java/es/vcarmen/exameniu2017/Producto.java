package es.vcarmen.exameniu2017;

/**
 * DANIEL SIERRA RÁEZ
 */

public class Producto {

    String titulo;
    String descripcion;
    String precio;
    String categoria;
    String fecha;

    public Producto(String titulo, String descripcion, String precio, String categoria, String fecha) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Producto: " +
                "titulo: '" + titulo + '\'' +
                ", descripcion: '" + descripcion + '\'' +
                ", precio: " + precio +
                ", categoria: '" + categoria + '\'' +
                ", fecha: '" + fecha + '\'' +
                '}';
    }
}
