package Controlador;

import Modelo.*;
import proyectofincurso.JF_Vehiculo_CRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorCRUD_Vehiculo implements ActionListener, KeyListener {

    JF_Vehiculo_CRUD vista_Vehiculo_CRUD = new JF_Vehiculo_CRUD();
    Vehiculo_CRUD modelo_Vehiculo_CRUD = new Vehiculo_CRUD();

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorCRUD_Vehiculo(JF_Vehiculo_CRUD vista_Vehiculo_CRUD, Vehiculo_CRUD modelo_Vehiculo_CRUD) {
        this.modelo_Vehiculo_CRUD = modelo_Vehiculo_CRUD;
        this.vista_Vehiculo_CRUD = vista_Vehiculo_CRUD;
        // "Escucha" los botones pulsados en la pantalla JF_Vehiculo_CRUD
        this.vista_Vehiculo_CRUD.jB_Crear.addActionListener(this);
        this.vista_Vehiculo_CRUD.jB_Leer.addActionListener(this);
        this.vista_Vehiculo_CRUD.jB_Actualizar.addActionListener(this);
        this.vista_Vehiculo_CRUD.jB_Borrar.addActionListener(this);
        this.vista_Vehiculo_CRUD.jB_OK.addActionListener(this);
        this.vista_Vehiculo_CRUD.jText_2.addKeyListener(this);
        this.vista_Vehiculo_CRUD.jText_3.addKeyListener(this);
        this.vista_Vehiculo_CRUD.jText_4.addKeyListener(this);
        this.vista_Vehiculo_CRUD.jText_5.addKeyListener(this);
        this.vista_Vehiculo_CRUD.jText_6.addKeyListener(this);

    }

    @SuppressWarnings("unchecked")
    public void LlenarTabla(JTable tablaV) {
        DefaultTableModel modeloV = new DefaultTableModel();
        tablaV.setModel(modeloV);
//      PARA PONER DESDE AQUÍ LOS NOMBRES DE LAS COLUMNAS
        modeloV.addColumn("MATRICULA");
        modeloV.addColumn("MARCA");
        modeloV.addColumn("MODELO");
        modeloV.addColumn("COLOR");
        modeloV.addColumn("KMS");

        Object[] columna = new Object[5];
        // CREO UNA copia del ArrayList de la Base de datos
        // para ahorrar tiempo de búsqueda y conexión
        List<Vehiculo> ListaCopia = new ArrayList<>();
        ListaCopia = (List<Vehiculo>) modelo_Vehiculo_CRUD.listVehiculo().clone();

        int numRegistros = ListaCopia.size();

        for (int i = 0; i < numRegistros; i++) {

            columna[0] = ListaCopia.get(i).getMatricula();
            columna[1] = ListaCopia.get(i).getMarca();
            columna[2] = ListaCopia.get(i).getModelo();
            columna[3] = ListaCopia.get(i).getColor();
            columna[4] = ListaCopia.get(i).getKms();

            modeloV.addRow(columna);
        }
        JOptionPane.showMessageDialog(null, "Listado terminado");
    }

    public void limpiar() {

        vista_Vehiculo_CRUD.jText_2.setEditable(true);
        vista_Vehiculo_CRUD.jText_2.setText("");
        vista_Vehiculo_CRUD.jText_3.setText("");
        vista_Vehiculo_CRUD.jText_4.setText("");
        vista_Vehiculo_CRUD.jText_5.setText("");
        vista_Vehiculo_CRUD.jText_6.setText(null);

        // Para que el cursor se ponga en este campo después de limpiar los datos
        vista_Vehiculo_CRUD.jText_2.requestFocus();
    }

    @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent e) {

        // CREAR: ALTA de datos nuevos
        if (e.getSource() == vista_Vehiculo_CRUD.jB_Crear) {

            String Matricula = vista_Vehiculo_CRUD.jText_2.getText();
            String Marca = vista_Vehiculo_CRUD.jText_3.getText();
            String Modelo = vista_Vehiculo_CRUD.jText_4.getText();
            String Color = vista_Vehiculo_CRUD.jText_5.getText();
            int Kms = Integer.parseInt(vista_Vehiculo_CRUD.jText_6.getText());

            String rptaRegistro = modelo_Vehiculo_CRUD.insertVehiculo(Matricula, Marca, Modelo, Color, Kms);
            if (rptaRegistro != null) {
                JOptionPane.showMessageDialog(null, rptaRegistro);
            } else {
                JOptionPane.showMessageDialog(null, "Registro incorrecto" + e);
            }
            limpiar();
            vista_Vehiculo_CRUD.jB_Leer.doClick();
        }

        // LECTURA de los datos en la tabla
        if (e.getSource() == vista_Vehiculo_CRUD.jB_Leer) {
            LlenarTabla(vista_Vehiculo_CRUD.jTableDatos);
        }

        // MODIFICACIÓN de los datos introducidos
        if (e.getSource() == vista_Vehiculo_CRUD.jB_Actualizar) {
            int filaEditar = vista_Vehiculo_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_Vehiculo_CRUD.jTableDatos.getSelectedRowCount();

            if (filaEditar >= 0 && numFilas == 1) {

                // Subo los valores de la fila a los campos de edición
                vista_Vehiculo_CRUD.jText_2.setText(String.valueOf(vista_Vehiculo_CRUD.jTableDatos.getValueAt(filaEditar, 0)));
                vista_Vehiculo_CRUD.jText_3.setText(String.valueOf(vista_Vehiculo_CRUD.jTableDatos.getValueAt(filaEditar, 1)));
                vista_Vehiculo_CRUD.jText_4.setText(String.valueOf(vista_Vehiculo_CRUD.jTableDatos.getValueAt(filaEditar, 2)));
                vista_Vehiculo_CRUD.jText_5.setText(String.valueOf(vista_Vehiculo_CRUD.jTableDatos.getValueAt(filaEditar, 3)));
                vista_Vehiculo_CRUD.jText_6.setText(String.valueOf(vista_Vehiculo_CRUD.jTableDatos.getValueAt(filaEditar, 4)));

                // Como la matrícula es clave lo deshabilito para que no pueda modificarse
                vista_Vehiculo_CRUD.jText_2.setEditable(false);

                // Deshabilito los botones para que no puedan usarse durante la edición
                vista_Vehiculo_CRUD.jB_Crear.setEnabled(false);
                vista_Vehiculo_CRUD.jB_Borrar.setEnabled(false);
                vista_Vehiculo_CRUD.jB_Leer.setEnabled(false);
                vista_Vehiculo_CRUD.jB_Salir.setEnabled(false);
                vista_Vehiculo_CRUD.jB_Volver.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar 1 sola fila - por lo menos una" + e);
            }
        }
        // BORRADO de alguno de los datos
        if (e.getSource() == vista_Vehiculo_CRUD.jB_Borrar) {
            int filaInicio = vista_Vehiculo_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_Vehiculo_CRUD.jTableDatos.getSelectedRowCount();
            @SuppressWarnings("unchecked")
            ArrayList<String> listaNombre = new ArrayList();
            String matricula = "";

            if (filaInicio >= 0) {
                for (int i = 0; i < numFilas; i++) {
                    matricula = String.valueOf(vista_Vehiculo_CRUD.jTableDatos.getValueAt(i + filaInicio, 0));

                    listaNombre.add(matricula);
                }
                for (int i = 0; i < numFilas; i++) {
                    int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Quieres borrar el registro " + matricula + " ?");
                    // Esta pregunta tiene 3 posibles respuestas:
                    // SI=0  -- NO=1 -- CANCELAR =2
                    if (rptaUsuario == 0) {
                        modelo_Vehiculo_CRUD.eliminarVehiculo(matricula);
                    }
                }

                LlenarTabla(vista_Vehiculo_CRUD.jTableDatos);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona por lo menos una fila a borrar.");

            }
        }
        // BOTON de Ok
        if (e.getSource() == vista_Vehiculo_CRUD.jB_OK) {

            String nombreBuscado = vista_Vehiculo_CRUD.jText_Buscar.getText();

            // Cuando SI QUE hay texto en el campo BUSCAR
            if (!nombreBuscado.equals("")) {
                nombreBuscado = "%" + nombreBuscado + "%";
                DefaultTableModel modeloV = new DefaultTableModel();
                vista_Vehiculo_CRUD.jTableDatos.setModel(modeloV);
                modeloV.addColumn("MATRICULA");
                modeloV.addColumn("MARCA");
                modeloV.addColumn("MODELO");
                modeloV.addColumn("COLOR");
                modeloV.addColumn("KMS");

                Object[] columna = new Object[5];
                // CREO UNA copia del ArrayList de la Base de datos
                // para ahorrar tiempo de búsqueda y conexión                
                List<Vehiculo> ListaCopia = new ArrayList<>();
                ListaCopia = (List<Vehiculo>) modelo_Vehiculo_CRUD.buscarVehiculoxNombre(nombreBuscado).clone();
                int numRegistros = ListaCopia.size();
                for (int i = 0; i < numRegistros; i++) {
                    columna[0] = ListaCopia.get(i).getMatricula();
                    columna[1] = ListaCopia.get(i).getMarca();
                    columna[2] = ListaCopia.get(i).getModelo();
                    columna[3] = ListaCopia.get(i).getColor();
                    columna[4] = ListaCopia.get(i).getKms();

                    modeloV.addRow(columna);
                }
                JOptionPane.showMessageDialog(null, "Listado terminado");
                vista_Vehiculo_CRUD.jText_Buscar.setText("");
            } else { // NO HAY QUE BUSCAR NADA, SOLO ACTUALIZAR LOS VALORES
                String Matricula = vista_Vehiculo_CRUD.jText_2.getText();
                String Marca = vista_Vehiculo_CRUD.jText_3.getText();
                String Modelo = vista_Vehiculo_CRUD.jText_4.getText();
                String Color = vista_Vehiculo_CRUD.jText_5.getText();
                int Kms = Integer.parseInt(vista_Vehiculo_CRUD.jText_6.getText());

                String rptaEdit = modelo_Vehiculo_CRUD.editarVehiculo(Matricula, Marca, Modelo, Color, Kms);

                if (rptaEdit != null) {
                    JOptionPane.showMessageDialog(null, rptaEdit);
                } else {
                    JOptionPane.showMessageDialog(null, "Registro incorrecto" + e);
                }
                // Limpio los datos del formulario
                limpiar();
                // Vuelvo a habilitar los botones deshabilitados
                vista_Vehiculo_CRUD.jB_Crear.setEnabled(true);
                vista_Vehiculo_CRUD.jB_Borrar.setEnabled(true);
                vista_Vehiculo_CRUD.jB_Leer.setEnabled(true);
                vista_Vehiculo_CRUD.jB_Salir.setEnabled(true);
                vista_Vehiculo_CRUD.jB_Volver.setEnabled(true);

                // Refresco el listado para que aparezca el cambio hecho
                vista_Vehiculo_CRUD.jB_Leer.doClick();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e
    ) {
        // Para controlar el texto que se pone en el campo "número" sea un número
        if (e.getSource() == vista_Vehiculo_CRUD.jText_6) {
            char c = e.getKeyChar();
            if (c < '0' || c > '9') {
                e.consume();
            }
        }

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
