/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.net.*;
import java.io.*;

public class Servidor implements Runnable
{
    ServerSocket server;
    Socket socket;
    int puerto=9000;
    DataOutputStream salida;
    BufferedReader entrada;
    Modelo modelo;
    
    public Servidor(Modelo modelo){
        this.modelo = modelo;
    }
    
    private void iniciar(){
        try{
            System.out.println("Se inició servidor socket");
            server = new ServerSocket(puerto);
            socket = new Socket();
            socket = server.accept();

            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                String mensaje = entrada.readLine();
                System.out.println("Recibi mensaje: " + mensaje);
                salida = new DataOutputStream(socket.getOutputStream());
                salida.writeUTF("Hola Soy Servidor, recibi el siguiente mensaje: " + mensaje);
                modelo.procesarMensajeRecibido(mensaje);
                //Thread.sleep(100);
            }   
            //socket.close();
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }

    }

    @Override
    public void run() {
        iniciar();
    }
}