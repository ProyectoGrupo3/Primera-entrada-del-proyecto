package Controlador;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import Modelo.*;
import proyectofincurso.JF_Trabajador_CRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorCRUD_Trabajador implements ActionListener, KeyListener {

    JF_Trabajador_CRUD vista_Trabajador_CRUD = new JF_Trabajador_CRUD();
    Trabajador_CRUD modelo_Trabajador_CRUD = new Trabajador_CRUD();

    public ControladorCRUD_Trabajador(JF_Trabajador_CRUD vista_Trabajador_CRUD, Trabajador_CRUD modelo_Trabajador_CRUD) {

        this.modelo_Trabajador_CRUD = modelo_Trabajador_CRUD;
        this.vista_Trabajador_CRUD = vista_Trabajador_CRUD;

        this.vista_Trabajador_CRUD.jB_Crear.addActionListener(this);
        this.vista_Trabajador_CRUD.jB_Leer.addActionListener(this);
        this.vista_Trabajador_CRUD.jB_Actualizar.addActionListener(this);
        this.vista_Trabajador_CRUD.jB_Borrar.addActionListener(this);
        this.vista_Trabajador_CRUD.jB_OK.addActionListener(this);
        this.vista_Trabajador_CRUD.jText_1.addKeyListener(this);
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

        int numRegistros = modelo_Trabajador_CRUD.listTrabajador().size();

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = modelo_Trabajador_CRUD.listTrabajador().get(i).getID_trabajador();
            columna[1] = modelo_Trabajador_CRUD.listTrabajador().get(i).getDni();
            columna[2] = modelo_Trabajador_CRUD.listTrabajador().get(i).getNombre();
            columna[3] = modelo_Trabajador_CRUD.listTrabajador().get(i).getApellido1();
            columna[4] = modelo_Trabajador_CRUD.listTrabajador().get(i).getApellido2();
            columna[5] = modelo_Trabajador_CRUD.listTrabajador().get(i).getCalle();
            columna[6] = modelo_Trabajador_CRUD.listTrabajador().get(i).getPortal();
            columna[7] = modelo_Trabajador_CRUD.listTrabajador().get(i).getPiso();
            columna[8] = modelo_Trabajador_CRUD.listTrabajador().get(i).getMano();
            columna[9] = modelo_Trabajador_CRUD.listTrabajador().get(i).getTelef_personal();
            columna[10] = modelo_Trabajador_CRUD.listTrabajador().get(i).getMovil_empresa();
            columna[11] = modelo_Trabajador_CRUD.listTrabajador().get(i).getSalario();
            columna[12] = modelo_Trabajador_CRUD.listTrabajador().get(i).getFecha_nac();
            columna[13] = modelo_Trabajador_CRUD.listTrabajador().get(i).getCategoria();
            columna[14] = modelo_Trabajador_CRUD.listTrabajador().get(i).getCt();

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
    }

    public void actionPerformed(ActionEvent e) {
        
            // BOTON AÑADIR-CREAR
        if (e.getSource() == vista_Trabajador_CRUD.jB_Crear) {
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
            int Salario = Integer.parseInt(vista_Trabajador_CRUD.jText_12.getText());
            // CONVERTIR EL STRING EN DATE
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String dateInString = vista_Trabajador_CRUD.jText_13.getText();
            Date FeNac = null;
            try {
                FeNac = (Date) formatter.parse(dateInString);
            } catch (ParseException ex) {
                Logger.getLogger(ControladorCRUD_Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }

            String Categoria = vista_Trabajador_CRUD.jComboBox14.getToolTipText();
            int CT = Integer.parseInt(vista_Trabajador_CRUD.jText_15.getText());

            String rptaRegistro = modelo_Trabajador_CRUD.insertTrabajador(ID, dni, Nombre, Apellido1, Apellido2, Calle, Portal, Piso, Mano, T_P, T_E, Salario, FeNac, Categoria, CT);

            if (rptaRegistro != null) {
                JOptionPane.showMessageDialog(null, rptaRegistro);
            } else {
                JOptionPane.showMessageDialog(null, "Registro incorrecto");
            }
        }
        if (e.getSource() == vista_Trabajador_CRUD.jB_Leer) {
            LlenarTabla(vista_Trabajador_CRUD.jTableDatos);
        }
        if (e.getSource() == vista_Trabajador_CRUD.jB_Actualizar) {
            int filaEditar = vista_Trabajador_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_Trabajador_CRUD.jTableDatos.getSelectedRowCount();
            if (filaEditar > 0 && numFilas == 1) {
                vista_Trabajador_CRUD.jText_1.setText(String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(filaEditar, 0)));
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
        if (e.getSource() == vista_Trabajador_CRUD.jB_Borrar) {
            int filaInicio = vista_Trabajador_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_Trabajador_CRUD.jTableDatos.getSelectedRowCount();
            ArrayList<String> listaNombre = new ArrayList();
            String nombre = "";
            if (filaInicio > 0) {
                for (int i = 0; i < numFilas; i++) {
                    nombre = String.valueOf(vista_Trabajador_CRUD.jTableDatos.getValueAt(i + filaInicio, 0));
                    listaNombre.add(nombre);
                }
                for (int i = 0; i < numFilas; i++) {
                    int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Quieres borrar el registro " + nombre + " ?");
                    // Esta pregunta tiene 3 posibles respuestas:
                    // SI=0  -- NO=1 -- CANCELAR =2
                    if (rptaUsuario == 0) {
                        modelo_Trabajador_CRUD.eliminarTrabajador(nombre);
                    }
                }

                LlenarTabla(vista_Trabajador_CRUD.jTableDatos);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona por lo menos una fila a borrar.");

            }
        }
        if (e.getSource() == vista_Trabajador_CRUD.jB_OK) {
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
            int Salario = Integer.parseInt(vista_Trabajador_CRUD.jText_12.getText());
            // CONVERTIR EL STRING EN DATE
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String dateInString = vista_Trabajador_CRUD.jText_13.getText();
            Date FeNac = null;
            String Categoria = vista_Trabajador_CRUD.jComboBox14.getToolTipText();
            int ct = Integer.parseInt(vista_Trabajador_CRUD.jText_15.getText());

            int rptaEdit = modelo_Trabajador_CRUD.editarTrabajador(ID, dni,Nombre
            , Apellido1, Apellido2, Calle, Portal, Piso, Mano, T_P, T_E
            ,  Salario,  FeNac,  Categoria, ct);
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
        }

    }    
    
    @Override
        public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
