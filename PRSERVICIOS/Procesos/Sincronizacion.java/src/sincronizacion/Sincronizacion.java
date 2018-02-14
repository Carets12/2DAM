/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sincronizacion;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matinal
 */
public class Sincronizacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variable contador que manipula todos los hilos
        final Contador contador = new Contador();
        for (int i = 0; i < 50; i++) {
            Thread thread = new IncrementarContador(contador, 
                    (int) (Math.random() * 8));
            thread.start();
        }
    }
    
}

class Contador{
private int contador = 0;

    public void incrementarContador(int valor){
        contador += valor;
        System.out.println("Incrementando: " + valor + " contador: "+contador);
    }
}

class IncrementarContador extends Thread {
    private Contador contador;
    private int cantidad;
    public IncrementarContador(Contador contador, int cantidad){
        super();
        this.contador = contador;
        this.cantidad = cantidad;
    }
    
    public void run(){
        try {
            Thread.sleep((long) (Math.random() * 200));
            contador.incrementarContador(cantidad);
        } catch (InterruptedException ex) {
            Logger.getLogger(IncrementarContador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
