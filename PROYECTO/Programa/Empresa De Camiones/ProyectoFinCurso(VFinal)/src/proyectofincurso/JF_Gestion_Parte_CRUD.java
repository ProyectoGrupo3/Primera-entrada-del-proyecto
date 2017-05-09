
package proyectofincurso;

import Controlador.*;
import Controlador.ControladorCRUD_Gestion_Parte;
import Modelo.*;
import Modelo.Gestion_Parte_CRUD;
import javax.swing.JFrame;

public class JF_Gestion_Parte_CRUD extends javax.swing.JFrame {

    public JF_Gestion_Parte_CRUD() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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
        jB_Borrar = new javax.swing.JButton();
        jB_OK = new javax.swing.JButton();
        jB_Volver = new javax.swing.JButton();
        jB_Salir = new javax.swing.JButton();

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
        jCB_Cerrado.setBounds(252, 24, 65, 23);

        jCB_Verificado.setText("Verificado");
        jPanel1.add(jCB_Verificado);
        jCB_Verificado.setBounds(360, 24, 73, 23);

        jCB_Buscar_SiNo.setText("BUSCAR");
        jCB_Buscar_SiNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_Buscar_SiNoActionPerformed(evt);
            }
        });
        jPanel1.add(jCB_Buscar_SiNo);
        jCB_Buscar_SiNo.setBounds(480, 24, 65, 23);
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
        jB_Crear.setText("C- Crear");
        jB_Crear.setBorderPainted(false);
        jB_Crear.setContentAreaFilled(false);
        jB_Crear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_Crear.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jB_Crear.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jB_Crear.setIconTextGap(5);
        jB_Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_CrearActionPerformed(evt);
            }
        });
        jB_Crear.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jB_CrearPropertyChange(evt);
            }
        });

        jB_Leer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Leer.png"))); // NOI18N
        jB_Leer.setText("R - Leer");
        jB_Leer.setBorderPainted(false);
        jB_Leer.setContentAreaFilled(false);
        jB_Leer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_Leer.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jB_Leer.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jB_Leer.setIconTextGap(5);
        jB_Leer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_LeerActionPerformed(evt);
            }
        });
        jB_Leer.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jB_LeerPropertyChange(evt);
            }
        });

        jB_Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar.png"))); // NOI18N
        jB_Actualizar.setText("U - Actualizar");
        jB_Actualizar.setBorderPainted(false);
        jB_Actualizar.setContentAreaFilled(false);
        jB_Actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_Actualizar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jB_Actualizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jB_Actualizar.setIconTextGap(5);
        jB_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ActualizarActionPerformed(evt);
            }
        });
        jB_Actualizar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jB_ActualizarPropertyChange(evt);
            }
        });

        jB_Borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Borrar.png"))); // NOI18N
        jB_Borrar.setText("D - Borrar");
        jB_Borrar.setBorderPainted(false);
        jB_Borrar.setContentAreaFilled(false);
        jB_Borrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_Borrar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jB_Borrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jB_Borrar.setIconTextGap(5);
        jB_Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_BorrarActionPerformed(evt);
            }
        });
        jB_Borrar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jB_BorrarPropertyChange(evt);
            }
        });

        jB_OK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ok.png"))); // NOI18N
        jB_OK.setText("Confirmar");
        jB_OK.setBorderPainted(false);
        jB_OK.setContentAreaFilled(false);
        jB_OK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_OK.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jB_OK.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jB_OK.setIconTextGap(5);
        jB_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_OKActionPerformed(evt);
            }
        });
        jB_OK.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jB_OKPropertyChange(evt);
            }
        });

        jB_Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Back.png"))); // NOI18N
        jB_Volver.setText("Volver");
        jB_Volver.setBorderPainted(false);
        jB_Volver.setContentAreaFilled(false);
        jB_Volver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_Volver.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jB_Volver.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jB_Volver.setIconTextGap(5);
        jB_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_VolverActionPerformed(evt);
            }
        });
        jB_Volver.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jB_VolverPropertyChange(evt);
            }
        });

        jB_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Exit.png"))); // NOI18N
        jB_Salir.setText("Salir");
        jB_Salir.setBorderPainted(false);
        jB_Salir.setContentAreaFilled(false);
        jB_Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_Salir.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jB_Salir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jB_Salir.setIconTextGap(5);
        jB_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_SalirActionPerformed(evt);
            }
        });
        jB_Salir.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jB_SalirPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_Crear)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jB_Actualizar)
                            .addComponent(jB_Leer)
                            .addComponent(jB_Borrar)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jB_OK))
                            .addComponent(jB_Volver)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jB_Salir)))))
                .addContainerGap(14, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_Borrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jB_OK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jB_Volver)
                .addGap(38, 38, 38)
                .addComponent(jB_Salir)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 60, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCB_CerradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_CerradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCB_CerradoActionPerformed

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

    private void jB_CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_CrearActionPerformed
        JF_Gestion_Parte_CRUD vista_Gestion_Parte = new JF_Gestion_Parte_CRUD();
        Gestion_Parte_CRUD modelo_Gestion_Parte = new Gestion_Parte_CRUD();
        ControladorCRUD_Gestion_Parte controlador_Gestion = new ControladorCRUD_Gestion_Parte(vista_Gestion_Parte, modelo_Gestion_Parte);
    }//GEN-LAST:event_jB_CrearActionPerformed

    private void jB_CrearPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jB_CrearPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_CrearPropertyChange

    private void jB_LeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_LeerActionPerformed
/*        JF_CT_CRUD vista_CT = new JF_CT_CRUD();
        CT_CRUD modelo_CT = new CT_CRUD();
        ControladorCRUD_CT controlador_CT = new ControladorCRUD_CT(vista_CT, modelo_CT);*/
    }//GEN-LAST:event_jB_LeerActionPerformed

    private void jB_LeerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jB_LeerPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_LeerPropertyChange

    private void jB_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_ActualizarActionPerformed

    private void jB_ActualizarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jB_ActualizarPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_ActualizarPropertyChange

    private void jB_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_BorrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_BorrarActionPerformed

    private void jB_BorrarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jB_BorrarPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_BorrarPropertyChange

    private void jB_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_OKActionPerformed
        JF_Gestion_Parte_CRUD vista_Gestion_Parte = new JF_Gestion_Parte_CRUD();
        Gestion_Parte_CRUD modelo_Gestion_Parte = new Gestion_Parte_CRUD();
        ControladorCRUD_Gestion_Parte controlador_Gestion = new ControladorCRUD_Gestion_Parte(vista_Gestion_Parte, modelo_Gestion_Parte);
    }//GEN-LAST:event_jB_OKActionPerformed

    private void jB_OKPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jB_OKPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_OKPropertyChange

    private void jB_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_VolverActionPerformed
        setVisible(false);
        JF_Administrador vista_Adm = new JF_Administrador();
        vista_Adm.setVisible(true);
        vista_Adm.setLocationRelativeTo(null);
    }//GEN-LAST:event_jB_VolverActionPerformed

    private void jB_VolverPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jB_VolverPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_VolverPropertyChange

    private void jB_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jB_SalirActionPerformed

    private void jB_SalirPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jB_SalirPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_SalirPropertyChange

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
    // End of variables declaration//GEN-END:variables
}
