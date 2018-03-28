/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Estudiantes
 */
public class Semaforo {

    private Bombillo[] bombillos = new Bombillo[3];
    private int[] coordenadaSemaforo = new int[2];
    private boolean intermitente = false;
    
    public int[] getCoordenadaSemaforo() {
        return coordenadaSemaforo;
    }
    
    public Bombillo[] getBombillos() {
        return bombillos;
    }

    public void setBombills(Bombillo[] bombillos) {
        this.bombillos = bombillos;
    }

    public boolean isIntermitente() {
        return intermitente;
    }

    public void setIntermitente(boolean intermitente) {
        this.intermitente = intermitente;
    }
  
     public Semaforo(int [] coordenada){
        this.coordenadaSemaforo = coordenada;
        bombillos[0] = new Bombillo(true,false,Color.RED, new int[]{coordenada[0]+10, coordenada[1]+10});
        bombillos[1] = new Bombillo(true,false,Color.YELLOW, new int[]{coordenada[0]+10, coordenada[1]+60});
        bombillos[2] = new Bombillo(true,false,Color.GREEN, new int[]{coordenada[0]+10, coordenada[1]+110});
    }
    
    
    
    
}
