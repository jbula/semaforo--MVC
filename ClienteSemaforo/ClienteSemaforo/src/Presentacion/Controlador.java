/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Estudiantes
 */
public class Controlador implements ActionListener, MouseListener, MouseMotionListener {

    private final Vista ventana;

    public Controlador(Vista aThis) {
        ventana = aThis;
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("tick");
                ventana.getModelo().notificarSegundo();
            }
        };
        Timer timer = new Timer( 1000, action ) ; 
        timer.start();
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        if (boton.equals(ventana.getBtnCrearSemaforos())) {
            ventana.getModelo().crearSemaforos();
            boton.setEnabled(false);
        } else {
            if (boton.equals(ventana.getBtnIntermitenciaL1())) {
                ventana.getModelo().intermitenciaL1();
            }
            if (boton.equals(ventana.getBtnIntermitenciaL2())) {
                ventana.getModelo().intermitenciaL2();
            }
            if (boton.equals(ventana.getBtnApagarL1())) {
                ventana.getModelo().apagarBolbillo();
            }
            if (boton.equals(ventana.getBtnApagarL2())) {
                ventana.getModelo().apagarBolbillo();
            }
            if (boton.equals(ventana.getBtnEncenderL1())) {
                ventana.getModelo().encenderBolbillo();
            }
            if (boton.equals(ventana.getBtnEncenderL2())) {
                ventana.getModelo().encenderBolbillo();
            }
        }
    }

    
    

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        ventana.getModelo().notificarCoordenadas(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
}
