/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matinal
 */
public class Procesos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //Método que ve el número de procesadores que tenemos;
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Nº procesadores del equipo: "
        + runtime.availableProcessors());
        String[] command = {"ping", "www.google.es", "-c2"};
        BufferedInputStream inBuffer = null;
        try {
            Process process = runtime.exec(command);
            System.out.println("Exito : " + process.waitFor());            
            inBuffer = new BufferedInputStream(
                    process.getErrorStream());          
            int c;
            while((c = inBuffer.read()) != -1){
                System.out.print((char)c);
            }            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }finally{
            try {
                inBuffer.close();
            } catch (IOException ex) {
                Logger.getLogger(Procesos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
}
