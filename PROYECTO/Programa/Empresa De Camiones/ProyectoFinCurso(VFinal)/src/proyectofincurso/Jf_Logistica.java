/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofincurso;

import Modelo.Cabe_Parte;
import Modelo.Linea_Parte;
import static java.lang.Integer.parseInt;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.*;
import static proyectofincurso.Jf_InicioSesion.conexion;

/**
 *
 * @author 7fbd12
 */
public class Jf_Logistica extends javax.swing.JFrame {

    /**
     * @return the inicioSesion
     */
    public Jf_InicioSesion getInicioSesion() {
        return inicioSesion;
    }

    /**
     * @param inicioSesion the inicioSesion to set
     */
    public void setInicioSesion(Jf_InicioSesion inicioSesion) {
        this.inicioSesion = inicioSesion;
    }

    public void rellenarParte(Cabe_Parte cp) {
        if (cp == null) {

        } else {
            try {
                añadirCP(cp);
                fechaParte.setText(String.valueOf(cp.getFecha()));
                vehiculoText.setText(cp.getMatricula());
                kmiText.setText(String.valueOf(cp.getKm_inicio()));
                kmfText.setText(String.valueOf(cp.getKm_fin()));
                gAutopista.setText(String.valueOf(cp.getAutopista()));
                gDietas.setText(String.valueOf(cp.getDietas()));
                gGasoil.setText(String.valueOf(cp.getGasoil()));
                gOtros.setText(String.valueOf(cp.getOtros()));
                incidenciasText.setText(cp.getIncidencias());
                System.out.println("datos puestos");

                CallableStatement llamada = conexion.prepareCall("{call PASAR_LINEA(?,?,?)}");
                llamada.setDate(1, cp.getFecha());
                llamada.setInt(2, cp.getId_trabajador());
                llamada.registerOutParameter(3, OracleTypes.CURSOR);
                llamada.executeUpdate();
                ResultSet resul = (ResultSet) llamada.getObject(3);
                while (resul.next()) {
                    System.out.println(resul.getString(1));
                    System.out.println(resul.getString(2));
                    System.out.println(resul.getString(3));
                    System.out.println(resul.getString(4));

                    Linea_Parte lp = new Linea_Parte(resul.getString(1), resul.getString(2), resul.getDate(3), resul.getInt(4));
                    añadirParte(lp);
                    ponerEnTabla(lp);
                }

            } catch (SQLException ex) {
                Logger.getLogger(Jf_Logistica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public long calcularMinutosExcesoHoras() {
        long total = 0;
        if (lineas_parte != null) {

            for (Linea_Parte linea_Parte : lineas_parte) {
                String hora_i = linea_Parte.getHora_inicio();//se guardara una hora
                String hora_f = linea_Parte.getHora_final();//se guardara una hora

                String[] horaInicio = hora_i.split(":");
                String[] horaFinal = hora_f.split(":");

                LocalDateTime hInicio = LocalDateTime.of(2000, 1, 1, Integer.parseInt(horaInicio[0]), Integer.parseInt(horaInicio[1]), 0);
                LocalDateTime hFinal = LocalDateTime.of(2000, 1, 1, Integer.parseInt(horaFinal[0]), Integer.parseInt(horaFinal[1]), 0);

                long minutos = hInicio.until(hFinal, ChronoUnit.MINUTES);
                total = total + minutos;
            }
        } else {
            return 0;
        }
        return total;
    }

    public void ponerEnTabla(Linea_Parte lp) {
        //Sección 1 
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        //Sección 2
        Object[] fila = new Object[3];
        //Sección 3
        fila[0] = lp.getHora_inicio();
        fila[1] = lp.getHora_final();
        //Sección 4
        modelo.addRow(fila);
        //Sección 5
        jTable1.setModel(modelo);

    }

    public void añadirParte(Linea_Parte lp) {
        lineas_parte.add(lp);
    }

    public void añadirCP(Cabe_Parte cp) {
        cabecera_Parte = cp;
    }

    private Cabe_Parte cabecera_Parte = null;
    private List<Linea_Parte> lineas_parte = new ArrayList<>();
    private Jf_InicioSesion inicioSesion;
    private Date sqlDate = null;

    /**
     * Creates new form PantLogistica2
     */
    public Jf_Logistica() {
        initComponents();
        java.util.Date utilDate = new java.util.Date(); //fecha actual
        long lnMilisegundos = utilDate.getTime();
        sqlDate = new java.sql.Date(lnMilisegundos);
        fechaParte.setText(sqlDate.toString());

        jTable1.removeAll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        gAutopista = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        gDietas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        gOtros = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        gGasoil = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        vehiculoText = new javax.swing.JTextField();
        fechaParte = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        kmiText = new javax.swing.JTextField();
        kmfText = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        incidenciasText = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Jb_borrarLinea = new javax.swing.JButton();
        Jb_GuardarYcerrarSesion = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        Jb_InsertarLinea = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        horaInicioText = new javax.swing.JTextField();
        horaFinText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cerrarParteCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gastos"));

        jLabel4.setText("Autopista");

        jLabel5.setText("Dietas");

        jLabel6.setText("Otros");

        jLabel2.setText("Gasoil");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(gAutopista, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(37, 37, 37)
                        .addComponent(gOtros, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gDietas)
                            .addComponent(gGasoil))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(gAutopista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gGasoil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gDietas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gOtros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Fecha ");

        jLabel3.setText("Vehiculo ");

        vehiculoText.setText("Escriba el vehículo");

        fechaParte.setText("sysdate");

        jLabel8.setText("KM Inicio");

        jLabel9.setText("KM Fin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaParte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vehiculoText, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(kmiText)
                    .addComponent(kmfText))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fechaParte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(vehiculoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(kmiText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(kmfText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setText("Incidencias:");

        incidenciasText.setColumns(20);
        incidenciasText.setRows(5);
        jScrollPane2.setViewportView(incidenciasText);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Lineas del Parte"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hora inicio", "Hora fin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Jb_borrarLinea.setText("Borrar linea");
        Jb_borrarLinea.setToolTipText("Selecciona una linea de la tabla y haz click en este botón");
        Jb_borrarLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jb_borrarLineaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Jb_borrarLinea)
                .addGap(68, 68, 68))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Jb_borrarLinea)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        Jb_GuardarYcerrarSesion.setText("Guardar y cerrar sesión");
        Jb_GuardarYcerrarSesion.setToolTipText("Al dar a este botón, estas cerrando el parte y por la tanto ya no podras volver a editarlo");
        Jb_GuardarYcerrarSesion.setMaximumSize(new java.awt.Dimension(110, 23));
        Jb_GuardarYcerrarSesion.setMinimumSize(new java.awt.Dimension(110, 23));
        Jb_GuardarYcerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jb_GuardarYcerrarSesionActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        Jb_InsertarLinea.setText("Insertar Nueva Linea");
        Jb_InsertarLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jb_InsertarLineaActionPerformed(evt);
            }
        });

        jLabel11.setText("Hora inicio");

        jLabel13.setText("Hora fin");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(horaFinText, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                        .addComponent(horaInicioText))
                    .addComponent(Jb_InsertarLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(horaInicioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(horaFinText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Jb_InsertarLinea)
                .addContainerGap())
        );

        jLabel7.setText("Cerrar Parte (si lo activas y guardas no podras volver a editar ni abrir este parte)");

        cerrarParteCheck.setText("Cerrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 110, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cerrarParteCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Jb_GuardarYcerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Jb_GuardarYcerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(cerrarParteCheck))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Jb_InsertarLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jb_InsertarLineaActionPerformed
        //Sección 1 
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        //Sección 2
        Object[] fila = new Object[3];
        //Sección 3
        fila[0] = horaInicioText.getText();
        fila[1] = horaFinText.getText();
        //Sección 4
        modelo.addRow(fila);
        //Sección 5
        jTable1.setModel(modelo);
    }//GEN-LAST:event_Jb_InsertarLineaActionPerformed

    private void Jb_GuardarYcerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jb_GuardarYcerrarSesionActionPerformed

        try {
            //Si no se le ha dado a cerrar el parte y no habia datos de cabecera anteriormente

            if (cabecera_Parte == null) {
                if (cerrarParteCheck.getSelectedObjects() == null) {
                    boolean cerrar = false;
                    long exc_h = calcularMinutosExcesoHoras();
                    char crar = 0;
                    char verificacion = 0;
                    cabecera_Parte = new Cabe_Parte(sqlDate, Integer.parseInt(kmiText.getText()), Integer.parseInt(kmfText.getText()), Integer.parseInt(gGasoil.getText()), Integer.parseInt(gAutopista.getText()), Integer.parseInt(gDietas.getText()), Integer.parseInt(gOtros.getText()), incidenciasText.getText(), exc_h, crar, verificacion, Jf_InicioSesion.trabajador.getID_trabajador(), vehiculoText.getText());
                    //tenemo la cabecera, ahora a pasarla a la base de datos
                    //insert o update
                    CallableStatement llevar = conexion.prepareCall("{call INSERT_UPDATE_CABECERA(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                    llevar.setDate(1, cabecera_Parte.getFecha());
                    llevar.setInt(2, cabecera_Parte.getKm_inicio());
                    llevar.setInt(3, cabecera_Parte.getKm_fin());
                    llevar.setInt(4, cabecera_Parte.getGasoil());
                    llevar.setInt(5, cabecera_Parte.getAutopista());
                    llevar.setInt(6, cabecera_Parte.getDietas());
                    llevar.setInt(7, cabecera_Parte.getOtros());
                    llevar.setString(8, cabecera_Parte.getIncidencias());
                    llevar.setLong(9, cabecera_Parte.getExceso_horas());
                    llevar.setObject(10, cabecera_Parte.isCerrar_parte(), Types.CHAR);
                    llevar.setObject(11, cabecera_Parte.isVerificar_parte(), Types.CHAR);
                    llevar.setInt(12, cabecera_Parte.getId_trabajador());
                    llevar.setString(13, cabecera_Parte.getMatricula());
                    llevar.executeUpdate();

                }
            } else /*si hay una cabecera_parte*/ {
                long exc_h = calcularMinutosExcesoHoras();
                if (cerrarParteCheck.getSelectedObjects() != null) {
                    boolean cerrar = true;
                    char crar = 1;
                    char verificacion = 0;
                    cabecera_Parte = new Cabe_Parte(sqlDate, Integer.parseInt(kmiText.getText()), Integer.parseInt(kmfText.getText()), Integer.parseInt(gGasoil.getText()), Integer.parseInt(gAutopista.getText()), Integer.parseInt(gDietas.getText()), Integer.parseInt(gOtros.getText()), incidenciasText.getText(), exc_h, crar, verificacion, Jf_InicioSesion.trabajador.getID_trabajador(), vehiculoText.getText());
                    if (exc_h >= 540) {
                        JOptionPane.showMessageDialog(null, "¡Vaya!Tiene exceso de horas de trabajo. Lo normal es tener 8 horas.");
                    }
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(Jf_Logistica.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_Jb_GuardarYcerrarSesionActionPerformed

    private void Jb_borrarLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jb_borrarLineaActionPerformed

        //Sección 1
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        //Sección 2
        int a = jTable1.getSelectedRow();
        //Sección 3
        if (a < 0) {
            JOptionPane.showMessageDialog(null,
                    "Debe seleccionar una fila de la tabla");
        } else {
            //Sección 4
            int confirmar = JOptionPane.showConfirmDialog(null,
                    "Esta seguro que desea Eliminar el registro? ");
            //Sección 5 
            if (JOptionPane.OK_OPTION == confirmar) {
                //Sección 6
                model.removeRow(a);
                //Sección 7
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
    }//GEN-LAST:event_Jb_borrarLineaActionPerformed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jf_Logistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jf_Logistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jf_Logistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jf_Logistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jf_Logistica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Jb_GuardarYcerrarSesion;
    public javax.swing.JButton Jb_InsertarLinea;
    public javax.swing.JButton Jb_borrarLinea;
    public javax.swing.JCheckBox cerrarParteCheck;
    public javax.swing.JLabel fechaParte;
    public javax.swing.JTextField gAutopista;
    public javax.swing.JTextField gDietas;
    public javax.swing.JTextField gGasoil;
    public javax.swing.JTextField gOtros;
    public javax.swing.JTextField horaFinText;
    public javax.swing.JTextField horaInicioText;
    public javax.swing.JTextArea incidenciasText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable1;
    public javax.swing.JTextField kmfText;
    public javax.swing.JTextField kmiText;
    public javax.swing.JTextField vehiculoText;
    // End of variables declaration//GEN-END:variables

}
