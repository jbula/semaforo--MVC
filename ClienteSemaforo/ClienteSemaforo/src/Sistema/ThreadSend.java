/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author DAVID
 */
public class ThreadSend implements Runnable{

    private ObjectOutputStream CanalSalida;
    private String Mensaje;
    private Socket ConectaCliente; 
    private BufferedReader Input;
    
    public ThreadSend(Socket ConectaCliente){
        this.ConectaCliente = ConectaCliente;
        if (ConectaCliente != null){
            this.Mensaje = "Inicio";
        }
    }
    
    @Override
    public void run() {
        
        try {
        CanalSalida = new ObjectOutputStream(ConectaCliente.getOutputStream());
        CanalSalida.flush();
        
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, " Error Thread Send Servidor: \n" + ex.getMessage(), "ADVERTENCIA", ERROR_MESSAGE);
        }   
        
    }
    
    public void SendMessage() {
        Scanner Leer = new Scanner(System.in);
        try {
            this.Mensaje = Leer.nextLine();
            CanalSalida.writeObject(this.Mensaje);
            CanalSalida.flush();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, " Error Thread Send Servidor: \n" + ex.getMessage(), "ADVERTENCIA", ERROR_MESSAGE);
        }

    }
    
}
