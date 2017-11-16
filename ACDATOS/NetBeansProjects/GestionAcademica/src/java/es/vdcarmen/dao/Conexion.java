/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.vdcarmen.dao;

import java.util.Properties;

/**
 * jdbc:<DRIVER>://<HOST>:<PORT>/<DATABASE_NAME>
 *  y usuario y contraseña
 * @author matinal
 */
public class Conexion {
    
    Properties props ;
    String driver = null;
    String host = null;
    String puerto = null;
    String base_datos = null;
    String usuario = null;
    String password = null;

    public Conexion() {
    }
   
    
}
