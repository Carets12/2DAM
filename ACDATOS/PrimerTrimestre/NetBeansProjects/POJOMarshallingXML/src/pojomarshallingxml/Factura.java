/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojomarshallingxml;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danic
 */

@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)

public class Factura {
    
    private Direccion direccionFacturacion;
    private Cliente cliente;
    private Producto productos;
    private Integer id;
    private Date fecha;

    public Factura() {
    }

    public Factura(Direccion direccionFacturacion, Cliente cliente, Producto productos, Integer id, Date fecha) {
        this.direccionFacturacion = direccionFacturacion;
        this.cliente = cliente;
        this.productos = productos;
        this.id = id;
        this.fecha = fecha;
    }

    public Direccion getDireccionFacturacion() {
        return direccionFacturacion;
    }

    public void setDireccionFacturacion(Direccion direccionFacturacion) {
        this.direccionFacturacion = direccionFacturacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProductos() {
        return productos;
    }

    public void setProductos(Producto productos) {
        this.productos = productos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
