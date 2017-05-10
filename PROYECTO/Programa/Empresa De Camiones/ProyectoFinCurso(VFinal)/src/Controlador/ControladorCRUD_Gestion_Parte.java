package Controlador;

import Modelo.*;
import proyectofincurso.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorCRUD_Gestion_Parte implements ActionListener, KeyListener {

    JF_Gestion_Parte_CRUD vista_Gestion_Parte_CRUD = new JF_Gestion_Parte_CRUD();
    Gestion_Parte_CRUD modelo_Gestion_Parte_CRUD = new Gestion_Parte_CRUD();

    public ControladorCRUD_Gestion_Parte(JF_Gestion_Parte_CRUD vista_Gestion_Parte_CRUD, Gestion_Parte_CRUD modelo_Gestion_Parte_CRUD) {

        this.modelo_Gestion_Parte_CRUD = modelo_Gestion_Parte_CRUD;
        this.vista_Gestion_Parte_CRUD = vista_Gestion_Parte_CRUD;
        // "Escucha" los botones pulsados en la pantalla JF_Gestion_Parte_CRUD
        this.vista_Gestion_Parte_CRUD.jB_Leer.addActionListener(this);
        this.vista_Gestion_Parte_CRUD.jB_Actualizar.addActionListener(this);
        this.vista_Gestion_Parte_CRUD.jB_Borrar.addActionListener(this);
        this.vista_Gestion_Parte_CRUD.jB_OK.addActionListener(this);
        this.vista_Gestion_Parte_CRUD.jCB_Cerrado.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jCB_Verificado.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jCE_Cerrado.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jCE_Verificado.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTextField1.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_Autopista.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_Dietas.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_Fecha.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_Gasoil.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_Hextras.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_Incidencias.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_NombreTrabajador.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_Otros.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_Vehiculo.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_kmf.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_kmi.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jCB_Buscar_SiNo.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTextField_id.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTableDatos.addKeyListener(this);
    }

    public void LlenarTabla(JTable tablaLinea_Parte) {
        DefaultTableModel modeloLP = new DefaultTableModel();
        tablaLinea_Parte.setModel(modeloLP);
//      PARA PONER DESDE AQUÍ LOS NOMBRES DE LAS COLUMNAS
        modeloLP.addColumn("Nombre");
        modeloLP.addColumn("Apellido 1");
        modeloLP.addColumn("Matricula");
        modeloLP.addColumn("Fecha");
        modeloLP.addColumn("Km I.");
        modeloLP.addColumn("Km F.");
        modeloLP.addColumn("G.Gasoil");
        modeloLP.addColumn("G.Autop.");
        modeloLP.addColumn("G.Dietas");
        modeloLP.addColumn("G.Otros");
        modeloLP.addColumn("H.Extras");
        modeloLP.addColumn("Cdo.");
        modeloLP.addColumn("Vrf.");
        modeloLP.addColumn("Incidencias");
        modeloLP.addColumn("Id_T");

        Object[] columna = new Object[15];
        // CREO UNA copia del ArrayList de la Base de datos
        // para ahorrar tiempo de búsqueda y conexión
        List<Vista_CP> ListaCopia = new ArrayList<>();
        ListaCopia = (List<Vista_CP>) modelo_Gestion_Parte_CRUD.listVista_CP().clone();

        int numRegistros = ListaCopia.size();

        for (int i = 0; i < numRegistros; i++) {

            columna[0] = ListaCopia.get(i).getNombre();
            columna[1] = ListaCopia.get(i).getApellido1();
            columna[2] = ListaCopia.get(i).getMatricula();

            // ARREGLAR EL FORMATO DE LA FECHA
            String Fecha_YMD = ListaCopia.get(i).getFecha().toString();
            String Fecha_dma = Fecha_YMD.substring(8, 10) + "-" + Fecha_YMD.substring(5, 7) + "-" + Fecha_YMD.substring(0, 4);
            columna[3] = Fecha_dma;

            columna[4] = ListaCopia.get(i).getKm_in();
            columna[5] = ListaCopia.get(i).getKm_fin();
            columna[6] = ListaCopia.get(i).getGasoil();
            columna[7] = ListaCopia.get(i).getAutopista();
            columna[8] = ListaCopia.get(i).getDietas();
            columna[9] = ListaCopia.get(i).getOtros();
            columna[10] = ListaCopia.get(i).getExceso_horas();
            columna[11] = ListaCopia.get(i).isCerrar_parte();
            columna[12] = ListaCopia.get(i).isVerificar_parte();
            columna[13] = ListaCopia.get(i).getIncidencias();
            columna[14] = ListaCopia.get(i).getId_trabajador();

            modeloLP.addRow(columna);
        }
        JOptionPane.showMessageDialog(null, "Listado terminado");
    }

    public void limpiar() {
        vista_Gestion_Parte_CRUD.jTE_Autopista.setText(null);
        vista_Gestion_Parte_CRUD.jTE_Dietas.setText(null);
        vista_Gestion_Parte_CRUD.jTE_Fecha.setText(null);
        vista_Gestion_Parte_CRUD.jTE_Gasoil.setText(null);
        vista_Gestion_Parte_CRUD.jTE_Incidencias.setText("Incidencias: ");
        vista_Gestion_Parte_CRUD.jTE_NombreTrabajador.setText("");
        vista_Gestion_Parte_CRUD.jTE_Otros.setText(null);
        vista_Gestion_Parte_CRUD.jTE_Vehiculo.setText("");
        vista_Gestion_Parte_CRUD.jTE_kmf.setText(null);
        vista_Gestion_Parte_CRUD.jTextField_id.setText(null);
        vista_Gestion_Parte_CRUD.jTE_kmi.setText(null);
        vista_Gestion_Parte_CRUD.jTE_Hextras.setText(null);
        vista_Gestion_Parte_CRUD.jTextField1.setText(null);

        vista_Gestion_Parte_CRUD.jCB_Cerrado.setSelected(false);
        vista_Gestion_Parte_CRUD.jCB_Verificado.setSelected(false);
        vista_Gestion_Parte_CRUD.jCE_Cerrado.setSelected(false);
        vista_Gestion_Parte_CRUD.jCE_Verificado.setSelected(false);

        // Para que el cursor se ponga en este campo después de limpiar los datos
        vista_Gestion_Parte_CRUD.jTE_Fecha.requestFocus();
    }

    @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent e) {

        // LECTURA de los datos en la tabla
        if (e.getSource() == vista_Gestion_Parte_CRUD.jB_Leer) {
            LlenarTabla(vista_Gestion_Parte_CRUD.jTableDatos);
        }

        // MODIFICACIÓN de los datos introducidos
        if (e.getSource() == vista_Gestion_Parte_CRUD.jB_Actualizar) {
            int filaEditar = vista_Gestion_Parte_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_Gestion_Parte_CRUD.jTableDatos.getSelectedRowCount();

            if (filaEditar >= 0 && numFilas == 1) {
                // Subo los valores de la fila a los campos de edición
                vista_Gestion_Parte_CRUD.jTE_NombreTrabajador.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 0)));
                vista_Gestion_Parte_CRUD.jTE_Vehiculo.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 2)));
                vista_Gestion_Parte_CRUD.jTE_Fecha.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 3)));
                vista_Gestion_Parte_CRUD.jTE_kmi.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 4)));
                vista_Gestion_Parte_CRUD.jTE_kmf.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 5)));
                vista_Gestion_Parte_CRUD.jTE_Gasoil.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 6)));
                vista_Gestion_Parte_CRUD.jTE_Autopista.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 7)));
                vista_Gestion_Parte_CRUD.jTE_Dietas.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 8)));
                vista_Gestion_Parte_CRUD.jTE_Otros.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 9)));
                vista_Gestion_Parte_CRUD.jTE_Hextras.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 10)));

                // SUBO LOS VALORES DE CERRADO Y VERIFICADO
                vista_Gestion_Parte_CRUD.jCE_Cerrado.setSelected(Boolean.parseBoolean(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 11).toString()));
                vista_Gestion_Parte_CRUD.jCE_Verificado.setSelected(Boolean.parseBoolean(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 12).toString()));

                vista_Gestion_Parte_CRUD.jTE_Incidencias.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 13)));
                vista_Gestion_Parte_CRUD.jTextField_id.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 14)));

                // Deshabilito los BOTONES para que no puedan usarse durante la edición
                vista_Gestion_Parte_CRUD.jB_Borrar.setEnabled(false);
                vista_Gestion_Parte_CRUD.jB_Leer.setEnabled(false);

                //Deshabilito los VALORES que NO PUEDEN MODIFICARSE:fecha, matricula trabajador km iniciales y horas extras
                vista_Gestion_Parte_CRUD.jTE_Fecha.setEditable(false);
                vista_Gestion_Parte_CRUD.jTE_Vehiculo.setEditable(false);
                vista_Gestion_Parte_CRUD.jTE_NombreTrabajador.setEditable(false);
                vista_Gestion_Parte_CRUD.jTextField_id.setEditable(false);
                vista_Gestion_Parte_CRUD.jTE_kmi.setEditable(false);
                vista_Gestion_Parte_CRUD.jTE_Hextras.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar 1 sola fila - por lo menos una" + e);
            }
        }
        // BORRADO de alguno de los datos
        if (e.getSource() == vista_Gestion_Parte_CRUD.jB_Borrar) {
            int filaInicio = vista_Gestion_Parte_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_Gestion_Parte_CRUD.jTableDatos.getSelectedRowCount();
            Date fecha = null;
            String matricula = "";
            String fechaString = "";
            int id = 0;
            id = Integer.parseInt(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaInicio, 14).toString());
            matricula = String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaInicio, 2));
            fechaString = vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaInicio, 3).toString();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date parsed = null;
            try {
                parsed = formatter.parse(fechaString);
                fecha = new java.sql.Date(parsed.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(ControladorCRUD_Gestion_Parte.class.getName()).log(Level.SEVERE, null, ex);
            }
            int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Quieres borrar este registro de la matrícula " + matricula + " ?");
            // Esta pregunta tiene 3 posibles respuestas:
            // SI=0  -- NO=1 -- CANCELAR =2
            if (rptaUsuario == 0) {
                modelo_Gestion_Parte_CRUD.eliminarGestion_Parte(fecha, matricula, id);
            }
            LlenarTabla(vista_Gestion_Parte_CRUD.jTableDatos);
        }
        // BOTON de Ok
        if (e.getSource() == vista_Gestion_Parte_CRUD.jB_OK) {

            // CONVERTIR EL STRING DE FECHA EN DATE     
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String dateInStringEditar = vista_Gestion_Parte_CRUD.jTE_Fecha.getText();
            String dateInStringBuscar = vista_Gestion_Parte_CRUD.jTextField1.getText();
            java.sql.Date FechaEditar = null;
            java.sql.Date FechaBuscar = null;
            if (!dateInStringEditar.equals("")) {
                try {
                    java.util.Date parsed = formatter.parse(dateInStringEditar);
                    FechaEditar = new java.sql.Date(parsed.getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(ControladorCRUD_Gestion_Parte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (!dateInStringBuscar.equals("")) {
                try {
                    java.util.Date parsed = formatter.parse(dateInStringBuscar);
                    FechaBuscar = new java.sql.Date(parsed.getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(ControladorCRUD_Gestion_Parte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            Boolean buscaCerrado = vista_Gestion_Parte_CRUD.jCB_Cerrado.isSelected();
            String buscaCerradoChar = "0";
            if (buscaCerrado) {
                buscaCerradoChar = "1";
            } else {
                buscaCerradoChar = "0";
            }
            Boolean buscaVerificado = vista_Gestion_Parte_CRUD.jCB_Verificado.isSelected();
            String buscaVerificadoChar = "0";
            if (buscaVerificado) {
                buscaVerificadoChar = "1";
            } else {
                buscaVerificadoChar = "0";
            }
            // SOLO BUSCA SI HEMOS PULSADO SOBRE EL CHECK DE BUSCAR
            if (vista_Gestion_Parte_CRUD.jCB_Buscar_SiNo.isSelected()) {
                DefaultTableModel modeloLP = new DefaultTableModel();
                vista_Gestion_Parte_CRUD.jTableDatos.setModel(modeloLP);

                modeloLP.addColumn("Trabajador");
                modeloLP.addColumn("Apellido 1");
                modeloLP.addColumn("Matricula");
                modeloLP.addColumn("Fecha");
                modeloLP.addColumn("Km I.");
                modeloLP.addColumn("Km F.");
                modeloLP.addColumn("G.Gasoil");
                modeloLP.addColumn("G.Autop.");
                modeloLP.addColumn("G.Dietas");
                modeloLP.addColumn("G.Otros");
                modeloLP.addColumn("H.Extras");
                modeloLP.addColumn("Cdo.");
                modeloLP.addColumn("Vrf.");
                modeloLP.addColumn("Incidencias");
                modeloLP.addColumn("Id");

                Object[] columna = new Object[15];
                // CREO UNA copia del ArrayList de la Base de datos
                // para ahorrar tiempo de búsqueda y conexión                
                List<Vista_CP> ListaCopia = new ArrayList<>();
                ListaCopia = (List<Vista_CP>) modelo_Gestion_Parte_CRUD.buscarGestion_PartexFecha(FechaBuscar, buscaCerradoChar, buscaVerificadoChar).clone();

                int numRegistros = ListaCopia.size();

                for (int i = 0; i < numRegistros; i++) {

                    columna[0] = ListaCopia.get(i).getNombre();
                    columna[1] = ListaCopia.get(i).getApellido1();
                    columna[2] = ListaCopia.get(i).getMatricula();

                    // ARREGLAR EL FORMATO DE LA FECHA
                    String Fecha_YMD = ListaCopia.get(i).getFecha().toString();
                    String Fecha_dma = Fecha_YMD.substring(8, 10) + "-" + Fecha_YMD.substring(5, 7) + "-" + Fecha_YMD.substring(0, 4);
                    columna[3] = Fecha_dma;

                    columna[4] = ListaCopia.get(i).getKm_in();
                    columna[5] = ListaCopia.get(i).getKm_fin();
                    columna[6] = ListaCopia.get(i).getGasoil();
                    columna[7] = ListaCopia.get(i).getAutopista();
                    columna[8] = ListaCopia.get(i).getDietas();
                    columna[9] = ListaCopia.get(i).getOtros();
                    columna[10] = ListaCopia.get(i).getExceso_horas();
                    columna[11] = ListaCopia.get(i).isCerrar_parte();
                    columna[12] = ListaCopia.get(i).isVerificar_parte();
                    columna[13] = ListaCopia.get(i).getIncidencias();
                    columna[14] = ListaCopia.get(i).getId_trabajador();

                    modeloLP.addRow(columna);
                }
                JOptionPane.showMessageDialog(null, "Listado terminado");

                vista_Gestion_Parte_CRUD.jTextField1.setText("");
                vista_Gestion_Parte_CRUD.jCB_Cerrado.setSelected(false);
                vista_Gestion_Parte_CRUD.jCB_Verificado.setSelected(false);
                vista_Gestion_Parte_CRUD.jCB_Buscar_SiNo.setSelected(false);
            } else { // NO HAY QUE BUSCAR NADA, SOLO HAY QUE ACTUALIZAR LOS                         VALORES
                // Unicos valores a actualizar: km:fin, gasoil, auto, dietas, otros incidencias cerrado y verificado
                int id_trabajador = Integer.parseInt(vista_Gestion_Parte_CRUD.jTextField_id.getText());
                String matricula = vista_Gestion_Parte_CRUD.jTE_Vehiculo.getText();
                int km_ini = Integer.parseInt(vista_Gestion_Parte_CRUD.jTE_kmi.getText());
                int km_final = Integer.parseInt(vista_Gestion_Parte_CRUD.jTE_kmf.getText());
                Double gasoil = Double.parseDouble(vista_Gestion_Parte_CRUD.jTE_Gasoil.getText());
                Double autopista = Double.parseDouble(vista_Gestion_Parte_CRUD.jTE_Autopista.getText());
                Double dietas = Double.parseDouble(vista_Gestion_Parte_CRUD.jTE_Dietas.getText());
                Double otros = Double.parseDouble(vista_Gestion_Parte_CRUD.jTE_Otros.getText());
                String incidencias = vista_Gestion_Parte_CRUD.jTE_Incidencias.getText();
                // CONVERTIR  el String de horas en DATE
                //            SimpleHourFormat hourer = new SimpleHourFormat("hh:mm");
/*            String hourInStringEditar = vista_Gestion_Parte_CRUD.jTE_Fecha.getText();
            java.sql.Date heEditar = null;
            if (!hourInStringEditar.equals("")) {
                try {
                    java.util.Date parsed = formatter.parse(hourInStringEditar);
                    heEditar = new java.sql.Date(parsed.getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(ControladorCRUD_Trabajador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                 */
                Boolean cerrado = vista_Gestion_Parte_CRUD.jCE_Cerrado.isSelected();
                Boolean verificado = vista_Gestion_Parte_CRUD.jCE_Verificado.isSelected();
                // LAS HORAS EXTRAS ESTAN PENDIENTES
                long heEditar = Long.parseLong(vista_Gestion_Parte_CRUD.jTE_Hextras.getText());
                String rptaEdit = modelo_Gestion_Parte_CRUD.editarGestion_Parte(FechaEditar, id_trabajador, matricula, km_ini, km_final, gasoil, autopista, dietas, otros, incidencias, cerrado, verificado, heEditar);

                if (rptaEdit != null) {
                    JOptionPane.showMessageDialog(null, rptaEdit);
                } else {
                    JOptionPane.showMessageDialog(null, "Registro incorrecto" + e);
                }
                // Limpio los datos del formulario
                limpiar();
                // Vuelvo a habilitar los botones deshabilitados
                vista_Gestion_Parte_CRUD.jB_Crear.setEnabled(true);
                vista_Gestion_Parte_CRUD.jB_Borrar.setEnabled(true);
                vista_Gestion_Parte_CRUD.jB_Leer.setEnabled(true);
                vista_Gestion_Parte_CRUD.jB_Salir.setEnabled(true);
                vista_Gestion_Parte_CRUD.jB_Volver.setEnabled(true);

                // Refresco el listado para que aparezca el cambio hecho
                vista_Gestion_Parte_CRUD.jB_Leer.doClick();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
