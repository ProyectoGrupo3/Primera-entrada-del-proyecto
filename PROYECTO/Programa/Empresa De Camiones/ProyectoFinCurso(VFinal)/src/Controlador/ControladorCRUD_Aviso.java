package Controlador;

import Modelo.*;
import proyectofincurso.JF_Aviso_CRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorCRUD_Aviso implements ActionListener, KeyListener {

    JF_Aviso_CRUD vista_Aviso_CRUD = new JF_Aviso_CRUD();
    Aviso_CRUD modelo_Aviso_CRUD = new Aviso_CRUD();

    /**
     * Listener de los botones y campos.
     *
     * @param vista_Aviso_CRUD
     * @param modelo_Aviso_CRUD
     */
    public ControladorCRUD_Aviso(JF_Aviso_CRUD vista_Aviso_CRUD, Aviso_CRUD modelo_Aviso_CRUD) {
        this.modelo_Aviso_CRUD = modelo_Aviso_CRUD;
        this.vista_Aviso_CRUD = vista_Aviso_CRUD;
        // "Escucha" los botones pulsados en la pantalla JF_Aviso_CRUD
        this.vista_Aviso_CRUD.jB_Leer.addActionListener(this);
        this.vista_Aviso_CRUD.jB_Leer.addActionListener(this);
        this.vista_Aviso_CRUD.jB_Actualizar.addActionListener(this);
        this.vista_Aviso_CRUD.jB_Borrar.addActionListener(this);
        this.vista_Aviso_CRUD.jB_OK.addActionListener(this);
        this.vista_Aviso_CRUD.jT_Fecha_A.addKeyListener(this);
        this.vista_Aviso_CRUD.jB_Actualizar.addKeyListener(this);
        this.vista_Aviso_CRUD.jT_Trabajador.addKeyListener(this);
        this.vista_Aviso_CRUD.jTableDatos.addKeyListener(this);
        this.vista_Aviso_CRUD.jT_BuscarLogis.addKeyListener(this);
    }

    /**
     * Llenar la tabla con informacion de las cabecera partes.
     *
     * @param tablaCT
     */
    public void LlenarTabla(JTable tablaCT) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaCT.setModel(modeloT);
//      PARA PONER DESDE AQUÍ LOS NOMBRES DE LAS COLUMNAS
        modeloT.addColumn("F.AVISO");
        modeloT.addColumn("F.PARTE");
        modeloT.addColumn("NOMBRE");
        modeloT.addColumn("APELLIDO 1");
        modeloT.addColumn("AVISO");
        modeloT.addColumn("ID_Logis");
        modeloT.addColumn("ID_Admin");

        Object[] columna = new Object[7];
        // CREO UNA copia del ArrayList de la Base de datos
        // para ahorrar tiempo de búsqueda y conexión
        List<Aviso> ListaCopia = new ArrayList<>();
        ListaCopia = (List<Aviso>) modelo_Aviso_CRUD.listAviso().clone();

        int numRegistros = ListaCopia.size();

        for (int i = 0; i < numRegistros; i++) {

            columna[0] = ListaCopia.get(i).getFecha_aviso();
            columna[1] = ListaCopia.get(i).getFecha_parte();
            columna[2] = ListaCopia.get(i).getNombre();
            columna[3] = ListaCopia.get(i).getApellido1();
            columna[4] = ListaCopia.get(i).getTexto();
            columna[5] = ListaCopia.get(i).getId_Logis();
            columna[6] = ListaCopia.get(i).getId_Admin();

            modeloT.addRow(columna);
        }
        JOptionPane.showMessageDialog(null, "Listado terminado");
    }

    /**
     * Limpiar los campos de la ventana.
     */
    public void limpiar() {

        vista_Aviso_CRUD.jT_Fecha_A.setText("");
        vista_Aviso_CRUD.jT_Trabajador.setText("");
        vista_Aviso_CRUD.jT_F_Parte.setText("");
        vista_Aviso_CRUD.jT_Area_Aviso.setText("Mensaje: ");
        // Para que el cursor se ponga en este campo después de limpiar los datos
        vista_Aviso_CRUD.jT_Fecha_A.requestFocus();
        String hoyString = new Date().toString();
        vista_Aviso_CRUD.jT_Fecha_A.setText(hoyString);
    }

    /**
     * Todos los eventos que ocasiona presionar los botones.
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {

        // CREAR: ALTA de datos nuevos
        if (e.getSource() == vista_Aviso_CRUD.jB_Leer) {
            // CONVERTIR EL STRING EN DATE     
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String avisoInString = vista_Aviso_CRUD.jT_Fecha_A.getText();
            java.util.Date fa = new java.util.Date();
            java.sql.Date fecha_A = new java.sql.Date(fa.getTime());
            String parteInString = vista_Aviso_CRUD.jT_F_Parte.getText();
            java.sql.Date fecha_P = new java.sql.Date(fa.getTime());
            if (avisoInString == null) {
                avisoInString = fa.toString();
            }
            try {
                Date parsed = formatter.parse(avisoInString);
                fecha_A = new java.sql.Date(parsed.getTime());
                parsed = formatter.parse(parteInString);
                fecha_A = new java.sql.Date(parsed.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(ControladorCRUD_Aviso.class.getName()).log(Level.SEVERE, null, ex);
            }
            String Aviso = vista_Aviso_CRUD.jT_Area_Aviso.getText();
            //int id_Admin = Integer.parseInt(vista_Aviso_CRUD.jText_4.getText());
            // int id_Logis = Integer.parseInt(vista_Aviso_CRUD.jText_4.getText());
            int id_Admin = 0;
            int id_Logis = 0;
            String rptaRegistro = modelo_Aviso_CRUD.insertAviso(fecha_A, Aviso, id_Admin, fecha_P, id_Logis);
            if (rptaRegistro != null) {
                JOptionPane.showMessageDialog(null, rptaRegistro);
            } else {
                JOptionPane.showMessageDialog(null, "Registro incorrecto" + e);
            }
            limpiar();
            vista_Aviso_CRUD.jB_Leer.doClick();
        }

        // LECTURA de los datos en la tabla
        if (e.getSource() == vista_Aviso_CRUD.jB_Leer) {
            LlenarTabla(vista_Aviso_CRUD.jTableDatos);
        }

        // MODIFICACIÓN de los datos introducidos
        if (e.getSource() == vista_Aviso_CRUD.jB_Actualizar) {
            int filaEditar = vista_Aviso_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_Aviso_CRUD.jTableDatos.getSelectedRowCount();
            if (filaEditar >= 0 && numFilas == 1) {

                // Subo los valores de la fila a los campos de edición
                vista_Aviso_CRUD.jT_Fecha_A.setText(String.valueOf(vista_Aviso_CRUD.jTableDatos.getValueAt(filaEditar, 0)));
                //            vista_Aviso_CRUD.jL_Trabajador.setText(String.valueOf(vista_Aviso_CRUD.jTableDatos.getValueAt(filaEditar, 1)));
                //          vista_Aviso_CRUD.jL_Fecha_P.setText(String.valueOf(vista_Aviso_CRUD.jTableDatos.getValueAt(filaEditar, 2)));
                vista_Aviso_CRUD.jT_Area_Aviso.setText(String.valueOf(vista_Aviso_CRUD.jTableDatos.getValueAt(filaEditar, 3)));

                // Deshabilito los campos NO editables: fecha aviso y parte, trabajador
                vista_Aviso_CRUD.jT_Fecha_A.setEditable(false);
                vista_Aviso_CRUD.jT_Trabajador.setEditable(false);
                vista_Aviso_CRUD.jT_F_Parte.setEditable(false);

                // Deshabilito los botones para que no puedan usarse durante la edición
                vista_Aviso_CRUD.jB_Leer.setEnabled(false);
                vista_Aviso_CRUD.jB_Borrar.setEnabled(false);
                vista_Aviso_CRUD.jB_Leer.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar 1 sola fila - por lo menos una" + e);
            }
        }
        // BORRADO de alguno de los datos
        if (e.getSource() == vista_Aviso_CRUD.jB_Borrar) {
            int filaInicio = vista_Aviso_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_Aviso_CRUD.jTableDatos.getSelectedRowCount();
            @SuppressWarnings("unchecked")
            ArrayList<String> listaNombre = new ArrayList();
            String nombre = "";
            String fechaP = "";
            int id_Admin = 0;
            int id_Logis = 0;

            // CONVERTIR EL STRING EN DATE     
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String avisoInString = vista_Aviso_CRUD.jT_Fecha_A.getText();
            java.sql.Date fecha_A = null;
            String parteInString = vista_Aviso_CRUD.jT_F_Parte.getText();
            java.sql.Date fecha_P = null;
            try {
                Date parsed = formatter.parse(avisoInString);
                fecha_A = new java.sql.Date(parsed.getTime());
                parsed = formatter.parse(parteInString);
                fecha_P = new java.sql.Date(parsed.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(ControladorCRUD_Aviso.class.getName()).log(Level.SEVERE, null, ex);
            }
            //nombre = String.valueOf(vista_Aviso_CRUD.jTableDatos.getValueAt(i + filaInicio, 2));
            id_Logis = Integer.parseInt(String.valueOf(vista_Aviso_CRUD.jTableDatos.getValueAt(filaInicio, 5)));
            id_Admin = Integer.parseInt(String.valueOf(vista_Aviso_CRUD.jTableDatos.getValueAt(filaInicio, 6)));
            int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Quieres borrar el parte de " + nombre + " ?");
            // Esta pregunta tiene 3 posibles respuestas:
            // SI=0  -- NO=1 -- CANCELAR =2
            if (rptaUsuario == 0) {
                modelo_Aviso_CRUD.eliminarAviso(id_Admin, fecha_P, id_Logis);
            }
            LlenarTabla(vista_Aviso_CRUD.jTableDatos);

        }
        // BOTON de Ok
        if (e.getSource() == vista_Aviso_CRUD.jB_OK) {

            String nombreBuscado = vista_Aviso_CRUD.jT_BuscarLogis.getText();

            // Cuando SI QUE hay texto en el campo BUSCAR
            if (!nombreBuscado.equals("")) {
                nombreBuscado = "%" + nombreBuscado + "%";
                DefaultTableModel modeloT = new DefaultTableModel();
                vista_Aviso_CRUD.jTableDatos.setModel(modeloT);
                modeloT.addColumn("F.AVISO");
                modeloT.addColumn("F.PARTE");
                modeloT.addColumn("NOMBRE");
                modeloT.addColumn("APELLIDO 1");
                modeloT.addColumn("AVISO");
                modeloT.addColumn("ID_Logis");
                modeloT.addColumn("ID_Admin");

                Object[] columna = new Object[7];
                // CREO UNA copia del ArrayList de la Base de datos
                // para ahorrar tiempo de búsqueda y conexión
                List<Aviso> ListaCopia = new ArrayList<>();
                ListaCopia = (List<Aviso>) modelo_Aviso_CRUD.buscarAvisoxNombre(nombreBuscado).clone();

                int numRegistros = ListaCopia.size();

                for (int i = 0; i < numRegistros; i++) {

                    columna[0] = ListaCopia.get(i).getFecha_aviso();
                    columna[1] = ListaCopia.get(i).getFecha_parte();
                    columna[2] = ListaCopia.get(i).getNombre();
                    columna[3] = ListaCopia.get(i).getApellido1();
                    columna[4] = ListaCopia.get(i).getTexto();
                    columna[5] = ListaCopia.get(i).getId_Logis();
                    columna[6] = ListaCopia.get(i).getId_Admin();

                    modeloT.addRow(columna);
                }
                JOptionPane.showMessageDialog(null, "Listado terminado");
            }
            vista_Aviso_CRUD.jT_BuscarLogis.setText("");
        } else { // NO HAY QUE BUSCAR NADA, SOLO ACTUALIZAR LOS VALORES

            String Aviso = vista_Aviso_CRUD.jT_Area_Aviso.getText();

            //           int id_Admin = Integer.parseInt(vista_Aviso_CRUD.jTableDatos.get getText());
            //         int id_Logis = Integer.parseInt(vista_Aviso_CRUD.jText_1.getText());
            int id_Admin = 0;
            int id_Logis = 0;
            java.sql.Date fecha_P = null;
            java.sql.Date fecha_A = null;

            String rptaEdit = modelo_Aviso_CRUD.editarAviso(fecha_A, Aviso, id_Admin, fecha_P, id_Logis);

            if (rptaEdit != null) {
                JOptionPane.showMessageDialog(null, rptaEdit);
            } else {
                JOptionPane.showMessageDialog(null, "Registro incorrecto" + e);
            }
            // Limpio los datos del formulario
            limpiar();
            // Vuelvo a habilitar los botones deshabilitados
            vista_Aviso_CRUD.jB_Leer.setEnabled(true);
            vista_Aviso_CRUD.jB_Borrar.setEnabled(true);
            vista_Aviso_CRUD.jB_Leer.setEnabled(true);

            // Refresco el listado para que aparezca el cambio hecho
            vista_Aviso_CRUD.jB_Leer.doClick();
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
