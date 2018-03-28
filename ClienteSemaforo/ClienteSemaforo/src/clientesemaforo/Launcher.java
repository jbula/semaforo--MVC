/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesemaforo;

import Presentacion.Modelo;

/**
 *
 * @author Estudiantes
 */
public class Launcher {

    private Modelo miApp;

    public Launcher() {
        miApp = new Modelo();
        miApp.iniciar();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Launcher();
    }
    
}
