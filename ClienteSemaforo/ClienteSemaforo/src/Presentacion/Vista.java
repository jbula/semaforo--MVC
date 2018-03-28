/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.Canvas;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Estudiantes
 */
public class Vista extends javax.swing.JFrame {

    public JComboBox<String> getBoxBombillosL1() {
        return boxBombillosL1;
    }

    public JComboBox<String> getBoxBombillosL2() {
        return boxBombillosL2;
    }

    public JButton getBtnApagarL1() {
        return btnApagarL1;
    }

    public JButton getBtnApagarL2() {
        return btnApagarL2;
    }

    public JButton getBtnEncenderL1() {
        return btnEncenderL1;
    }

    public JButton getBtnEncenderL2() {
        return btnEncenderL2;
    }
        public JButton getBtnCrearSemaforos() {
        return btnCrearSemaforos;
    }
    
    public JButton getBtnIntermitenciaL1() {
        return btnIntermitenciaL1;
    }

    public JButton getBtnIntermitenciaL2() {
        return btnIntermitenciaL2;
    }

       
    public JTextField getTxtNoSemaforosL1() {
        return txtNoSemaforosL1;
    }
    public JTextField getTxtNoSemaforosL2() {
        return txtNoSemaforosL2;
    }

    private final Modelo modelo;
    private Controlador control;
    
    public Vista(Modelo aThis) {
         modelo = aThis;
         initComponents();
         capturarEventos();
    }
    
    public Controlador getControl() {
        if(control == null){
            control = new Controlador(this);
        }
        return control;
    }

    public Modelo getModelo() {
        return modelo;
    }
    public Canvas getLienzo() {
        return lienzo;
    }
    
    private void capturarEventos() {
        btnCrearSemaforos.addActionListener(getControl());
        btnIntermitenciaL1.addActionListener(getControl());
        btnIntermitenciaL2.addActionListener(getControl());
        btnApagarL1.addActionListener(getControl());
        btnApagarL2.addActionListener(getControl());        
        btnEncenderL1.addActionListener(getControl());
        btnEncenderL2.addActionListener(getControl());
        lienzo.addMouseMotionListener(getControl());
        lienzo.addMouseListener(getControl());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNoSemaforosL2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNoSemaforosL1 = new javax.swing.JTextField();
        btnCrearSemaforos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtIp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPuerto = new javax.swing.JTextField();
        btnConectar = new javax.swing.JButton();
        lblEstado = new javax.swing.JLabel();
        lienzo = new java.awt.Canvas();
        jLabel5 = new javax.swing.JLabel();
        boxBombillosL1 = new javax.swing.JComboBox<>();
        boxBombillosL2 = new javax.swing.JComboBox<>();
        btnIntermitenciaL1 = new javax.swing.JButton();
        btnIntermitenciaL2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnApagarL1 = new javax.swing.JButton();
        btnEncenderL1 = new javax.swing.JButton();
        btnApagarL2 = new javax.swing.JButton();
        btnEncenderL2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("No. de Semáforos Linea 1 ");

        jLabel2.setText("No. de Semáforos Linea 2 ");

        txtNoSemaforosL1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoSemaforosL1KeyTyped(evt);
            }
        });

        btnCrearSemaforos.setText("Crear Semáforos");
        btnCrearSemaforos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearSemaforosActionPerformed(evt);
            }
        });

        jLabel3.setText("Ip Servidor");

        jLabel4.setText("Puerto");

        btnConectar.setText("Conectar");

        lblEstado.setText("Estado:");

        jLabel5.setText("Linea 1");

        boxBombillosL1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rojo", "Amarillo", "Verde" }));

        boxBombillosL2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rojo", "Amarillo", "Verde" }));
        boxBombillosL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxBombillosL2ActionPerformed(evt);
            }
        });

        btnIntermitenciaL1.setText("Intermitencia");

        btnIntermitenciaL2.setText("Intermitencia");

        jLabel6.setText("Linea 2");
        jLabel6.setToolTipText("");

        btnApagarL1.setText("Apagar");

        btnEncenderL1.setText("Encender");

        btnApagarL2.setText("Apagar");

        btnEncenderL2.setText("Encender");
        btnEncenderL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncenderL2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNoSemaforosL1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNoSemaforosL2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConectar)
                        .addGap(26, 26, 26)
                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnCrearSemaforos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIntermitenciaL1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boxBombillosL2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnApagarL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxBombillosL1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIntermitenciaL2)
                            .addComponent(btnApagarL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEncenderL2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEncenderL1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(187, 187, 187))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConectar)
                        .addComponent(lblEstado)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNoSemaforosL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNoSemaforosL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearSemaforos))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(btnIntermitenciaL1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxBombillosL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnApagarL1)
                            .addComponent(btnEncenderL1))
                        .addGap(174, 174, 174)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(btnIntermitenciaL2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxBombillosL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnApagarL2)
                            .addComponent(btnEncenderL2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNoSemaforosL1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoSemaforosL1KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();evt.consume();}
    }//GEN-LAST:event_txtNoSemaforosL1KeyTyped

    private void boxBombillosL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxBombillosL2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxBombillosL2ActionPerformed

    private void btnCrearSemaforosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearSemaforosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearSemaforosActionPerformed

    private void btnEncenderL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncenderL2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEncenderL2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxBombillosL1;
    private javax.swing.JComboBox<String> boxBombillosL2;
    private javax.swing.JButton btnApagarL1;
    private javax.swing.JButton btnApagarL2;
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnCrearSemaforos;
    private javax.swing.JButton btnEncenderL1;
    private javax.swing.JButton btnEncenderL2;
    private javax.swing.JButton btnIntermitenciaL1;
    private javax.swing.JButton btnIntermitenciaL2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblEstado;
    private java.awt.Canvas lienzo;
    private javax.swing.JTextField txtIp;
    private javax.swing.JTextField txtNoSemaforosL1;
    private javax.swing.JTextField txtNoSemaforosL2;
    private javax.swing.JTextField txtPuerto;
    // End of variables declaration//GEN-END:variables

 

    
}
