package Controlador;

import Modelo.*;
import proyectofincurso.JF_CT_CRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import static javax.swing.text.html.HTML.Attribute.ID;

public class ControladorCRUD_CT implements ActionListener, KeyListener {

    JF_CT_CRUD vista_CT_CRUD = new JF_CT_CRUD();
    CT_CRUD modelo_CT_CRUD = new CT_CRUD();

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorCRUD_CT(JF_CT_CRUD vista_CT_CRUD, CT_CRUD modelo_CT_CRUD) {
        this.modelo_CT_CRUD = modelo_CT_CRUD;
        this.vista_CT_CRUD = vista_CT_CRUD;
        // "Escucha" los botones pulsados en la pantalla JF_CT_CRUD
        this.vista_CT_CRUD.jB_Crear.addActionListener(this);
        this.vista_CT_CRUD.jB_Leer.addActionListener(this);
        this.vista_CT_CRUD.jB_Actualizar.addActionListener(this);
        this.vista_CT_CRUD.jB_Borrar.addActionListener(this);
        this.vista_CT_CRUD.jB_OK.addActionListener(this);
        this.vista_CT_CRUD.jText_2.addKeyListener(this);
        this.vista_CT_CRUD.jText_3.addKeyListener(this);
        this.vista_CT_CRUD.jText_4.addKeyListener(this);
        this.vista_CT_CRUD.jText_5.addKeyListener(this);
        this.vista_CT_CRUD.jText_6.addKeyListener(this);
        this.vista_CT_CRUD.jText_7.addKeyListener(this);
        this.vista_CT_CRUD.jText_8.addKeyListener(this);
        this.vista_CT_CRUD.jText_Buscar.addKeyListener(this);

    }

    public void Inicializar_CT_CRUD() {

    }

    public void LlenarTabla(JTable tablaCT) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaCT.setModel(modeloT);

//      PARA PONER DESDE AQUÍ LOS NOMBRES DE LAS COLUMNAS
        modeloT.addColumn("ID");
        modeloT.addColumn("NOMBRE");
        modeloT.addColumn("CALLE");
        modeloT.addColumn("NUM");
        modeloT.addColumn("C.P.");
        modeloT.addColumn("CIUDAD");
        modeloT.addColumn("PROVINCIA");
        modeloT.addColumn("TELEFONO");

        Object[] columna = new Object[8];
        // CREO UNA copia del ArrayList de la Base de datos
        // para ahorrar tiempo de búsqueda y conexión
        List<CT> ListaCopia = new ArrayList<>();
        ListaCopia = (List<CT>) modelo_CT_CRUD.listCT().clone();

        int numRegistros = ListaCopia.size();

