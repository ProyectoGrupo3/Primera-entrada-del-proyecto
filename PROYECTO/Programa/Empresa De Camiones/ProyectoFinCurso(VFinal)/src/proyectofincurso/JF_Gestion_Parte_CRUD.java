
package proyectofincurso;

import Controlador.ControladorCRUD_Cabe;
import Controlador.ControladorCRUD_Gestion_Parte;
import Modelo.Cabe_Parte_CRUD;
import Modelo.Gestion_Parte_CRUD;

public class JF_Gestion_Parte_CRUD extends javax.swing.JFrame {

    public JF_Gestion_Parte_CRUD() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("jdbc:oracle:thin:@192.168.56.101:1521:XEPU").createEntityManager();
        vehiculoQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT v FROM Vehiculo v");
        vehiculoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : vehiculoQuery.getResultList();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        centroTrabajoQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM CentroTrabajo c");
        centroTrabajoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : centroTrabajoQuery.getResultList();
        vehiculoQuery1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT v FROM Vehiculo v");
        vehiculoList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : vehiculoQuery1.getResultList();
        jB_Borrar = new javax.swing.JButton();
        jB_OK = new javax.swing.JButton();
        jB_Volver = new javax.swing.JButton();
        jB_Salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jCB_Cerrado = new javax.swing.JCheckBox();
        jCB_Verificado = new javax.swing.JCheckBox();
        jCB_Buscar_SiNo = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTE_Fecha = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTE_Vehiculo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTE_NombreTrabajador = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTE_kmi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTE_kmf = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTE_Gasoil = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTE_Autopista = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTE_Dietas = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTE_Otros = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTE_Incidencias = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jTE_Hextras = new javax.swing.JTextField();
        jCE_Cerrado = new javax.swing.JCheckBox();
        jCE_Verificado = new javax.swing.JCheckBox();
        jTextField_id = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jB_Crear = new javax.swing.JButton();
        jB_Leer = new javax.swing.JButton();
        jB_Actualizar = new javax.swing.JButton();

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
        jScrollPane4.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jB_Borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Borrar.png"))); // NOI18N
        jB_Borrar.setText("D - Borrar");
        getContentPane().add(jB_Borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(732, 228, -1, -1));

