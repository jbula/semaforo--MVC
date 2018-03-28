/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import java.awt.Color;

/**
 *
 * @author Estudiantes
 */
public class Bombillo {

    private boolean estaFuncionando;
    private boolean estaEncendido;
    private Color color;
    private int [] coordenadas = new int[2];
    private Color colordefecto;
    
    
    public Color getColordefecto() {
        return colordefecto;
    }
    public int[] getCoordenadas() {
        return coordenadas;
    }
    
    public boolean isEstaFuncionando() {
        return estaFuncionando;
    }

    /**
     * @param estaFuncionando the estaFuncionando to set
     */
    public void setEstaFuncionando(boolean estaFuncionando) {
        this.estaFuncionando = estaFuncionando;
    }

    /**
     * @return the estaEncendido
     */
    public boolean isEstaEncendido() {
        return estaEncendido;
    }

    /**
     * @param estaEncendido the estaEncendido to set
     */
    public void setEstaEncendido(boolean estaEncendido) {
        this.estaEncendido = estaEncendido;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
    
    public Bombillo(boolean estaFuncionando, boolean estaEncendido, Color color, int[] coordenada){
        this.estaFuncionando = estaFuncionando;
        this.estaEncendido = estaEncendido;
        this.color = color;
        this.coordenadas = coordenada;
        this.colordefecto = color;
    }
}
