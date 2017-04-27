package Controlador;

import java.text.*;
import java.util.*;

import Modelo.*;
import proyectofincurso.JF_Trabajador_CRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.net.aso.e;
import static oracle.sql.NUMBER.e;
import static sun.applet.AppletViewer.parse;

public class ControladorCRUD_Trabajador implements ActionListener, KeyListener {

    JF_Trabajador_CRUD vista_Trabajador_CRUD = new JF_Trabajador_CRUD();
    Trabajador_CRUD modelo_Trabajador_CRUD = new Trabajador_CRUD();

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
        this.vista_Trabajador_CRUD.jText_Buscar.addKeyListener(this);

    }

    public void Inicializar_Trabajador_CRUD() {

    }

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
            columna[12] = ListaCopia.get(i).getFecha_nac();
            columna[13] = ListaCopia.get(i).getCategoria();
            columna[14] = ListaCopia.get(i).getCt();

            modeloTr.addRow(columna);
        }
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
        vista_Trabajador_CRUD.jText_15.setText(null);
        
        // Para que el cursor se ponga en este campo después de limpiar los datos
        vista_Trabajador_CRUD.jText_2.requestFocus();
    }

    public void actionPerformed(ActionEvent e) {
        
            // BOTON AÑADIR-CREAR
        if (e.getSource() == vista_Trabajador_CRUD.jB_Crear) {
            // Asigno el valor 0 al ID para que no de error antes de generarlo
            // con la SECUENCIA de la base de datos
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
            int Salario = Integer.parseInt(vista_Trabajador_CRUD.jText_12.getText());
            // CONVERTIR EL STRING EN DATE     
            String dateInString = vista_Trabajador_CRUD.jText_13.getText();
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate FeNac = LocalDate.parse(dateInString, formatoFecha);
            
            String Categoria = vista_Trabajador_CRUD.jComboBox14.getToolTipText();
            int CT = Integer.parseInt(vista_Trabajador_CRUD.jText_15.getText());

            String rptaRegistro = modelo_Trabajador_CRUD.insertTrabajador(ID, dni, Nombre, Apellido1, Apellido2, Calle, Portal, Piso, Mano, T_P, T_E, Salario, FeNac, Categoria, CT);

            if (rptaRegistro != null) {
                JOptionPane.showMessageDialog(null, rptaRegistro);
            } else {
                JOptionPane.showMessageDialog(null, "Registro incorrecto");
            }
        }
        // BOTÓN LEER
        if (e.getSource() == vista_Trabajador_CRUD.jB_Leer) {
            LlenarTabla(vista_Trabajador_CRUD.jTableDatos);
        }
        // BOTÓN MODIFICACIÓN
        if (e.getSource() == vista_Trabajador_CRUD.jB_Actualizar) {
            int filaEditar = vista_Trabajador_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_Trabajador_CRUD.jTableDatos.getSelectedRowCount();
            if (filaEditar > 0 && numFilas == 1) {
                
            // Subo los valores de la fila a los campos de edición
                vista_Trabajador_CRUD.jText_1.setText(String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaEditar, opia.get(i).getPiso();
            columna[8] = ListaCopia.get(i).getMano();
            columna[9] = ListaCopia.get(i).getTelef_personal();
            columna[10] = ListaCopia.get(i).getMovil_empresa();
            columna[11] = ListaCopia.get(i).getSalario();
            columna[12] = ListaCopia.get(i).getFecha_nac();
            columna[13] = ListaCopia.get(i).getCategoria();
            columna[14] = ListaCopia.get(i).getCt();

            modeloTr.addRow(columna);
        }
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
        vista_Trabajador_CRUD.jText_15.setText(null);
        
        // Para que el cursor se ponga en este campo después de limpiar los datos
        vista_Trabajador_CRUD.jText_2.requestFocus();
    }

    public void actionPerformed(ActionEvent e) {
        
            // BOTON AÑADIR-CREAR
        if (e.getSource() == vista_Trabajador_CRUD.jB_Crear) {
            // Asigno el valor 0 al ID para que no de error antes de generarlo
            // con la SECUENCIA de la base de datos
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
            int Salario = Integer.parseInt(vista_Trabajador_CRUD.jText_12.getText());
            // CONVERTIR EL STRING EN DATE     
            String dateInString = vista_Trabajador_CRUD.jText_13.getText();
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate FeNac = LocalDate.parse(dateInString, formatoFecha);
            
            String Categoria = vista_Trabajador_CRUD.jComboBox14.getToolTipText();
            int CT = Integer.parseInt(vista_Trabajador_CRUD.jText_15.getText());

            String rptaRegistro = modelo_Trabajador_CRUD.insertTrabajador(ID, dni, Nombre, Apellido1, Apellido2, Calle, Portal, Piso, Mano, T_P, T_E, Salario, FeNac, Categoria, CT);

            if (rptaRegistro != null) {
                JOptionPane.showMessageDialog(null, rptaRegistro);
            } else {
                JOptionPane.showMessageDialog(null, "Registro incorrecto");
            }
        }
        // BOTÓN LEER
        if (e.getSource() == vista_Trabajador_CRUD.jB_Leer) {
            LlenarTabla(vista_Trabajador_CRUD.jTableDatos);
        }
        // BOTÓN MODIFICACIÓN
        if (e.getSource() == vista_Trabajador_CRUD.jB_Actualizar) {
            int filaEditar = vista_Trabajador_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_Trabajador_CRUD.jTableDatos.getSelectedRowCount();
            if (filaEditar > 0 && numFilas == 1) {
                
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
                vista_Trabajador_CRUD.jComboBox14.setSelectedItem(String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaEditar, 13)));
                vista_Trabajador_CRUD.jText_15.setText(String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaEditar, 14)));
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
            if (filaInicio > 0) {
                for (int i = 0; i < numFilas; i++) {
                    nombre = String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(i + filaInicio, 1));
                    num = String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaInicio, 0));
                    id = Integer.parseInt(num);
                    listaNombre.add(no