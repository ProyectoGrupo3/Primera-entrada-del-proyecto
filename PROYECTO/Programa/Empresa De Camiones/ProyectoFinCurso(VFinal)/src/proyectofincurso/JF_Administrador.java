package proyectofincurso;

import Controlador.ControladorCRUD_CT;
import Controlador.ControladorCRUD_Trabajador;
import Modelo.CT_CRUD;
import Modelo.Trabajador_CRUD;
import Modelo.*;
import proyectofincurso.*;
import Controlador.*;

public class JF_Administrador extends javax.swing.JFrame {

    /**
     * @return the inicioSesion
     */
    public InicioSesion getInicioSesion() {
        return inicioSesion;
    }

    /**
     * @param inicioSesion the inicioSesion to set
     */
    public void setInicioSesion(InicioSesion inicioSesion) {
        this.inicioSesion = inicioSesion;
    }
    private InicioSesion inicioSesion;

    public JF_Administrador() {
        initComponents();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jB_Trabajador_CRUD = new javax.swing.JButton();
        jB_JF_CT_CRUD = new javax.swing.JButton();
        jB_JF_Vehiculo_CRUD = new javax.swing.JButton();
        jB_JF_Cabe_Parte_CRUD = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jB_JF_Aviso_CRUD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jB_Trabajador_CRUD.setText("Gestión de Trabajadores");
        jB_Trabajador_CRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_Trabajador_CRUDActionPerformed(evt);
            }
        });

        jB_JF_CT_CRUD.setText("Gestión de Centros de Trabajo");
        jB_JF_CT_CRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_JF_CT_CRUDActionPerformed(evt);
            }
        });

        jB_JF_Vehiculo_CRUD.setText("Gestión de Vehículos");
        jB_JF_Vehiculo_CRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_JF_Vehiculo_CRUDActionPerformed(evt);
            }
        });

        jB_JF_Cabe_Parte_CRUD.setText("Gestión de Partes");
        jB_JF_Cabe_Parte_CRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_JF_Cabe_Parte_CRUDActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("HIMEVICO, S.L.");

        jButton8.setLabel("Salir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jB_JF_Aviso_CRUD.setText("Gestión de Avisos");
        jB_JF_Aviso_CRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_JF_Aviso_CRUDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(78, 78, 78))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jB_Trabajador_CRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jB_JF_CT_CRUD, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                            .addComponent(jB_JF_Vehiculo_CRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jB_JF_Cabe_Parte_CRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jB_JF_Aviso_CRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jB_Trabajador_CRUD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jB_JF_CT_CRUD)
                .addGap(12, 12, 12)
                .addComponent(jB_JF_Vehiculo_CRUD)
                .addGap(18, 18, 18)
                .addComponent(jB_JF_Aviso_CRUD)
                .addGap(22, 22, 22)
                .addComponent(jB_JF_Cabe_Parte_CRUD)
                .addGap(48, 48, 48)
                .addComponent(jButton8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_Trabajador_CRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_Trabajador_CRUDActionPerformed
        setVisible(false);
        JF_Trabajador_CRUD vista_Trabajador = new JF_Trabajador_CRUD();
        Trabajador_CRUD modelo_Trabajador = new Trabajador_CRUD();
        ControladorCRUD_Trabajador controlador_Trabajador = new ControladorCRUD_Trabajador(vista_Trabajador, modelo_Trabajador);
        vista_Trabajador.setVisible(true);
        vista_Trabajador.setLocationRelativeTo(null);
        //vista_Trabajador.jB_Leer.doClick();
        vista_Trabajador.jText_2.requestFocus();

    }//GEN-LAST:event_jB_Trabajador_CRUDActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jB_JF_CT_CRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_JF_CT_CRUDActionPerformed
        setVisible(false);
        JF_CT_CRUD vista_CT = new JF_CT_CRUD();
        CT_CRUD modelo_CT = new CT_CRUD();
        ControladorCRUD_CT controlador_CT = new ControladorCRUD_CT(vista_CT, modelo_CT);
        vista_CT.setVisible(true);
        vista_CT.setLocationRelativeTo(null);
        //vista_CT.jB_Leer.doClick();
        vista_CT.jText_2.requestFocus();

    }//GEN-LAST:event_jB_JF_CT_CRUDActionPerformed

    private void jB_JF_Vehiculo_CRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_JF_Vehiculo_CRUDActionPerformed

        setVisible(false);
        JF_Vehiculo_CRUD vista_Vehiculo = new JF_Vehiculo_CRUD();
        Vehiculo_CRUD modelo_Vehiculo = new Vehiculo_CRUD();
        ControladorCRUD_Vehiculo controlador_Vehiculo = new ControladorCRUD_Vehiculo(vista_Vehiculo, modelo_Vehiculo);
        vista_Vehiculo.setVisible(true);
        vista_Vehiculo.setLocationRelativeTo(null);
        //vista_CT.jB_Leer.doClick();
        vista_Vehiculo.jText_2.requestFocus();

    }//GEN-LAST:event_jB_JF_Vehiculo_CRUDActionPerformed

    private void jB_JF_Aviso_CRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_JF_Aviso_CRUDActionPerformed

        setVisible(false);
        JF_Aviso_CRUD vista_Aviso = new JF_Aviso_CRUD();
        Aviso_CRUD modelo_Aviso = new Aviso_CRUD();
        ControladorCRUD_Aviso controlador_Aviso = new ControladorCRUD_Aviso(vista_Aviso, modelo_Aviso);
        vista_Aviso.setVisible(true);
        vista_Aviso.setLocationRelativeTo(null);
        //vista_CT.jB_Leer.doClick();
        vista_Aviso.jText_1.requestFocus();

    }//GEN-LAST:event_jB_JF_Aviso_CRUDActionPerformed

    private void jB_JF_Cabe_Parte_CRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_JF_Cabe_Parte_CRUDActionPerformed

        setVisible(false);
        JF_Cabe_Parte_CRUD vista_Cabe_Parte_CRUD = new JF_Cabe_Parte_CRUD();
        Cabe_Parte_CRUD modelo_Cabe_Parte_CRUD = new Cabe_Parte_CRUD();
        ControladorCRUD_Cabe controlador_Cabe = new ControladorCRUD_Cabe(vista_Cabe_Parte_CRUD, modelo_Cabe_Parte_CRUD);
        vista_Cabe_Parte_CRUD.setVisible(true);
        vista_Cabe_Parte_CRUD.setLocationRelativeTo(null);
        //vista_CT.jB_Leer.doClick();
        vista_Cabe_Parte_CRUD.jText_1.requestFocus();
        
    }//GEN-LAST:event_jB_JF_Cabe_Parte_CRUDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_JF_Aviso_CRUD;
    private javax.swing.JButton jB_JF_CT_CRUD;
    private javax.swing.JButton jB_JF_Cabe_Parte_CRUD;
    private javax.swing.JButton jB_JF_Vehiculo_CRUD;
    private javax.swing.JButton jB_Trabajador_CRUD;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
