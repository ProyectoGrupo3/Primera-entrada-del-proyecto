package Controlador;

import java.text.*;
import java.util.*;

import Modelo.*;
import proyectofincurso.*;
import Modelo.CT_CRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;
import proyectofincurso.JF_CT_CRUD;

public class ControladorCRUD_Trabajador implements ActionListener, KeyListener {

    JF_Trabajador_CRUD vista_Trabajador_CRUD = new JF_Trabajador_CRUD();
    Trabajador_CRUD modelo_Trabajador_CRUD = new Trabajador_CRUD();
    JF_CT_CRUD vista_CT_CRUD = new JF_CT_CRUD();
    CT_CRUD modelo_CT_CRUD = new CT_CRUD();
    Connection accesoDB = Jf_InicioSesion.conexion;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorCRUD_Trabajador(JF_Trabajador_CRUD vista_Trabajador_CRUD, Trabajador_CRUD modelo_Trabajador_CRUD) {

        this.modelo_Trabajador_CRUD = modelo_Trabajador_CRUD;
        this.vista_Trabajador_CRUD = vista_Trabajador_CRUD;
        // "Escucha" los botones pulsados en la pantalla Trabajador_CRUD
        this.vista_Trabajador_CRUD.jB_Crear.addActionListener(this);
        this.vista_Trabajador_CRUD.jB_Leer.addActionListener(this);
        this.vista_Trabajador_CRUD.jB_Actualizar.addActionListener(this);
        this.vista_Trabajador_CRUD.jB_Borrar.addActionListener(this);
        this.vista_Trabajador_CRUD.jB_OK.addActionListener(this);
        this.vista_Trabajador_CRUD.jText_2.addKeyListener(this);
        this.vista_Trabajador_CRUD.jText_3.addKeyListener(this);
        this.vista_Trabajador_CRUD.jText_4.addKeyListener(this);
        this.vista_Trabajador_CRUD.jText_5.addKeyListener(this);
        this.vista_Trabajador_CRUD.jText_6.addKeyListener(this);
        this.vista_Trabajador_CRUD.jText_7.addKeyListener(this);
        this.vista_Trabajador_CRUD.jText_8.addKeyListener(this);
        this.vista_Trabajador_CRUD.jText_9.addKeyListener(this);
        this.vista_Trabajador_CRUD.jText_10.addKeyListener(this);
        this.vista_Trabajador_CRUD.jText_11.addKeyListener(this);
        this.vista_Trabajador_CRUD.jText_12.addKeyListener(this);
        this.vista_Trabajador_CRUD.jText_13.addKeyListener(this);
        // this.vista_Trabajador_CRUD.jList_CT.addKeyListener(this);
        this.vista_Trabajador_CRUD.jB_Buscar_centros.addKeyListener(this);

    }

