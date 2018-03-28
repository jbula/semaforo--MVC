/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author DAVID
 */
public class ThreadReceive implements Runnable{
    private String Mensaje; 
    private ObjectInputStream CanalEntrada;
    private Socket Servidor;
    private boolean conectado;
    
    public ThreadReceive (Socket Servidor){
        this.Servidor = Servidor;
        if (Servidor != null) {
            this.Mensaje = "Inicia";
        }
      conectado = true;
    }
    
    @Override
    public void run() {
        //Declaracion del Canal de Entrada al iniciar la tarea
//        try {
//            CanalEntrada = new ObjectInputStream(Servidor.getInputStream());
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "1.1 Error Thread Recibe Cliente: \n" + ex.getMessage(), "ADVERTENCIA", ERROR_MESSAGE);
//        }
        while (conectado) {
            try {
                InputStream input = Servidor.getInputStream();
                CanalEntrada = new ObjectInputStream(input);
                Mensaje = (String) CanalEntrada.readObject();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, " 1.2 Error Thread Recibe Cliente: \n" + ex.getMessage(), "ADVERTENCIA", ERROR_MESSAGE);
            }
            System.out.println("Mensaje " + Mensaje);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadReceive.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            CanalEntrada.close();
            Servidor.close();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "1.3 Error Thread Recibe Cliente: \n" + ex.getMessage(), "ADVERTENCIA", ERROR_MESSAGE);
        }
    
    }
    
}
