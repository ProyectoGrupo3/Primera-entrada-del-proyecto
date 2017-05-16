package proyectofincurso;

import Modelo.*;
import proyectofincurso.*;
import Controlador.*;

public class JF_Administrador extends javax.swing.JFrame {

    public Jf_InicioSesion getInicioSesion(){
        return inicioSesion;
    }
    
    public void setInicioSesion (Jf_InicioSesion inicioSesion){
        this.inicioSesion = inicioSesion;
    }
    private Jf_InicioSesion inicioSesion;
    
    public JF_Administrador() {
        initComponents();
        setLocationRelativeTo(null);
        String nombre = Jf_InicioSesion.trabajador.getNombre().toUpperCase();
        bienvenido.setText("Bienvenido de nuevo "+nombre);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jB_Salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jB_Volver = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jB_Trabajador_CRUD = new javax.swing.JButton();
        jB_JF_CT_CRUD = new javax.swing.JButton();
        jB_JF_Vehiculo_CRUD = new javax.swing.JButton();
        jB_JF_Aviso_CRUD = new javax.swing.JButton();
        jB_JF_Gestion_Parte_CRUD = new javax.swing.JButton();
        bienvenido = new javax.swing.JLabel();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("HIMEVICO, S.L.");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Exit.png"))); // NOI18N
        jButton8.setText("Salir");
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton8.setIconTextGap(5);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jButton8.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jButton8PropertyChange(evt);
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

        jB_JF_Aviso_CRUD.setText("Gestión de Avisos (WIP)");
        jB_JF_Aviso_CRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_JF_Aviso_CRUDActionPerformed(evt);
            }
        });

        jB_JF_Gestion_Parte_CRUD.setText("Gestión de Partes");
        jB_JF_Gestion_Parte_CRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_JF_Gestion_Parte_CRUDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jB_Trabajador_CRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jB_JF_Gestion_Parte_CRUD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jB_JF_Aviso_CRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jB_JF_Vehiculo_CRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jB_JF_CT_CRUD, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jB_Trabajador_CRUD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jB_JF_CT_CRUD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jB_JF_Vehiculo_CRUD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jB_JF_Gestion_Parte_CRUD)
                .addGap(18, 18, 18)
                .addComponent(jB_JF_Aviso_CRUD)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        bienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bienvenido.setText("Bienvenido ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bienvenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(81, 99, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jB_Volver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bienvenido)
                .addGap(41, 41, 41)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jB_Volver))
                .addContainerGap(99, Short.MAX_VALUE))
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
        vista_Aviso.jT_Fecha_A.requestFocus();

    }//GEN-LAST:event_jB_JF_Aviso_CRUDActionPerformed

    private void jB_JF_Gestion_Parte_CRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_JF_Gestion_Parte_CRUDActionPerformed

        setVisible(false);
        JF_Gestion_Parte_CRUD vista_Gestion_Parte_CRUD = new JF_Gestion_Parte_CRUD();
        Gestion_Parte_CRUD modelo_Gestion_Parte_CRUD = new Gestion_Parte_CRUD();
        ControladorCRUD_Gestion_Parte controlador_Gestion_Parte = new ControladorCRUD_Gestion_Parte(vista_Gestion_Parte_CRUD, modelo_Gestion_Parte_CRUD);
        vista_Gestion_Parte_CRUD.setVisible(true);
        vista_Gestion_Parte_CRUD.setLocationRelativeTo(null);
        //vista_CT.jB_Leer.doClick();
        vista_Gestion_Parte_CRUD.jTextField1.requestFocus();
        
    }//GEN-LAST:event_jB_JF_Gestion_Parte_CRUDActionPerformed

    private void jB_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_SalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_SalirActionPerformed

    private void jB_SalirPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jB_SalirPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_SalirPropertyChange

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    System.exit(0);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton8PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jButton8PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8PropertyChange

    private void jB_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_VolverActionPerformed
        setVisible(false);
        Jf_InicioSesion vista_Inicio = new Jf_InicioSesion();
        vista_Inicio.setVisible(true);
        vista_Inicio.setLocationRelativeTo(null);
    }//GEN-LAST:event_jB_VolverActionPerformed

    private void jB_VolverPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jB_VolverPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_VolverPropertyChange

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
    private javax.swing.JLabel bienvenido;
    private javax.swing.JButton jB_JF_Aviso_CRUD;
    private javax.swing.JButton jB_JF_CT_CRUD;
    private javax.swing.JButton jB_JF_Gestion_Parte_CRUD;
    private javax.swing.JButton jB_JF_Vehiculo_CRUD;
    public javax.swing.JButton jB_Salir;
    private javax.swing.JButton jB_Trabajador_CRUD;
    public javax.swing.JButton jB_Volver;
    public javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