    @SuppressWarnings("unchecked")
    public void LlenarTabla(JTable tablaTrabajador) {
        DefaultTableModel modeloTr = new DefaultTableModel();
        tablaTrabajador.setModel(modeloTr);
        // Para poner desde aquí los nombres de las columnas
        modeloTr.addColumn("ID");
        modeloTr.addColumn("DNI");
        modeloTr.addColumn("NOMBRE");
        modeloTr.addColumn("APELL.1");
        modeloTr.addColumn("APELL.2");
        modeloTr.addColumn("CALLE");
        modeloTr.addColumn("PORTAL");
        modeloTr.addColumn("PISO");
        modeloTr.addColumn("MANO");
        modeloTr.addColumn("TF.PER.");
        modeloTr.addColumn("MV.EMP.");
        modeloTr.addColumn("SALARIO");
        modeloTr.addColumn("FE.NAC");
        modeloTr.addColumn("CATEGORIA");
        modeloTr.addColumn("CT");

        Object[] columna = new Object[15];

        // CREO UNA copia del ArrayList de la Base de datos
        // para ahorrar tiempo de búsqueda y conexión
        List<Trabajador> ListaCopia = new ArrayList<>();
        ListaCopia = (List<Trabajador>) modelo_Trabajador_CRUD.listTrabajador().clone();

        int numRegistros = ListaCopia.size();

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = ListaCopia.get(i).getID_trabajador();
            columna[1] = ListaCopia.get(i).getDni();
            columna[2] = ListaCopia.get(i).getNombre();
            columna[3] = ListaCopia.get(i).getApellido1();
            columna[4] = ListaCopia.get(i).getApellido2();
            columna[5] = ListaCopia.get(i).getCalle();
            columna[6] = ListaCopia.get(i).getPortal();
            columna[7] = ListaCopia.get(i).getPiso();
            columna[8] = ListaCopia.get(i).getMano();
            columna[9] = ListaCopia.get(i).getTelef_personal();
            columna[10] = ListaCopia.get(i).getMovil_empresa();
            columna[11] = ListaCopia.get(i).getSalario();
            // ARREGLAR EL FORMATO DE LA FECHA
            String Fecha_YMD = ListaCopia.get(i).getFecha_nac().toString();
            String Fecha_dma = Fecha_YMD.substring(8, 10) + "-" + Fecha_YMD.substring(5, 7) + "-" + Fecha_YMD.substring(0, 4);
            columna[12] = Fecha_dma;
            columna[13] = ListaCopia.get(i).getCategoria();
            columna[14] = ListaCopia.get(i).getCt();

            modeloTr.addRow(columna);
        }
        JOptionPane.showMessageDialog(null, "Listado terminado");
    }

    public void limpiar() {
        vista_Trabajador_CRUD.jText_1.setText(null);
        vista_Trabajador_CRUD.jText_1.setEditable(true);
        vista_Trabajador_CRUD.jText_2.setText("");
        vista_Trabajador_CRUD.jText_3.setText("");
        vista_Trabajador_CRUD.jText_4.setText("");
        vista_Trabajador_CRUD.jText_5.setText("");
        vista_Trabajador_CRUD.jText_6.setText("");
        vista_Trabajador_CRUD.jText_7.setText("");
        vista_Trabajador_CRUD.jText_8.setText("");
        vista_Trabajador_CRUD.jText_9.setText("");
        vista_Trabajador_CRUD.jText_10.setText("");
        vista_Trabajador_CRUD.jText_11.setText("");
        vista_Trabajador_CRUD.jText_12.setText(null);
        vista_Trabajador_CRUD.jText_13.setText(null);
        //   vista_Trabajador_CRUD.jList_CT.setSelectedIndex(1);

        // Para que el cursor se ponga en este campo después de limpiar los datos
        vista_Trabajador_CRUD.jText_2.requestFocus();
    }

    @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent e) {

        // BOTON AÑADIR-CREAR
        if (e.getSource() == vista_Trabajador_CRUD.jB_Crear) {
            // Asigno el valor 0 al ID para que no de error antes de generarlo
            int ID = 0;
            String dni = vista_Trabajador_CRUD.jText_2.getText();
            String Nombre = vista_Trabajador_CRUD.jText_3.getText();
            String Apellido1 = vista_Trabajador_CRUD.jText_4.getText();
            String Apellido2 = vista_Trabajador_CRUD.jText_5.getText();
            String Calle = vista_Trabajador_CRUD.jText_6.getText();
            String Portal = vista_Trabajador_CRUD.jText_7.getText();
            String Piso = vista_Trabajador_CRUD.jText_8.getText();
            String Mano = vista_Trabajador_CRUD.jText_9.getText();
            String T_P = vista_Trabajador_CRUD.jText_10.getText();
            String T_E = vista_Trabajador_CRUD.jText_11.getText();
            Double Salario = Double.parseDouble(vista_Trabajador_CRUD.jText_12.getText());
            // CONVERTIR EL STRING EN DATE     
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String dateInString = vista_Trabajador_CRUD.jText_13.getText();
            java.sql.Date FeNac = null;
            try {
                Date parsed = formatter.parse(dateInString);
                FeNac = new java.sql.Date(parsed.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(ControladorCRUD_Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }
            String Categoria = vista_Trabajador_CRUD.jComboBox14.getSelectedItem().toString();

            // Recojo el dato del NOMBRE del Centro de Trabajo
            String Nombre_Centro_Trabajo;
            Nombre_Centro_Trabajo = "inventado";
            // Relleno el array con las categorías
            List<CT> ListaCopia = new ArrayList<>();
            ListaCopia = (List<CT>) modelo_CT_CRUD.listCT().clone();
            int CT = 0;
            int numRegistros = ListaCopia.size();
            // Busco el ID correspondiente a ese nombre de categoría
            for (int i = 0; i < numRegistros; i++) {
                if (ListaCopia.get(i).getNombre().equals(Nombre_Centro_Trabajo)) {
                    CT = ListaCopia.get(i).getID();
                }
            }

            String rptaRegistro = null;
            try {
                rptaRegistro = modelo_Trabajador_CRUD.insertTrabajador(ID, dni, Nombre, Apellido1, Apellido2, Calle, Portal, Piso, Mano, T_P, T_E, Salario, FeNac, Categoria, CT);
            } catch (ParseException ex) {
                Logger.getLogger(ControladorCRUD_Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (rptaRegistro != null) {
                JOptionPane.showMessageDialog(null, rptaRegistro);
            } else {
                JOptionPane.showMessageDialog(null, "Registro incorrecto");
            }
            limpiar();
            vista_Trabajador_CRUD.jB_Leer.doClick();
        }
        // BOTÓN LEER
        if (e.getSource() == vista_Trabajador_CRUD.jB_Leer) {
            LlenarTabla(vista_Trabajador_CRUD.jTableDatos);
        }
        // BOTÓN MODIFICACIÓN
        if (e.getSource() == vista_Trabajador_CRUD.jB_Actualizar) {
            int filaEditar = vista_Trabajador_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_Trabajador_CRUD.jTableDatos.getSelectedRowCount();
            if (filaEditar >= 0 && numFilas == 1) {
                // Subo los valores de la fila a los campos de edición
                vista_Trabajador_CRUD.jText_1.setText(String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaEditar, 0)));
                vista_Trabajador_CRUD.jText_2.setText(String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaEditar, 1)));
                vista_Trabajador_CRUD.jText_3.setText(String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaEditar, 2)));
                vista_Trabajador_CRUD.jText_4.setText(String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaEditar, 3)));
                vista_Trabajador_CRUD.jText_5.setText(String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaEditar, 4)));
                vista_Trabajador_CRUD.jText_6.setText(String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaEditar, 5)));
                vista_Trabajador_CRUD.jText_7.setText(String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaEditar, 6)));
                vista_Trabajador_CRUD.jText_8.setText(String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaEditar, 7)));
                vista_Trabajador_CRUD.jText_9.setText(String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaEditar, 8)));
                vista_Trabajador_CRUD.jText_10.setText(String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaEditar, 9)));
                vista_Trabajador_CRUD.jText_11.setText(String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaEditar, 10)));
                vista_Trabajador_CRUD.jText_12.setText(String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaEditar, 11)));
                vista_Trabajador_CRUD.jText_13.setText(String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaEditar, 12)));
                // CONVERTIR EL STRING EN DATE     
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String dateInString = vista_Trabajador_CRUD.jText_13.getText();
                java.sql.Date FeNac = null;
                try {
                    Date parsed = formatter.parse(dateInString);
                    FeNac = new java.sql.Date(parsed.getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(ControladorCRUD_Trabajador.class.getName()).log(Level.SEVERE, null, ex);
                }
                vista_Trabajador_CRUD.jComboBox14.setSelectedItem(String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaEditar, 13)));

                String Categoria = vista_Trabajador_CRUD.jComboBox14.getSelectedItem().toString();

                // Recojo el dato del ID del Centro de Trabajo
                String ID_Centro_Trabajo = "inventado";
                int CT = Integer.parseInt(ID_Centro_Trabajo);
                String Centro = "";
                // Relleno el array con las categorías
                List<CT> ListaCopia = new ArrayList<>();
                ListaCopia = (List<CT>) modelo_CT_CRUD.listCT().clone();
                int numRegistros = ListaCopia.size();
                // Busco el NOMBRE correspondiente a ese ID de categoría
                for (int i = 0; i < numRegistros; i++) {
                    if (ListaCopia.get(i).getID() == CT) {
                        Centro = ListaCopia.get(i).getNombre();
                    }
                }
                // Pongo el valor recogido de la Categoría en su sitio
                vista_Trabajador_CRUD.jList_CT.getSelectedRow();
                // Como el ID es clave lo deshabilito para que no pueda modificarse
                vista_Trabajador_CRUD.jText_1.setEditable(false);
                // Deshabilito los botones para que no puedan usarse durante la edición
                vista_Trabajador_CRUD.jB_Crear.setEnabled(false);
                vista_Trabajador_CRUD.jB_Borrar.setEnabled(false);
                vista_Trabajador_CRUD.jB_Leer.setEnabled(false);
                vista_Trabajador_CRUD.jB_Salir.setEnabled(false);
                vista_Trabajador_CRUD.jB_Volver.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar 1 sola fila - por lo menos una" + e);
            }
        }
        // BORRADO de datos
        if (e.getSource() == vista_Trabajador_CRUD.jB_Borrar) {
            int filaInicio = vista_Trabajador_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_Trabajador_CRUD.jTableDatos.getSelectedRowCount();
            ArrayList<String> listaNombre = new ArrayList();
            String nombre = "";
            String num = "";
            int id = 0;
            if (filaInicio >= 0) {
                for (int i = 0; i < numFilas; i++) {
                    nombre = String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(i + filaInicio, 1));
                    num = String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaInicio, 0));
                    id = Integer.parseInt(num);
                    listaNombre.add(nombre);
                }
                for (int i = 0; i < numFilas; i++) {
                    int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Quieres borrar el registro " + nombre + " ?");
                    // Esta pregunta tiene 3 posibles respuestas:
                    // SI=0  -- NO=1 -- CANCELAR =2
                    if (rptaUsuario == 0) {
                        modelo_Trabajador_CRUD.eliminarTrabajador(id);
                    }
                }
                LlenarTabla(vista_Trabajador_CRUD.jTableDatos);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona por lo menos una fila a borrar.");

            }
        }
        // BOTÓN de OK
        if (e.getSource() == vista_Trabajador_CRUD.jB_OK) {

            String nombreBuscado = vista_Trabajador_CRUD.jText_Buscar.getText();
            // Cuando SI QUE hay texto en el campo BUSCAR
            if (!nombreBuscado.equals("")) {
                nombreBuscado = "%" + nombreBuscado + "%";
                DefaultTableModel modeloTr = new DefaultTableModel();
                vista_Trabajador_CRUD.jTableDatos.setModel(modeloTr);

                modeloTr.addColumn("ID");
                modeloTr.addColumn("DNI");
                modeloTr.addColumn("NOMBRE");
                modeloTr.addColumn("APELL.1");
                modeloTr.addColumn("APELL.2");
                modeloTr.addColumn("CALLE");
                modeloTr.addColumn("PORTAL");
                modeloTr.addColumn("PISO");
                modeloTr.addColumn("MANO");
                modeloTr.addColumn("TF.PER.");
                modeloTr.addColumn("MV.EMP.");
                modeloTr.addColumn("SALARIO");
                modeloTr.addColumn("FE.NAC");
                modeloTr.addColumn("CATEGORIA");
                modeloTr.addColumn("CT");

                Object[] columna = new Object[15];

                // CREO UNA copia del ArrayList de la Base de datos
                // para ahorrar tiempo de búsqueda y conexión
                List<Trabajador> ListaCopia = new ArrayList<>();
                ListaCopia = (List<Trabajador>) modelo_Trabajador_CRUD.buscarTrabajadorxNombre(nombreBuscado).clone();

                int numRegistros = ListaCopia.size();

                for (int i = 0; i < numRegistros; i++) {
                    columna[0] = ListaCopia.get(i).getID_trabajador();
                    columna[1] = ListaCopia.get(i).getDni();
                    columna[2] = ListaCopia.get(i).getNombre();
                    columna[3] = ListaCopia.get(i).getApellido1();
                    columna[4] = ListaCopia.get(i).getApellido2();
                    columna[5] = ListaCopia.get(i).getCalle();
                    columna[6] = ListaCopia.get(i).getPortal();
                    columna[7] = ListaCopia.get(i).getPiso();
                    columna[8] = ListaCopia.get(i).getMano();
                    columna[9] = ListaCopia.get(i).getTelef_personal();
                    columna[10] = ListaCopia.get(i).getMovil_empresa();
                    columna[11] = ListaCopia.get(i).getSalario();
                    columna[12] = ListaCopia.get(i).getFecha_nac();
                    columna[13] = ListaCopia.get(i).getCategoria();
                    columna[14] = ListaCopia.get(i).getCt();

                    modeloTr.addRow(columna);
                }
                JOptionPane.showMessageDialog(null, "Listado terminado");
                vista_Trabajador_CRUD.jText_Buscar.setText("");
            } else { // NO HAY QUE BUSCAR NADA, SOLO ACTUALIZAR LOS VALORES
                int ID = Integer.parseInt(vista_Trabajador_CRUD.jText_1.getText());
                String dni = vista_Trabajador_CRUD.jText_2.getText();
                String Nombre = vista_Trabajador_CRUD.jText_3.getText();
                String Apellido1 = vista_Trabajador_CRUD.jText_4.getText();
                String Apellido2 = vista_Trabajador_CRUD.jText_5.getText();
                String Calle = vista_Trabajador_CRUD.jText_6.getText();
                String Portal = vista_Trabajador_CRUD.jText_7.getText();
                String Piso = vista_Trabajador_CRUD.jText_8.getText();
                String Mano = vista_Trabajador_CRUD.jText_9.getText();
                String T_P = vista_Trabajador_CRUD.jText_10.getText();
                String T_E = vista_Trabajador_CRUD.jText_11.getText();
                Double Salario = Double.parseDouble(vista_Trabajador_CRUD.jText_12.getText());
                // CONVERTIR EL STRING EN DATE
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String dateInString = vista_Trabajador_CRUD.jText_13.getText();
                java.sql.Date FeNac = null;
                try {
                    Date parsed = formatter.parse(dateInString);
                    FeNac = new java.sql.Date(parsed.getTime());

                } catch (ParseException ex) {
                    Logger.getLogger(ControladorCRUD_Trabajador.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                // Recojo el dato de la Categoría el NOMBRE
                String Categoria = vista_Trabajador_CRUD.jComboBox14.getSelectedItem().toString();

                // Recojo el dato del NOMBRE del Centro de Trabajo
                String Nombre_Centro_Trabajo = "centro inventado";
                // Relleno el array con las categorías
                List<CT> ListaCopia = new ArrayList<>();
                ListaCopia = (List<CT>) modelo_CT_CRUD.listCT().clone();
                int CT = 0;
                int numRegistros = ListaCopia.size();
                // Busco el ID correspondiente a ese nombre de categoría
                for (int i = 0; i < numRegistros; i++) {
                    if (ListaCopia.get(i).getNombre().equals(Nombre_Centro_Trabajo)) {
                        CT = ListaCopia.get(i).getID();
                    }
                }
                // Pongo el valor recogido de la Categoría en su sitio
                vista_Trabajador_CRUD.jList_CT.getSelectedRow();

                int rptaEdit = modelo_Trabajador_CRUD.editarTrabajador(ID, dni, Nombre,
                        Apellido1, Apellido2, Calle, Portal, Piso, Mano, T_P, T_E,
                        Salario, FeNac, Categoria, CT);
                if (rptaEdit > 0) {
                    JOptionPane.showMessageDialog(null, "Edición Correcta");
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR en la EDICIÓN");
                }
                // Borro los datos del formulario
                limpiar();
                // Vuelvo a habilitar los botones deshabilitados
                vista_Trabajador_CRUD.jText_1.setEditable(true);
                vista_Trabajador_CRUD.jB_Crear.setEnabled(true);
                vista_Trabajador_CRUD.jB_Borrar.setEnabled(true);
                vista_Trabajador_CRUD.jB_Leer.setEnabled(true);
                vista_Trabajador_CRUD.jB_Salir.setEnabled(true);
                vista_Trabajador_CRUD.jB_Volver.setEnabled(true);
                // Refresco el listado para que se vea la modificación
                vista_Trabajador_CRUD.jB_Leer.doClick();
            }

        }
        if (e.getSource() == vista_Trabajador_CRUD.jB_Buscar_centros) {

            try {
                ArrayList listaCT = new ArrayList();
                CT ct;
                String sql = "{call CONSULTA_CT.BUSCAR_TOTAL_CT(?)}";

                //Statement sentencia = accesoDB.createStatement();
                CallableStatement rp = accesoDB.prepareCall(sql);
                rp.registerOutParameter(1, OracleTypes.CURSOR);
                rp.executeUpdate();
                ResultSet res = (ResultSet) rp.getObject(1);
                while (res.next()) {
                    ct = new CT();
                    ct.setID(res.getInt(1));
                    ct.setNombre(res.getString(2));
                    ct.setCalle(res.getString(3));
                    ct.setNumero(res.getInt(4));
                    ct.setCp(res.getString(5));
                    ct.setCiudad(res.getString(6));
                    ct.setProvincia(res.getString(7));
                    ct.setTelefono(res.getString(8));
                    listaCT.add(ct);
                    DefaultTableModel modelo = (DefaultTableModel) vista_Trabajador_CRUD.jList_CT.getModel();
                    //Sección 2
                    Object[] fila = new Object[2];
                    //Sección 3
                    fila[0] = ct.getNombre();
                    fila[1] = ct.getID();
                    //Sección 4
                    modelo.addRow(fila);
                    //Sección 5
                    vista_Trabajador_CRUD.jList_CT.setModel(modelo);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ControladorCRUD_Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    // OPCIÓN DE BUSCAR POR NOMBRE

    @Override
    public void keyTyped(KeyEvent e
    ) {

    }

    @Override
    public void keyPressed(KeyEvent e
    ) {

    }

    @Override
    public void keyReleased(KeyEvent e
    ) {

    }

}
