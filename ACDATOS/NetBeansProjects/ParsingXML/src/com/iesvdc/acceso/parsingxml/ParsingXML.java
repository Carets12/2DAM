/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.parsingxml;

import com.iesvdc.acceso.dom.DomUtil;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author matinal
 */
public class ParsingXML {
        static Document documento;
        
        static void recursiveWalker(Node nodo){
            if(nodo.hasChildNodes()){
                recursiveWalker(nodo.getFirstChild());
            }
            do{
                System.out.println("Nodo tipo: " + nodo.getNodeType() 
                       +"Nombre"+ nodo.getNodeName());
                
                if (nodo.getNodeType() == Node.TEXT_NODE){
                    
                    System.out.println(" Valor " + nodo.getTextContent() );
                }
                
                nodo = nodo.getNextSibling();
                //Aqui proceso el nodo actual
            } while(nodo.getNextSibling() !=null);
           
        }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException {
        
        if (args.length ==1) {
            try {
                documento = DomUtil.parse(args[0], false);  
                
                //Vamos a imprimir la etiqueta del nodo raiz.
                System.out.println("La etiqueda del nodo raiz es: " +
                        documento.getDocumentElement().getNodeName()+"\n");
                
                //Vamos a comprobar si el priemr hijo del primer hijo existe
                //(tienes nietos en el primer hijo) si lo hay mostramos la etiqueta
                //sino decimos que no hay.
                
                Node raiz = documento.getDocumentElement();
                if (raiz.hasChildNodes()){
                    System.out.println("Raíz "+raiz.getNodeName()+" tiene hijos\n");
                    Node hijo = raiz.getFirstChild();
                    
                    while (hijo != null && hijo.getNodeType() != Node.ELEMENT_NODE){
                        hijo = hijo.getNextSibling();
                     
                    }
                    if (hijo.hasChildNodes()){
                        System.out.println("El hijo "+hijo.getNodeName()+" tiene nietos\n");
                        Node nieto = hijo.getFirstChild();
                        
                        while (nieto != null && nieto.getNodeType() != Node.ELEMENT_NODE){
                        nieto = nieto.getNextSibling();
                        }
                        
                        if(nieto.hasChildNodes()){
                            System.out.println("El nieto "+nieto.getNodeName()+" tiene biznietos");
                            Node biznieto = nieto.getFirstChild();
                            
                            while (biznieto != null && biznieto.getNodeType() != Node.ELEMENT_NODE){
                             biznieto = biznieto.getNextSibling();
                            }
                        }
                    }                  
                }                            
                recursiveWalker(raiz);
            }catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        }else{
            System.out.println("Uso del programa...\n" + "ParsingXML [fichero.xml]\n");                   
        }   
    }
}
