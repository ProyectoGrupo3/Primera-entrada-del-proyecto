package Controlador;

import Modelo.*;
import proyectofincurso.JF_Cabe_Parte_CRUD;

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

public class ControladorCRUD_Cabe implements ActionListener, KeyListener {

    JF_Cabe_Parte_CRUD vista_Cabe_Parte_CRUD = new JF_Cabe_Parte_CRUD();
    Cabe_Parte_CRUD modelo_Cabe_Parte_CRUD = new Cabe_Parte_CRUD();

 //   Linea_Parte_CRUD modelo_Linea_Parte_CRUD = new Linea_Parte_CRUD();

    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorCRUD_Cabe(JF_Cabe_Parte_CRUD vista_Cabe_Parte_CRUD, Cabe_Parte_CRUD modelo_Cabe_Parte_CRUD) {
        this.modelo_Cabe_Parte_CRUD = modelo_Cabe_Parte_CRUD;
        this.vista_Cabe_Parte_CRUD = vista_Cabe_Parte_CRUD;
        // "Escucha" los botones pulsados en la pantalla JF_Cabe_Parte_CRUD
        this.vista_Cabe_Parte_CRUD.jB_Crear.addActionListener(this);
        this.vista_Cabe_Parte_CRUD.jB_Leer.addActionListener(this);
        this.vista_Cabe_Parte_CRUD.jB_Actualizar.addActionListener(this);
        this.vista_Cabe_Parte_CRUD.jB_Borrar.addActionListener(this);
        this.vista_Cabe_Parte_CRUD.jB_Ok.addActionListener(this);
        this.vista_Cabe_Parte_CRUD.jText_1.addKeyListener(this);
        //this.vista_Cabe_Parte_CRUD.jList_Vehiculo.addKeyListener(this);
        this.vista_Cabe_Parte_CRUD.jText_3.addKeyListener(this);
        this.vista_Cabe_Parte_CRUD.jText_4.addKeyListener(this);
        this.vista_Cabe_Parte_CRUD.jText_5.addKeyListener(this);
        this.vista_Cabe_Parte_CRUD.jText_6.addKeyListener(this);
        this.vista_Cabe_Parte_CRUD.jText_7.addKeyListener(this);
        this.vista_Cabe_Parte_CRUD.jText_8.addKeyListener(this);
        this.vista_Cabe_Parte_CRUD.jText_Area_9.addKeyListener(this);
        this.vista_Cabe_Parte_CRUD.jCB_Cerrado.addKeyListener(this);
        this.vista_Cabe_Parte_CRUD.jCB_Verificado.addKeyListener(this);
        this.vista_Cabe_Parte_CRUD.jText_Bdia.addKeyListener(this);
        this.vista_Cabe_Parte_CRUD.jText_Bnombre.addKeyListener(this);
    }

    @SuppressWarnings("unchecked")
    public void LlenarTabla(JTable tablaLinea_Parte) {
        DefaultTableModel modeloLP = new DefaultTableModel();
        tablaLinea_Parte.setModel(modeloLP);
//      PARA PONER DESDE AQUÍ LOS NOMBRES DE LAS COLUMNAS
        modeloLP.addColumn("H.Inicio");
        modeloLP.addColumn("H.Final");
        modeloLP.addColumn("Fecha");
        modeloLP.addColumn("Id_T");
        modeloLP.addColumn("Nombre");
        modeloLP.addColumn("Apellido 1");

        Object[] columna = new Object[6];
        // CREO UNA copia del ArrayList de la Base de datos
        // para ahorrar tiempo de búsqueda y conexión
        List<Linea_Parte> ListaCopia = new ArrayList<>();
//        ListaCopia = (List<Linea_Parte>) modelo_Linea_Parte_CRUD.listLinea_Parte().clone();

        int numRegistros = ListaCopia.size();

        for (int i = 0; i < numRegistros; i++) {

            columna[0] = ListaCopia.get(i).getHora_inicio();
            columna[1] = ListaCopia.get(i).getHora_final();
            // ARREGLAR EL FORMATO DE LA FECHA
            String Fecha_YMD = ListaCopia.get(i).getFecha().toString();
            String Fecha_dma = Fecha_YMD.substring(8, 10)+"-"+Fecha_YMD.substring(5, 7)+"-"+Fecha_YMD.substring(0, 4);            
            columna[2] = Fecha_dma;
            columna[3] = ListaCopia.get(i).getId_trabajador();
            columna[4] = ListaCopia.get(i).getNombre();
            columna[5] = ListaCopia.get(i).getApellido1();
            modeloLP.addRow(columna);
        }
        JOptionPane.showMessageDialog(null, "Listado terminado");
    }

