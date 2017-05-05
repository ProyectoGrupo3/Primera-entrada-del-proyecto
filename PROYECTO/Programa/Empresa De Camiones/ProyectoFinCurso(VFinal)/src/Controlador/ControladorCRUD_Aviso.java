
package Controlador;

import Modelo.*;
import proyectofincurso.JF_Aviso_CRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorCRUD_Aviso implements ActionListener, KeyListener{
     JF_Aviso_CRUD vista_Aviso_CRUD = new JF_Aviso_CRUD();
    Aviso_CRUD modelo_Aviso_CRUD = new Aviso_CRUD();   

        public ControladorCRUD_Aviso(JF_Aviso_CRUD vista_Aviso_CRUD, Aviso_CRUD modelo_Aviso_CRUD) {
        this.modelo_Aviso_CRUD = modelo_Aviso_CRUD;
        this.vista_Aviso_CRUD = vista_Aviso_CRUD;
        // "Escucha" los botones pulsados en la pantalla JF_Aviso_CRUD
        this.vista_Aviso_CRUD.jB_Crear.addActionListener(this);
        this.vista_Aviso_CRUD.jB_Leer.addActionListener(this);
        this.vista_Aviso_CRUD.jB_Actualizar.addActionListener(this);
        this.vista_Aviso_CRUD.jB_Borrar.addActionListener(this);
        this.vista_Aviso_CRUD.jB_OK.addActionListener(this);
        this.vista_Aviso_CRUD.jText_1.addKeyListener(this);
        this.vista_Aviso_CRUD.jText_2.addKeyListener(this);
        this.vista_Aviso_CRUD.jText_3.addKeyListener(this);
    }

    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
