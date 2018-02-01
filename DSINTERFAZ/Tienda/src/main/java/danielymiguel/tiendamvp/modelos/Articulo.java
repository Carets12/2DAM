package danielymiguel.tiendamvp.modelos;

import java.io.Serializable;

/**
 * POJO de Articulo, serializable para poder ser parcheado el json.
 */

public class Articulo implements Serializable {
    private int codigo;
    private String nombre;
    private String categoria;
    private int stock;
    private String descripcion;

    public Articulo() {
    }

    public Articulo(int codigo, String nombre, String categoria, int stock, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", stock=" + stock +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}
