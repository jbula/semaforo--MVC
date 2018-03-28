/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Sistema.MiSistema;
import Sistema.Semaforo;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Estudiantes
 */
public class Modelo implements Runnable{
    
    private Thread hiloDibujo;
    private Thread hiloTiempo;
    private BufferedImage dobleBuffer; 
    private Vista ventanaPrincipal;
    private MiSistema miSistema;
    private boolean semaforosCreados = false;
    private int ticTac = -1; 
    private boolean intermitenciaL1 =false;
    private Cliente cliente;
    private Servidor servidor;
    private Thread hiloServer;
    private String nombreCliente = "Cliente1";
    
    public Vista getVentanaPrincipal() {
        if(ventanaPrincipal == null){
            ventanaPrincipal = new Vista(this);
        }
        return ventanaPrincipal;
    }
    
    public MiSistema getMiSistema(){
         if(miSistema == null){
            miSistema = new MiSistema();
        }
        return miSistema;
    }
    
    public Modelo(){
        hiloDibujo = new Thread(this);
    }
    
     public void iniciar() {
        Canvas lienzo = getVentanaPrincipal().getLienzo();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        lienzo.setSize((int)(width*0.7), (int)(height*0.8));
        lienzo.setLocation(0, lienzo.getY());
        dobleBuffer = new BufferedImage(lienzo.getWidth(), lienzo.getHeight(), BufferedImage.TYPE_INT_ARGB);
        getVentanaPrincipal().setSize((int)width, (int)height);
 
        getVentanaPrincipal().setVisible(true);
        getMiSistema().setEstaDibujando(true);
        hiloDibujo.start();
        servidor = new Servidor(this);
        //servidor.iniciar();
        hiloServer = new Thread(servidor);
        hiloServer.start();
        cliente = new Cliente("127.0.0.1", 9001);
        cliente.iniciar();
    }
    
    public void dibujar(){
        
        Canvas lienzo = getVentanaPrincipal().getLienzo();
        Graphics lapiz = lienzo.getGraphics();
        Graphics lapizInvisible = dobleBuffer.getGraphics();

        if(semaforosCreados){
            DibujarSemaforos(getMiSistema().getLinea1(), lapizInvisible);
            DibujarSemaforos(getMiSistema().getLinea2(), lapizInvisible);
        }
        lapiz.drawImage(dobleBuffer, 0, 0, lienzo);
        
    } 
    
    private void DibujarSemaforos(ArrayList<Semaforo> linea , Graphics lapizInvisible)
    {
        int posX = 0;
        int posY = 0;

        for(int i=0; i < linea.size(); i++){
            Semaforo semaforo = linea.get(i);
            posX = semaforo.getCoordenadaSemaforo()[0];
            posY = semaforo.getCoordenadaSemaforo()[1];
            lapizInvisible.setColor(Color.BLACK);
            lapizInvisible.fillRect(posX, posY, 60, 160);
            for (int j = 0; j < 3; j++) {
                Color color = semaforo.getBombillos()[j].getColordefecto();
                if(semaforo.isIntermitente()){
                    if(semaforo.getBombillos()[j].isEstaFuncionando() && semaforo.getBombillos()[j].isEstaEncendido() ){
                        if(ticTac == 1){
                            semaforo.getBombillos()[j].setColor(color.darker().darker().darker());
                        }else{
                            semaforo.getBombillos()[j].setColor(color);
                        }
                    }else if(semaforo.getBombillos()[j].isEstaFuncionando() && !semaforo.getBombillos()[j].isEstaEncendido() ){
                        semaforo.getBombillos()[j].setColor(color.darker().darker().darker());
                    }
                    else if(!semaforo.getBombillos()[j].isEstaFuncionando()){
                        semaforo.getBombillos()[j].setColor(Color.GRAY);
                    }
                }else{
                    if(semaforo.getBombillos()[j].isEstaFuncionando() && semaforo.getBombillos()[j].isEstaEncendido() ){
                        semaforo.getBombillos()[j].setColor(color);
                    }else if(semaforo.getBombillos()[j].isEstaFuncionando() && !semaforo.getBombillos()[j].isEstaEncendido() ){
                        semaforo.getBombillos()[j].setColor(color.darker().darker().darker());
                    }
                    else if(!semaforo.getBombillos()[j].isEstaFuncionando()){
                        semaforo.getBombillos()[j].setColor(Color.GRAY);
                    }
                }
                posX = semaforo.getBombillos()[j].getCoordenadas()[0];
                posY = semaforo.getBombillos()[j].getCoordenadas()[1];
                lapizInvisible.setColor(semaforo.getBombillos()[j].getColor());
                lapizInvisible.fillOval(posX, posY, 40, 40);
            }
        }
    }
    
    @Override
    public void run() {
        while (getMiSistema().isEstaDibujando()) {            
            dibujar();
        }
    }

    public void crearSemaforos() {
        int noSemaforosL1 = Integer.parseInt(getVentanaPrincipal().getTxtNoSemaforosL1().getText());
        int noSemaforosL2 = Integer.parseInt(getVentanaPrincipal().getTxtNoSemaforosL2().getText());
        
        for(int i = 0; i< noSemaforosL1; i++){
            getMiSistema().getLinea1().add(new Semaforo(new int[]{70*i, 0}));
        }
        for(int i = 0; i< noSemaforosL2; i++){
            getMiSistema().getLinea2().add(new Semaforo(new int[]{70*i, 300}));
        }
        semaforosCreados=true;
        enviarMensajeServidor();
    }
        