        jB_OK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ok.png"))); // NOI18N
        jB_OK.setText("Ok");
        jB_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_OKActionPerformed(evt);
            }
        });
        getContentPane().add(jB_OK, new org.netbeans.lib.awtextra.AbsoluteConstraints(732, 276, 72, -1));

        jB_Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Back.png"))); // NOI18N
        jB_Volver.setText("Volver");
        jB_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_VolverActionPerformed(evt);
            }
        });
        getContentPane().add(jB_Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(732, 348, -1, -1));

        jB_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Exit.png"))); // NOI18N
        jB_Salir.setText("Salir");
        jB_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_SalirActionPerformed(evt);
            }
        });
        getContentPane().add(jB_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(744, 432, -1, -1));

        jLabel1.setText("GESTIÓN DE LOS PARTES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 12, 173, 48));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por"));
        jPanel1.setLayout(null);

        jLabel5.setText("Fecha:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(36, 24, 50, 25);

        jCB_Cerrado.setText("Cerrado");
        jCB_Cerrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_CerradoActionPerformed(evt);
            }
        });
        jPanel1.add(jCB_Cerrado);
        jCB_Cerrado.setBounds(252, 24, 81, 23);

        jCB_Verificado.setText("Verificado");
        jPanel1.add(jCB_Verificado);
        jCB_Verificado.setBounds(360, 24, 95, 23);

        jCB_Buscar_SiNo.setText("BUSCAR");
        jCB_Buscar_SiNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_Buscar_SiNoActionPerformed(evt);
            }
        });
        jPanel1.add(jCB_Buscar_SiNo);
        jCB_Buscar_SiNo.setBounds(480, 24, 81, 23);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(108, 24, 113, 25);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 60, 648, 72));

        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTableDatos);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 396, 660, 175));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setText("Fecha:");

        jLabel9.setText("Vehiculo:");

        jLabel10.setText("Trabajador:");

        jTE_NombreTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTE_NombreTrabajadorActionPerformed(evt);
            }
        });

        jLabel11.setText("Km Inicial:");

        jLabel12.setText("Km Final:");

        jTE_kmf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTE_kmfActionPerformed(evt);
            }
        });

        jLabel13.setText("Gasoil:");

        jTE_Gasoil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTE_GasoilActionPerformed(evt);
            }
        });

        jLabel14.setText("Autopista:");

        jLabel15.setText("Dietas:");

        jLabel16.setText("Otros:");

        jTE_Incidencias.setColumns(20);
        jTE_Incidencias.setRows(5);
        jTE_Incidencias.setText("Incidencias:");
        jScrollPane6.setViewportView(jTE_Incidencias);

        jLabel17.setText("H.Extas:");

        jCE_Cerrado.setText("Cerrado");
        jCE_Cerrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCE_CerradoActionPerformed(evt);
            }
        });

        jCE_Verificado.setText("Verificado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(28, 28, 28)
                                        .addComponent(jTE_kmi, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTE_kmf, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTE_NombreTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTE_Fecha)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jTE_Vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTE_Gasoil, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTE_Autopista, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTE_Dietas, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTE_Otros, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jCE_Cerrado)
                                        .addGap(20, 20, 20)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCE_Verificado)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTE_Hextras, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 22, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTE_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTE_Vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTE_NombreTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jTE_kmi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(jTE_kmf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCE_Verificado)
                        .addComponent(jCE_Cerrado)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(jTE_Gasoil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTE_Autopista, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTE_Dietas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTE_Otros, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(jTE_Hextras, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 168, -1, -1));
        jPanel2.getAccessibleContext().setAccessibleName("Edición");
        jPanel2.getAccessibleContext().setAccessibleDescription("Edición");

        jLabel18.setText("EDICION");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 144, -1, -1));

        jB_Crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Create.png"))); // NOI18N
        jB_Crear.setText("C-Crear");
        jB_Crear.setEnabled(false);
        jB_Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_CrearActionPerformed(evt);
            }
        });

        jB_Leer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Leer.png"))); // NOI18N
        jB_Leer.setText("R - Leer");
        jB_Leer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_LeerActionPerformed(evt);
            }
        });

        jB_Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar.png"))); // NOI18N
        jB_Actualizar.setText("U - Actualizar");
        jB_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_Crear)
                    .addComponent(jB_Leer)
                    .addComponent(jB_Actualizar))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jB_Crear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_Leer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_Actualizar)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 60, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_LeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_LeerActionPerformed

    }//GEN-LAST:event_jB_LeerActionPerformed

    private void jB_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_ActualizarActionPerformed

    private void jB_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_OKActionPerformed
        
    }//GEN-LAST:event_jB_OKActionPerformed

    private void jB_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_VolverActionPerformed
        setVisible(false);
        JF_Administrador vista_Adm = new JF_Administrador();
        vista_Adm.setVisible(true);
        vista_Adm.setLocationRelativeTo(null);
    }//GEN-LAST:event_jB_VolverActionPerformed

    private void jB_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jB_SalirActionPerformed

    private void jCB_CerradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_CerradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCB_CerradoActionPerformed

    private void jB_CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_CrearActionPerformed

    }//GEN-LAST:event_jB_CrearActionPerformed

    private void jTE_NombreTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTE_NombreTrabajadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTE_NombreTrabajadorActionPerformed

    private void jTE_kmfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTE_kmfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTE_kmfActionPerformed

    private void jTE_GasoilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTE_GasoilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTE_GasoilActionPerformed

    private void jCE_CerradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCE_CerradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCE_CerradoActionPerformed

    private void jCB_Buscar_SiNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_Buscar_SiNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCB_Buscar_SiNoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_Gestion_Parte_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Gestion_Parte_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Gestion_Parte_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Gestion_Parte_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Gestion_Parte_CRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<proyectofincurso.CentroTrabajo> centroTrabajoList;
    private javax.persistence.Query centroTrabajoQuery;
    private javax.persistence.EntityManager entityManager;
    public javax.swing.JButton jB_Actualizar;
    public javax.swing.JButton jB_Borrar;
    public javax.swing.JButton jB_Crear;
    public javax.swing.JButton jB_Leer;
    public javax.swing.JButton jB_OK;
    public javax.swing.JButton jB_Salir;
    public javax.swing.JButton jB_Volver;
    public javax.swing.JCheckBox jCB_Buscar_SiNo;
    public javax.swing.JCheckBox jCB_Cerrado;
    public javax.swing.JCheckBox jCB_Verificado;
    public javax.swing.JCheckBox jCE_Cerrado;
    public javax.swing.JCheckBox jCE_Verificado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JTextField jTE_Autopista;
    public javax.swing.JTextField jTE_Dietas;
    public javax.swing.JTextField jTE_Fecha;
    public javax.swing.JTextField jTE_Gasoil;
    public javax.swing.JTextField jTE_Hextras;
    public javax.swing.JTextArea jTE_Incidencias;
    public javax.swing.JTextField jTE_NombreTrabajador;
    public javax.swing.JTextField jTE_Otros;
    public javax.swing.JTextField jTE_Vehiculo;
    public javax.swing.JTextField jTE_kmf;
    public javax.swing.JTextField jTE_kmi;
    private javax.swing.JTable jTable1;
    public javax.swing.JTable jTableDatos;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField_id;
    private java.util.List<proyectofincurso.Vehiculo> vehiculoList;
    private java.util.List<proyectofincurso.Vehiculo> vehiculoList1;
    private javax.persistence.Query vehiculoQuery;
    private javax.persistence.Query vehiculoQuery1;
    // End of variables declaration//GEN-END:variables
}
