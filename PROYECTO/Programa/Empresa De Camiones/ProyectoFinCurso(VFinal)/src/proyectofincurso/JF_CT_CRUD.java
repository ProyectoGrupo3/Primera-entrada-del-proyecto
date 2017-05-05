package proyectofincurso;

import Controlador.ControladorCRUD_CT;
import Modelo.CT_CRUD;
import java.lang.reflect.Method;
import javax.swing.JOptionPane;
import java.sql.*;
import  proyectofincurso.*;

public class JF_CT_CRUD extends javax.swing.JFrame {
    
    public JF_CT_CRUD() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jText_2 = new javax.swing.JTextField();
        jText_3 = new javax.swing.JTextField();
        jText_4 = new javax.swing.JTextField();
        jText_5 = new javax.swing.JTextField();
        jText_6 = new javax.swing.JTextField();
        jText_7 = new javax.swing.JTextField();
        jText_8 = new javax.swing.JTextField();
        jText_1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();
        jText_Buscar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jB_Leer = new javax.swing.JButton();
        jB_Crear = new javax.swing.JButton();
        jB_Actualizar = new javax.swing.JButton();
        jB_Borrar = new javax.swing.JButton();
        jB_Salir = new javax.swing.JButton();
        jB_Volver = new javax.swing.JButton();
        jB_OK = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD_CT");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre");

        jLabel2.setText("Calle");

        jLabel3.setText("Número");

        jLabel4.setText("Código Postal");

        jLabel5.setText("Ciudad");

        jLabel6.setText("Provincia");

        jLabel7.setText("Teléfono");

        jText_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_2ActionPerformed(evt);
            }
        });

        jText_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_3ActionPerformed(evt);
            }
        });

        jText_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_4ActionPerformed(evt);
            }
        });

        jText_8.setToolTipText("");

        jText_1.setEditable(false);
        jText_1.setDragEnabled(false);
        jText_1.setEnabled(false);
        jText_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_1ActionPerformed(evt);
            }
        });

        jLabel10.setText("ID");

        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "Calle", "Núm", "C_P.", "Ciudad", "Provincia", "Teléfono"
            }
        ));
        jScrollPane2.setViewportView(jTableDatos);

        jText_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_BuscarActionPerformed(evt);
            }
        });

        jLabel11.setText("Buscar por Nombre:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(371, 371, 371)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jText_Buscar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jText_3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel3))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jText_1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel1)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jText_2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jText_4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel4)
                                                .addGap(27, 27, 27)
                                                .addComponent(jText_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jText_6, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jText_7, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addGap(26, 26, 26)
                                        .addComponent(jText_8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jText_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel1)
                    .addComponent(jText_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jText_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jText_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jText_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jText_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jText_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jText_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jText_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 84, 720, -1));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel9.setText("CRUD de CENTROS DE TRABAJO");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 24, -1, -1));

        jB_Leer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Leer.png"))); // NOI18N
        jB_Leer.setText("R - Leer");
        jB_Leer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_LeerActionPerformed(evt);
            }
        });
        getContentPane().add(jB_Leer, new org.netbeans.lib.awtextra.AbsoluteConstraints(756, 60, -1, -1));

        jB_Crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Create.png"))); // NOI18N
        jB_Crear.setText("C-Crear");
        jB_Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_CrearActionPerformed(evt);
            }
        });
        getContentPane().add(jB_Crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(756, 12, -1, -1));

        jB_Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar.png"))); // NOI18N
        jB_Actualizar.setText("U - Actualizar");
        jB_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jB_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 108, -1, -1));

        jB_Borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Borrar.png"))); // NOI18N
        jB_Borrar.setText("D - Borrar");
        getContentPane().add(jB_Borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(744, 156, -1, -1));

        jB_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Exit.png"))); // NOI18N
        jB_Salir.setText("Salir");
        jB_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_SalirActionPerformed(evt);
            }
        });
        getContentPane().add(jB_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 420, -1, -1));

        jB_Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Back.png"))); // NOI18N
        jB_Volver.setText("Volver");
        jB_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_VolverActionPerformed(evt);
            }
        });
        getContentPane().add(jB_Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(756, 360, -1, -1));

        jB_OK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ok.png"))); // NOI18N
        jB_OK.setText("Ok");
        jB_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_OKActionPerformed(evt);
            }
        });
        getContentPane().add(jB_OK, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 216, 72, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jText_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_4ActionPerformed

    private void jText_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_2ActionPerformed

    }//GEN-LAST:event_jText_2ActionPerformed

    private void jB_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_VolverActionPerformed
        setVisible(false);
        JF_Administrador vista_Adm = new JF_Administrador();
        vista_Adm.setVisible(true);
        vista_Adm.setLocationRelativeTo(null);
    }//GEN-LAST:event_jB_VolverActionPerformed

    private void jText_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_3ActionPerformed

    private void jB_CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_CrearActionPerformed
        JF_CT_CRUD vista_CT = new JF_CT_CRUD();
        CT_CRUD modelo_CT = new CT_CRUD();
        ControladorCRUD_CT controlador_CT = new ControladorCRUD_CT(vista_CT, modelo_CT);
    }//GEN-LAST:event_jB_CrearActionPerformed

    private void jB_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jB_SalirActionPerformed

    private void jB_LeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_LeerActionPerformed
        JF_CT_CRUD vista_CT = new JF_CT_CRUD();
        CT_CRUD modelo_CT = new CT_CRUD();
        ControladorCRUD_CT controlador_CT = new ControladorCRUD_CT(vista_CT, modelo_CT);
        
    }//GEN-LAST:event_jB_LeerActionPerformed

    private void jText_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_BuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_BuscarActionPerformed

    private void jB_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_OKActionPerformed
        JF_CT_CRUD vista_CT = new JF_CT_CRUD();
        CT_CRUD modelo_CT = new CT_CRUD();
        ControladorCRUD_CT controlador_CT = new ControladorCRUD_CT(vista_CT, modelo_CT);

    }//GEN-LAST:event_jB_OKActionPerformed

    private void jB_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_ActualizarActionPerformed

    private void jText_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_1ActionPerformed
        // FALTA CARGAR LA SECUENCIA DEL CT_ID PARA EL NÚMERO CORRELATIVO

    }//GEN-LAST:event_jText_1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_CT_CRUD().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jB_Actualizar;
    public javax.swing.JButton jB_Borrar;
    public javax.swing.JButton jB_Crear;
    public javax.swing.JButton jB_Leer;
    public javax.swing.JButton jB_OK;
    public javax.swing.JButton jB_Salir;
    public javax.swing.JButton jB_Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public javax.swing.JTable jTableDatos;
    public javax.swing.JTextField jText_1;
    public javax.swing.JTextField jText_2;
    public javax.swing.JTextField jText_3;
    public javax.swing.JTextField jText_4;
    public javax.swing.JTextField jText_5;
    public javax.swing.JTextField jText_6;
    public javax.swing.JTextField jText_7;
    public javax.swing.JTextField jText_8;
    public javax.swing.JTextField jText_Buscar;
    // End of variables declaration//GEN-END:variables
}
