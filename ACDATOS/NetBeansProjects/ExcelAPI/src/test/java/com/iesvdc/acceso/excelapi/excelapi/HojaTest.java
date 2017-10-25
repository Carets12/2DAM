/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.excelapi.excelapi;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matinal
 */
public class HojaTest {
    
    public HojaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDatos method, of class Hoja.
     */
    @Test
    public void testGetDatos() throws Exception {
        System.out.println("getDatos");
        int fila = 0;
        int columna = 0;
        Hoja instance = new Hoja();
        String expResult = "";
        String result = instance.getDatos(fila, columna);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDatos method, of class Hoja.
     */
    @Test
    public void testSetDatos() throws Exception {
        System.out.println("setDatos");
        String dato = "";
        int fila = 0;
        int columna = 0;
        Hoja instance = new Hoja();
        instance.setDatos(dato, fila, columna);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitulo method, of class Hoja.
     */
    @Test
    public void testGetTitulo() {
        System.out.println("getTitulo");
        Hoja instance = new Hoja();
        String expResult = "";
        String result = instance.getTitulo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitulo method, of class Hoja.
     */
    @Test
    public void testSetTitulo() {
        System.out.println("setTitulo");
        String titulo = "";
        Hoja instance = new Hoja();
        instance.setTitulo(titulo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFilas method, of class Hoja.
     */
    @Test
    public void testGetFilas() {
        System.out.println("getFilas");
        Hoja instance = new Hoja();
        int expResult = 0;
        int result = instance.getFilas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnas method, of class Hoja.
     */
    @Test
    public void testGetColumnas() {
        System.out.println("getColumnas");
        Hoja instance = new Hoja();
        int expResult = 0;
        int result = instance.getColumnas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