        for (int i = 0; i < numRegistros; i++) {

            columna[0] = ListaCopia.get(i).getID();
            columna[1] = ListaCopia.get(i).getNombre();
            columna[2] = ListaCopia.get(i).getCalle();
            columna[3] = ListaCopia.get(i).getNumero();
            columna[4] = ListaCopia.get(i).getCp();
            columna[5] = ListaCopia.get(i).getCiudad();
            columna[6] = ListaCopia.get(i).getProvincia();
            columna[7] = ListaCopia.get(i).getTelefono();
            modeloT.addRow(columna);
        }
    }

    public void limpiar() {
        vista_CT_CRUD.jText_1.setText("");
        vista_CT_CRUD.jText_1.setEditable(true);
        vista_CT_CRUD.jText_2.setText("");
        vista_CT_CRUD.jText_3.setText("");
        vista_CT_CRUD.jText_4.setText("");
        vista_CT_CRUD.jText_5.setText("");
        vista_CT_CRUD.jText_6.setText("");
        vista_CT_CRUD.jText_7.setText("");
        vista_CT_CRUD.jText_8.setText("");
        // Para que el cursor se ponga en este campo después de limpiar los datos
        vista_CT_CRUD.jText_2.requestFocus();
    }

    public void actionPerformed(ActionEvent e) {

        // CREAR: ALTA de datos nuevos
        if (e.getSource() == vista_CT_CRUD.jB_Crear) {

            // Asigno el valor 0 al ID para que no de error antes de generarlo
            // con la SECUENCIA de la base de datos
            int ID = 0;
            String Nombre = vista_CT_CRUD.jText_2.getText();
            String Calle = vista_CT_CRUD.jText_3.getText();
            int Num = Integer.parseInt(vista_CT_CRUD.jText_4.getText());
            String cp = vista_CT_CRUD.jText_5.getText();
            String Ciudad = vista_CT_CRUD.jText_6.getText();
            String Provincia = vista_CT_CRUD.jText_7.getText();
            String Telefono = vista_CT_CRUD.jText_8.getText();

            String rptaRegistro = modelo_CT_CRUD.insertCT(ID, Nombre, Calle, Num, cp, Ciudad, Provincia, Telefono);

            if (rptaRegistro != null) {
                JOptionPane.showMessageDialog(null, rptaRegistro);
                limpiar();
                vista_CT_CRUD.jB_Leer.doClick();
            } else {
                JOptionPane.showMessageDialog(null, "Registro incorrecto" + e);
            }
        }

        // LECTURA de los datos en la tabla
        if (e.getSource() == vista_CT_CRUD.jB_Leer) {
            LlenarTabla(vista_CT_CRUD.jTableDatos);
        }

        // MODIFICACIÓN de los datos introducidos
        if (e.getSource() == vista_CT_CRUD.jB_Actualizar) {
            int filaEditar = vista_CT_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_CT_CRUD.jTableDatos.getSelectedRowCount();

            if (filaEditar >= 0 && numFilas == 1) {

                // Subo los valores de la fila a los campos de edición
                vista_CT_CRUD.jText_1.setText(String.valueOf(vista_CT_CRUD.jTableDatos.getValueAt(filaEditar, 0)));
                vista_CT_CRUD.jText_2.setText(String.valueOf(vista_CT_CRUD.jTableDatos.getValueAt(filaEditar, 1)));
                vista_CT_CRUD.jText_3.setText(String.valueOf(vista_CT_CRUD.jTableDatos.getValueAt(filaEditar, 2)));
                vista_CT_CRUD.jText_4.setText(String.valueOf(vista_CT_CRUD.jTableDatos.getValueAt(filaEditar, 3)));
                vista_CT_CRUD.jText_5.setText(String.valueOf(vista_CT_CRUD.jTableDatos.getValueAt(filaEditar, 4)));
                vista_CT_CRUD.jText_6.setText(String.valueOf(vista_CT_CRUD.jTableDatos.getValueAt(filaEditar, 5)));
                vista_CT_CRUD.jText_7.setText(String.valueOf(vista_CT_CRUD.jTableDatos.getValueAt(filaEditar, 6)));
                vista_CT_CRUD.jText_8.setText(String.valueOf(vista_CT_CRUD.jTableDatos.getValueAt(filaEditar, 7)));

                // Como el ID es clave lo deshabilito para que no pueda modificarse
                vista_CT_CRUD.jText_1.setEditable(false);

                // Deshabilito los botones para que no puedan usarse durante la edición
                vista_CT_CRUD.jB_Crear.setEnabled(false);
                vista_CT_CRUD.jB_Borrar.setEnabled(false);
                vista_CT_CRUD.jB_Leer.setEnabled(false);
                vista_CT_CRUD.jB_Salir.setEnabled(false);
                vista_CT_CRUD.jB_Volver.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar 1 sola fila - por lo menos una" + e);
            }
        }
        // BORRADO de alguno de los datos
        if (e.getSource() == vista_CT_CRUD.jB_Borrar) {
            int filaInicio = vista_CT_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_CT_CRUD.jTableDatos.getSelectedRowCount();
            ArrayList<String> listaNombre = new ArrayList();
            String nombre = "";
            String num = "";
            int id = 0;
            if (filaInicio > 0) {
                for (int i = 0; i < numFilas; i++) {
                    nombre = String.valueOf(vista_CT_CRUD.jTableDatos.getValueAt(i + filaInicio, 1));
                    num = String.valueOf(vista_CT_CRUD.jTableDatos.getValueAt(filaInicio, 0));
                    id = Integer.parseInt(num);
                    listaNombre.add(nombre);
                }
                for (int i = 0; i < numFilas; i++) {
                    int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Quieres borrar el registro " + nombre + " ?");
                    // Esta pregunta tiene 3 posibles respuestas:
                    // SI=0  -- NO=1 -- CANCELAR =2
                    if (rptaUsuario == 0) {
                        modelo_CT_CRUD.eliminarCT(id);
                    }
                }

                LlenarTabla(vista_CT_CRUD.jTableDatos);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona por lo menos una fila a borrar.");

            }
        }
        // BOTON de Ok
        if (e.getSource() == vista_CT_CRUD.jB_OK) {
            int ID = Integer.parseInt(vista_CT_CRUD.jText_1.getText());
            String Nombre = vista_CT_CRUD.jText_2.getText();
            String Calle = vista_CT_CRUD.jText_3.getText();
            int Num = Integer.parseInt(vista_CT_CRUD.jText_4.getText());
            String cp = vista_CT_CRUD.jText_5.getText();
            String Ciudad = vista_CT_CRUD.jText_6.getText();
            String Provincia = vista_CT_CRUD.jText_7.getText();
            String Telefono = vista_CT_CRUD.jText_8.getText();

            String rptaEdit = modelo_CT_CRUD.editarCT(ID, Nombre, Calle, Num, cp, Ciudad, Provincia, Telefono);

            if (rptaEdit != null) {
                JOptionPane.showMessageDialog(null, rptaEdit);
            } else {
                JOptionPane.showMessageDialog(null, "Registro incorrecto" + e);
            }
            // Limpio los datos del formulario
            limpiar();
            // Vuelvo a habilitar los botones deshabilitados
            vista_CT_CRUD.jB_Crear.setEnabled(true);
            vista_CT_CRUD.jB_Borrar.setEnabled(true);
            vista_CT_CRUD.jB_Leer.setEnabled(true);
            vista_CT_CRUD.jB_Salir.setEnabled(true);
            vista_CT_CRUD.jB_Volver.setEnabled(true);

            // Refresco el listado para que aparezca el cambio hecho
            vista_CT_CRUD.jB_Leer.doClick();

        }
        // OPCIÓN DE BUSCAR POR NOMBRE
        if (e.getSource() == vista_CT_CRUD.jText_Buscar) {
            String nombre = vista_CT_CRUD.jText_Buscar.getText();

            DefaultTableModel modeloT = new DefaultTableModel();
            vista_CT_CRUD.jTableDatos.setModel(modeloT);

            modeloT.addColumn("ID");
            modeloT.addColumn("NOMBRE");
            modeloT.addColumn("CALLE");
            modeloT.addColumn("NUM");
            modeloT.addColumn("C.P.");
            modeloT.addColumn("CIUDAD");
            modeloT.addColumn("PROVINCIA");
            modeloT.addColumn("TELEFONO");

            Object[] columna = new Object[8];

            int numRegistros = modelo_CT_CRUD.buscarCTxNombre(nombre).size();

            for (int i = 0; i < numRegistros; i++) {
                columna[0] = modelo_CT_CRUD.buscarCTxNombre(nombre).get(i).getID();
                columna[1] = modelo_CT_CRUD.buscarCTxNombre(nombre).get(i).getNombre();
                columna[2] = modelo_CT_CRUD.buscarCTxNombre(nombre).get(i).getCalle();
                columna[3] = modelo_CT_CRUD.buscarCTxNombre(nombre).get(i).getNumero();
                columna[4] = modelo_CT_CRUD.buscarCTxNombre(nombre).get(i).getCp();
                columna[5] = modelo_CT_CRUD.buscarCTxNombre(nombre).get(i).getCiudad();
                columna[6] = modelo_CT_CRUD.buscarCTxNombre(nombre).get(i).getProvincia();
                columna[7] = modelo_CT_CRUD.buscarCTxNombre(nombre).get(i).getTelefono();
                modeloT.addRow(columna);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e
    ) {
        // Para controlar el texto que se pone en el campo "número" sea un número
        if (e.getSource() == vista_CT_CRUD.jText_4) {
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
        // CONTROL de la longitud del texto introducido
        if (e.getSource() == vista_CT_CRUD.jText_5) {
            String cp = vista_CT_CRUD.jText_5.getText();
            int l = cp.length();
            if (l > 5) {
                JOptionPane.showMessageDialog(null, "Solo se admiten Códigos Postales de 5 dígitos.");
            }
        }
    }
}