    public void limpiar() {
        vista_Cabe_Parte_CRUD.jText_1.setText(null);
        vista_Cabe_Parte_CRUD.jList_Vehiculo.setVisibleRowCount(0);
        vista_Cabe_Parte_CRUD.jText_3.setText("");
        vista_Cabe_Parte_CRUD.jText_4.setText("");
        vista_Cabe_Parte_CRUD.jText_5.setText("");
        vista_Cabe_Parte_CRUD.jText_6.setText("");
        vista_Cabe_Parte_CRUD.jText_7.setText("");
        vista_Cabe_Parte_CRUD.jText_Area_9.setText("Incidencias: ");
        vista_Cabe_Parte_CRUD.jText_8.setText(null);
        vista_Cabe_Parte_CRUD.jCB_Cerrado.setSelected(false);
        vista_Cabe_Parte_CRUD.jCB_Verificado.setSelected(false);
        vista_Cabe_Parte_CRUD.jText_Bdia.setText(null);
        vista_Cabe_Parte_CRUD.jText_Bnombre.setText("");

        // Para que el cursor se ponga en este campo después de limpiar los datos
        vista_Cabe_Parte_CRUD.jText_1.requestFocus();
    }

    @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent e) {

        // CREAR: ALTA de PARTE nuevo
        if (e.getSource() == vista_Cabe_Parte_CRUD.jB_Crear) {            
            // CONVERTIR EL STRING EN DATE     
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String dateInString = vista_Cabe_Parte_CRUD.jText_1.getText();
            java.sql.Date Fecha = null;
            try {
                java.util.Date parsed = formatter.parse(dateInString);
                Fecha = new java.sql.Date(parsed.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(ControladorCRUD_Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }
            String matricula = vista_Cabe_Parte_CRUD.jList_Vehiculo.getSelectedValue();
            // BUSCAMOS LOS KMS QUE TIENE EL COCHE Y SE LO PONEMOS AL SIGUIENTE VALOR
            
            
            
            int km_ini = Integer.parseInt(vista_Cabe_Parte_CRUD.jText_3.getText());
            int km_final = Integer.parseInt(vista_Cabe_Parte_CRUD.jText_4.getText());
            Double autopista = Double.parseDouble(vista_Cabe_Parte_CRUD.jText_5.getText());
            Double gasoil = Double.parseDouble(vista_Cabe_Parte_CRUD.jText_6.getText());
            Double dietas = Double.parseDouble(vista_Cabe_Parte_CRUD.jText_7.getText());
            Double otros = Double.parseDouble(vista_Cabe_Parte_CRUD.jText_8.getText());
            String incidencias = vista_Cabe_Parte_CRUD.jText_Area_9.getText();
            Boolean cerrado = Boolean.parseBoolean(vista_Cabe_Parte_CRUD.jCB_Cerrado.getText());
            Boolean verificado = Boolean.parseBoolean(vista_Cabe_Parte_CRUD.jCB_Verificado.getText());

/*            
            if (rptaCabe_Parte != null) {
                JOptionPane.showMessageDialog(null, rptaCabe_Parte);
            } else {
                JOptionPane.showMessageDialog(null, "Registro incorrecto" + e);
            }
*/
            limpiar();
            vista_Cabe_Parte_CRUD.jB_Leer.doClick();
        }

        // LECTURA de los datos en la tabla
        if (e.getSource() == vista_Cabe_Parte_CRUD.jB_Leer) {
            LlenarTabla(vista_Cabe_Parte_CRUD.jTableDatos);
        }

        // MODIFICACIÓN de los datos introducidos
        if (e.getSource() == vista_Cabe_Parte_CRUD.jB_Actualizar) {
            int filaEditar = vista_Cabe_Parte_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_Cabe_Parte_CRUD.jTableDatos.getSelectedRowCount();

            if (filaEditar >= 0 && numFilas == 1) {

                // Subo los valores de la fila a los campos de edición
                vista_Cabe_Parte_CRUD.jText_1.setText(String.valueOf(vista_Cabe_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 0)));
                //vista_Cabe_Parte_CRUD.jText_2.setText(String.valueOf(vista_Cabe_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 1)));
                vista_Cabe_Parte_CRUD.jText_3.setText(String.valueOf(vista_Cabe_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 2)));
                vista_Cabe_Parte_CRUD.jText_4.setText(String.valueOf(vista_Cabe_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 3)));
                vista_Cabe_Parte_CRUD.jText_5.setText(String.valueOf(vista_Cabe_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 4)));
                vista_Cabe_Parte_CRUD.jText_6.setText(String.valueOf(vista_Cabe_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 5)));
                vista_Cabe_Parte_CRUD.jText_7.setText(String.valueOf(vista_Cabe_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 6)));
                vista_Cabe_Parte_CRUD.jText_8.setText(String.valueOf(vista_Cabe_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 7)));

                // Como el ID es clave lo deshabilito para que no pueda modificarse
                vista_Cabe_Parte_CRUD.jText_1.setEditable(false);

                // Deshabilito los botones para que no puedan usarse durante la edición
                vista_Cabe_Parte_CRUD.jB_Crear.setEnabled(false);
                vista_Cabe_Parte_CRUD.jB_Borrar.setEnabled(false);
                vista_Cabe_Parte_CRUD.jB_Leer.setEnabled(false);
                vista_Cabe_Parte_CRUD.jB_Salir.setEnabled(false);
                vista_Cabe_Parte_CRUD.jB_Volver.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar 1 sola fila - por lo menos una" + e);
            }
        }
        // BORRADO de alguno de los datos
        if (e.getSource() == vista_Cabe_Parte_CRUD.jB_Borrar) {
            int filaInicio = vista_Cabe_Parte_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_Cabe_Parte_CRUD.jTableDatos.getSelectedRowCount();
            @SuppressWarnings("unchecked")
            ArrayList<String> listaParte = new ArrayList();
            String fechaString = "";
            String num = "";
            int id = 0;
            if (filaInicio >= 0) {
                for (int i = 0; i < numFilas; i++) {
                    fechaString = String.valueOf(vista_Cabe_Parte_CRUD.jTableDatos.getValueAt(i + filaInicio, 3));
                    num = String.valueOf(vista_Cabe_Parte_CRUD.jTableDatos.getValueAt(filaInicio, 4));
                    id = Integer.parseInt(num);
                   // listaParte.add(fecha);
                }
                for (int i = 0; i < numFilas; i++) {
                    int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Quieres borrar el registro " + fechaString + " ?" + " del trabajador " + id);
                    // Esta pregunta tiene 3 posibles respuestas:
                    // SI=0  -- NO=1 -- CANCELAR =2
                    if (rptaUsuario == 0) {
//                        modelo_Cabe_Parte_CRUD.eliminarCabe_Parte(java.sql.Date fecha, id
                    
                
  //              );
                    }
                }

                LlenarTabla(vista_Cabe_Parte_CRUD.jTableDatos);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona por lo menos una fila a borrar.");

            }
        }
        // BOTON de Ok
        if (e.getSource() == vista_Cabe_Parte_CRUD.jB_Ok) {

            String fechaBuscada = vista_Cabe_Parte_CRUD.jText_Bdia.getText();
            String nombre = vista_Cabe_Parte_CRUD.jText_Bnombre.getText();

            // Cuando SI QUE hay texto en el campo BUSCAR
            if (!fechaBuscada.equals("")) {
                String fechaString = fechaBuscada;
                DefaultTableModel modeloLP = new DefaultTableModel();
                vista_Cabe_Parte_CRUD.jTableDatos.setModel(modeloLP);

                modeloLP.addColumn("H.Inicio");
                modeloLP.addColumn("H.Final");
                modeloLP.addColumn("Fecha");
                modeloLP.addColumn("Id_T");

                Object[] columna = new Object[4];
                // CREO UNA copia del ArrayList de la Base de datos
                // para ahorrar tiempo de búsqueda y conexión                
                List<Linea_Parte> ListaCopia = new ArrayList<>();
 //               ListaCopia = (List<Linea_Parte>) modelo_Linea_Parte_CRUD.listLinea_Parte().clone();

                int numRegistros = ListaCopia.size();

                for (int i = 0; i < numRegistros; i++) {

                    columna[0] = ListaCopia.get(i).getHora_inicio();
                    columna[1] = ListaCopia.get(i).getHora_final();
                    columna[2] = ListaCopia.get(i).getfecha();
                    columna[3] = ListaCopia.get(i).getId_trabajador();
                    modeloLP.addRow(columna);
                }
                JOptionPane.showMessageDialog(null, "Listado terminado");
                vista_Cabe_Parte_CRUD.jText_Bdia.setText("");
                vista_Cabe_Parte_CRUD.jText_Bnombre.setText("");

            } else { // NO HAY QUE BUSCAR NADA, SOLO ACTUALIZAR LOS VALORES
                // FALTA LA FECHA
                int km_ini = Integer.parseInt(vista_Cabe_Parte_CRUD.jText_1.getText());
                
                
                int ID = Integer.parseInt(vista_Cabe_Parte_CRUD.jText_1.getText());
 //               String Nombre = vista_Cabe_Parte_CRUD.jText_2.getText();
                String Calle = vista_Cabe_Parte_CRUD.jText_3.getText();
                int Num = Integer.parseInt(vista_Cabe_Parte_CRUD.jText_4.getText());
                String cp = vista_Cabe_Parte_CRUD.jText_5.getText();
                String Ciudad = vista_Cabe_Parte_CRUD.jText_6.getText();
                String Provincia = vista_Cabe_Parte_CRUD.jText_7.getText();
                String Telefono = vista_Cabe_Parte_CRUD.jText_8.getText();

   //             String rptaEdit = modelo_Cabe_Parte_CRUD.editarCabe_Parte(fecha, km_ini, km_final, gasoil, autopista, dietas, otros, incidencias, excesoH, cerrar, verificar, id, matricula);

/*                if (rptaEdit != null) {
                    JOptionPane.showMessageDialog(null, rptaEdit);
                } else {
                    JOptionPane.showMessageDialog(null, "Registro incorrecto" + e);
                }
*/
                // Limpio los datos del formulario
                limpiar();
                // Vuelvo a habilitar los botones deshabilitados
                vista_Cabe_Parte_CRUD.jB_Crear.setEnabled(true);
                vista_Cabe_Parte_CRUD.jB_Borrar.setEnabled(true);
                vista_Cabe_Parte_CRUD.jB_Leer.setEnabled(true);
                vista_Cabe_Parte_CRUD.jB_Salir.setEnabled(true);
                vista_Cabe_Parte_CRUD.jB_Volver.setEnabled(true);

                // Refresco el listado para que aparezca el cambio hecho
                vista_Cabe_Parte_CRUD.jB_Leer.doClick();
            }
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
