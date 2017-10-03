/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerfichero;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author matinal
 */
public class LeerFichero {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        File fichero = new File("/home/matinal/Escritorio/fichero.txt");
        Scanner sc = null;
        
        try {
            sc = new Scanner(fichero);
            
            while (sc.hasNextLine()){
                //Guardo las lineas en una variable.
                String linea = sc.nextLine();
                //Imprimo las lineas del fichero.
                System.out.println(linea);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado, error");
        } 
    }
    
}
