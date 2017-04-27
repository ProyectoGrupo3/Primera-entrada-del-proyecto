package proyectofincurso;

import Controlador.ControladorCRUD_CT;
import Controlador.ControladorCRUD_Trabajador;
import Modelo.CT_CRUD;
import Modelo.Trabajador_CRUD;
import Modelo.*;
import proyectofincurso.*;
import Controlador.*;

public class JF_Administrador extends javax.swing.JFrame {

    public JF_Administrador() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jB_Trabajador_CRUD = new javax.swing.JButton();
        jB_JF_CT_CRUD = new javax.swing.JButton();
        jB_JF_Vehiculo_CRUD = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

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

        jButton4.setText("Visualizar Partes");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trabajadores y Rango de fechas", "Rango de fechas" }));

        jLabel1.setText("Filtrar por →");

        jButton5.setText("Validar Parte");

        jButton6.setText("Modificar y eliminar Partes");

        jButton7.setText("Modificar contraseña");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("HIMEVICO, S.L.");

        jButton8.setLabel("Salir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jB_Trabajador_CRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jB_JF_CT_CRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jB_JF_Vehiculo_CRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jB_Trabajador_CRUD)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addGap(15, 15, 15)
                .addComponent(jB_JF_CT_CRUD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jB_JF_Vehiculo_CRUD)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(33, 33, 33)
                .addComponent(jButton8)
                .addGap(19, 19, 19))
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
        new JF_Vehiculo_CRUD().setVisible(true);

    }//GEN-LAST:event_jB_JF_Vehiculo_CRUDActionPerformed

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
    private javax.swing.JButton jB_JF_CT_CRUD;
    private javax.swing.JButton jB_JF_Vehiculo_CRUD;
    private javax.swing.JButton jB_Trabajador_CRUD;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
