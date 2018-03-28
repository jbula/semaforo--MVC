/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import java.util.ArrayList;

/**
 *
 * @author Estudiantes
 */
public class MiSistema {
    
    
    private boolean estaDibujando;   
    private int posX, posY;    
    private ArrayList<Semaforo> linea1;
    private ArrayList<Semaforo> linea2;
    
    public ArrayList<Semaforo> getLinea1() {
        return linea1;
    }
    public ArrayList<Semaforo> getLinea2() {
        return linea2;
    }
    
    public boolean isEstaDibujando() {
        return estaDibujando;
    }
    public void setEstaDibujando(boolean estaDibujando) {
        this.estaDibujando = estaDibujando;
    }

    public MiSistema(){
        linea1 = new ArrayList<Semaforo>();
        linea2 = new ArrayList<Semaforo>();
    }
    
     public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }


}
