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
 * @author 7fbd12
 */
public class Controlador_Logistica_Crear_parte implements ActionListener, KeyListener {
    //crear la pantalla y el de modelo.
    Jf_Logistica vista_logistica_crud = new Jf_Logistica();
    Logistica_crear_parte modelo_Logistica_crear_parte = new Logistica_crear_parte();
    
    
    public Controlador_Logistica_Crear_parte(Jf_Logistica vista_logistica_crud, Logistica_crear_parte modelo_Logistica_crear_parte) {
        this.vista_logistica_crud = vista_logistica_crud;
        this.modelo_Logistica_crear_parte = modelo_Logistica_crear_parte;
        
        //leer los botonoes de la pantalla
        
        
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
