/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    Socket socket;
    int puerto;
    String ip;
    BufferedReader entrada, teclado;
    PrintStream salida;
    
    public Cliente(String ip, int puerto){
        this.ip=ip;
        this.puerto=puerto;
    }
    
    public void iniciar(){
        try{
            socket = new Socket(ip, puerto);
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //teclado = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Se inició cliente socket");
        }catch(Exception ex){
            System.err.println("Error: " + ex.getMessage());
        }

    }
    
    public void EnviarMensaje(String mensaje){
        try {
            salida = new PrintStream(socket.getOutputStream());
            salida.println(mensaje);
            //String mensajeServidor = entrada.readLine();
            //System.out.println(mensajeServidor);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CerrarSocket(){
        try {
            entrada.close();
            salida.close();
            teclado.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

