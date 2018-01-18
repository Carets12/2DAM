/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadornombres;

import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Daniel Sierra
 */
public class GeneradorNombres {
          
    public static void main(String[] args) throws IOException {                            
        ArrayList<Persona> personas = new ArrayList<>();   
        Persona p;   
     
        String nombreMasculino;
        String nombreFemenino;
        String primerApellido;
        String segundoApellido;  
        String sexoMasculino = "masculino" ;
        String sexoFemenino = "femenino" ;

        int monedas;
        int numeroPersonas;

        Scanner entrada=new Scanner(System.in);
        System.out.println("Ingrese numero de personas a generar ");
        numeroPersonas = entrada.nextInt();    
                   
         for (int i = 0; i < numeroPersonas; i++) {
          
          int moneda = (int) Math.floor(Math.random()*2); //Si moneda vale 0 == MASCULINO, si vale 1 == FEMENINO.                
          monedas = moneda;
             
            if(monedas == 0 ){
               p  = new Persona(); 
                    nombreMasculino = p.getNombreMasculino()[new Random().nextInt(p.getNombreMasculino().length)];
                    primerApellido =  p.getApellido()[new Random().nextInt(p.getApellido().length)];
                    segundoApellido =  p.getApellido()[new Random().nextInt(p.getApellido().length)];
                   
                    p.setDni( generarNumerosAleatorios());
                    p.setNombre(nombreMasculino);
                    p.setApellidos(primerApellido+" "+segundoApellido);
                    p.setSexo(sexoMasculino);
                    
                    personas.add(p);              
                    System.out.println(p);
                             
            }else if (monedas == 1) {
               p  = new Persona();         
                    nombreFemenino = p.getNombresFemeninos()[new Random().nextInt(p.getNombresFemeninos().length)];                  
                    primerApellido =  p.getApellido()[new Random().nextInt(p.getApellido().length)];
                    segundoApellido =  p.getApellido()[new Random().nextInt(p.getApellido().length)];
                    
                    p.setDni( generarNumerosAleatorios());
                    p.setNombre(nombreFemenino);
                    p.setApellidos(primerApellido+" "+segundoApellido);
                    p.setSexo(sexoFemenino);
                    
                    personas.add(p);        
                    System.out.println(p);                      
             }   
          }          

        String outputFile = "./personas.csv";
        boolean alreadyExists = new File(outputFile).exists();
         
        if(alreadyExists){
            File ficheroPersonas = new File(outputFile);
            ficheroPersonas.delete();
        }   
        
         try {
         
             CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
             
            csvOutput.write("Dni");
            csvOutput.write("Nombre");
            csvOutput.write("Apellidos");
            csvOutput.write("Sexo");
            csvOutput.endRecord();
      
            
             for (int i = 0; i < personas.size(); i++) {
               p = personas.get(i);
              
               csvOutput.write(p.getDni());
               csvOutput.write(p.getNombre());
               csvOutput.write(p.getApellidos());
               csvOutput.write(p.getSexo());
               csvOutput.endRecord();                                             
             }
          
            csvOutput.close();
         
        } catch (IOException e) {
            e.printStackTrace();
        }
         System.out.println("\nÉXITO:: HAS GENERADO:: " + numeroPersonas+" PERSONAS" + " ::CAMPEÓN!!!!");  
    }

   public static String generarNumerosAleatorios(){
        int idNumero = (int) (Math.random() * 99999999);
        String idLetra = generarLetraDni(idNumero);
        
        return idNumero + idLetra ;
    }
 
    public static String generarLetraDni(int idNumber){   
      String letraDni = "WAGTRCKEMYDXBQVFPNJZSHL";     
      
      return "" + letraDni.charAt(idNumber % 23);      
    }
}


