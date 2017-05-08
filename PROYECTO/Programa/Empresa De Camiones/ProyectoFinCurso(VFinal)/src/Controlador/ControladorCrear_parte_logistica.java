/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Logistica_crear_parte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import proyectofincurso.Jf_Logistica;

/**
 *
 * @author ikitess
 */
public class ControladorCrear_parte_logistica implements ActionListener, KeyListener {

    Jf_Logistica vista_logistica_parte = new Jf_Logistica();
    Logistica_crear_parte modelo_Logistica_crear_parte = new Logistica_crear_parte();

    public ControladorCrear_parte_logistica(Jf_Logistica vista_logistica_parte, Logistica_crear_parte modelo_Logistica_crear_parte) {
        this.modelo_Logistica_crear_parte = modelo_Logistica_crear_parte;
        this.vista_logistica_parte = vista_logistica_parte;
        
        // "Escucha" los botones pulsados en la pantalla JF_Vehiculo_CRUD
        this.vista_logistica_parte.Jb_InsertarLinea.addActionListener(this);
        this.vista_logistica_parte.Jb_GuardarYcerrarSesion.addActionListener(this);
        this.vista_logistica_parte.cerrarParteCheck.addActionListener(this);
        //this.vista_logistica_parte.jB_Borrar.addActionListener(this);

        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
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