    public void notificarCoordenadas(int x, int y) {
        getMiSistema().setPosX(x);
        getMiSistema().setPosY(y);
        boolean bombilloSeleccionado;
        if (semaforosCreados) {
            bombilloSeleccionado = BuscarBombilloSeleccionado(getMiSistema().getLinea1(), x, y);
            if(bombilloSeleccionado==false){
                BuscarBombilloSeleccionado(getMiSistema().getLinea2(), x, y);
            }
        }

    }
    
    public void notificarSegundo(){
        ticTac = ticTac*-1;
    }
    
    private boolean BuscarBombilloSeleccionado(ArrayList<Semaforo> linea, int x, int y){
        int posX, posY;
        for (int i = 0; i < linea.size(); i++) {
            Semaforo semaforo = linea.get(i);
            posX = semaforo.getCoordenadaSemaforo()[0];
            posY = semaforo.getCoordenadaSemaforo()[1];
            if (posX <= x && x <= posX + 60 && y <= posY + 160 && posY <= y) {                   
                 for (int j = 0; j < 3; j++) {
                    posY = semaforo.getBombillos()[j].getCoordenadas()[1];
                    if (y <= posY + 40 && posY-40 <= y){
                        boolean bombilloF = semaforo.getBombillos()[j].isEstaFuncionando();
                        if (bombilloF==true){
                            semaforo.getBombillos()[j].setEstaFuncionando(false);
                            //semaforo.getBombillos()[j].setColor(Color.GRAY);
                        }else{
                            semaforo.getBombillos()[j].setEstaFuncionando(true);
                            //semaforo.getBombillos()[j].setColor(semaforo.getBombillos()[j].getColordefecto());
                        }
                        enviarMensajeServidor();
                       return true;
                    }

                }
            }
        }
        return false;
    }
    
    
    public void intermitenciaL1( ) {
        if(intermitenciaL1==false){
           intermitenciaL1 = true;
        }else{
             intermitenciaL1 = false;
        }
       
    }
    
    public void intermitenciaL2() {
     
    }

    public String apagarBolbillo() {
        String bombillo=(String)ventanaPrincipal.getBoxBombillosL1().getSelectedItem();
        JOptionPane.showMessageDialog(null, "Boton Apagar "+bombillo);
        return bombillo;
    }
    
    

    public void encenderBolbillo() {
        JOptionPane.showMessageDialog(null, "Boton encender");
    }
    
    public void procesarMensajeRecibido(String mensaje){
        if(!mensaje.contains(",")){
            System.err.println("mensaje no cumple con el formato, no existe separador ,");
            return;
        }else if(mensaje.split(",").length!=2){
            System.err.println("mensaje no cumple con el formato, no existen totalidad de lineas (2)");
            return;
        }
        else if(mensaje.split(",")[0].length()!=4 || mensaje.split(",")[1].length()!=4){
            System.err.println("mensaje no cumple con el formato, no existen totalidad de caracteres para las lineas");
            return;
        }
        String mensajeL1=mensaje.split(",")[0];
        String mensajeL2=mensaje.split(",")[1];
        manipularLinea(getMiSistema().getLinea1(), mensajeL1);
        manipularLinea(getMiSistema().getLinea2(), mensajeL2);
    }
    
    private void manipularLinea(ArrayList<Semaforo> linea, String comando){
        boolean intermitente;
        char instrucciones[] = comando.toCharArray();
        for(int i=0; i<linea.size();i++){
            int contadorBombillo=0;
            intermitente=false;
            for(int j=0; j<instrucciones.length; j++){
                if(j==0){
                    if(instrucciones[j]=='1'){
                        intermitente=true;
                    }
                }else{
                    if(instrucciones[j]=='1'){
                        linea.get(i).getBombillos()[contadorBombillo].setEstaEncendido(true);
                    }else{
                        linea.get(i).getBombillos()[contadorBombillo].setEstaEncendido(false);
                    }
                    contadorBombillo++;
                }
            }
            linea.get(i).setIntermitente(intermitente);
        }
    }
    
    private void enviarMensajeServidor(){
        String mensaje = nombreCliente+";";
        int bombillosL1 [] = CalcularBombillosFuncionando(getMiSistema().getLinea1());
        int bombillosL2 [] = CalcularBombillosFuncionando(getMiSistema().getLinea2());
        for(int i=0; i<bombillosL1.length; i++){
            if(i==bombillosL1.length-1){
                mensaje+= bombillosL1[i] + ";";
            }else{
                mensaje+= bombillosL1[i] + ",";
            }
        }
        for(int i=0; i<bombillosL2.length; i++){
            if(i==bombillosL2.length-1){
                mensaje+= bombillosL2[i];
            }else{
                mensaje+= bombillosL2[i] + ",";
            }
        }
        cliente.EnviarMensaje(mensaje);
    }
    
    private int[] CalcularBombillosFuncionando(ArrayList<Semaforo> linea){
        int funciona=0;
        int bombillos [] = {0,0,0};
        for(int i=0; i<linea.size();i++){
            for(int j=0; j<bombillos.length; j++){
               if(linea.get(i).getBombillos()[j].isEstaFuncionando()){
                   funciona=1;
               }else{
                   funciona=0;
               }
               bombillos[j]+=funciona;
            }
        }
        return bombillos;
    }
}
