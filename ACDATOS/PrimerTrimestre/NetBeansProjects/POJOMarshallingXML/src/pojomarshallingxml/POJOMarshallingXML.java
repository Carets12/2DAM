/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojomarshallingxml;

import java.io.File;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author matinal
 */
public class POJOMarshallingXML {

    /**
     * @param args the command line arguments
     */
   
    
    public static void main(String[] args) {
         Date fechaActual = new Date();
        
        //Creamos el POJO de direccion
        Direccion direccion = new Direccion("Calle", "Luna", "8", "3", "2", "44", "Ubeda", 
                23400, "España", "Jaén");
        
        //Creamos el POJO de producto
        Producto producto = new Producto(12345670,"Martillo", "utilidad", 12);
        
        Cliente cliente = new Cliente("Daniel", "Sierra Ráez", "Daniel@gmail.com", 678765765, "26514356R", 12345678, direccion );
        
        Factura factura = new Factura(direccion, cliente, producto, Integer.SIZE, fechaActual);
        
        try {
            /*Cargamos la configuración para que el "Marshaller" sepa como convertir el POJO  a XML, 
            para eso necesito la clase que previamente estaba con anotacion JAXB.*/
            JAXBContext jbc = JAXBContext.newInstance(direccion.getClass());
            JAXBContext jbp = JAXBContext.newInstance(producto.getClass());
            JAXBContext jbcc = JAXBContext.newInstance(cliente.getClass());
            JAXBContext jbcf = JAXBContext.newInstance(factura.getClass());
            /*Creamos el Marshaller que es el encargado de volcar el objeto a fichero XML, pero OJO este sólo sirve
            para la clase Dirección porque arriba hemos cargado el contexto la clase Dirección*/
            Marshaller jbcm = jbc.createMarshaller();
            Marshaller jbpm = jbp.createMarshaller();
            Marshaller jbccm = jbcc.createMarshaller();
            Marshaller jbcfm = jbcf.createMarshaller();
            //Activar el "HUMAN-FRIENDLY" 
            jbcm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jbcm.marshal(direccion, new File("direccion.xml"));
            
            jbpm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jbpm.marshal(producto, new File("producto.xml"));
            
            jbccm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jbccm.marshal(cliente, new File("cliente.xml"));
            
            jbcfm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jbcfm.marshal(factura, new File("factura.xml"));
            
        } catch (JAXBException ex) {
            Logger.getLogger(POJOMarshallingXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
