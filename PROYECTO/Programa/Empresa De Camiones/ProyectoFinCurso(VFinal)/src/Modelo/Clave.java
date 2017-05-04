/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;


/**
 *
 * @author ikitess
 */
public class Clave {

    private int id_clave;
    private String usuario;
    private String contrasenya;
    private java.sql.Date fecha;
    private int id_trabajador;

    
    public long comprobarFecha(java.sql.Date fecha) {
        java.util.Date hoy = new java.util.Date();//dia actual en java.util no java.sql
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());

        long diferencia = Math.round((hoy.getTime() - sqlDate.getTime()) / 100000000);
        return diferencia;
    }
    

    public int getId_clave() {
        return id_clave;
    }

    public void setId_clave(int id_clave) {
        this.id_clave = id_clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public Clave(int id_clave, String usuario, String contrasenya, Date fecha, int id_trabajador) {
        this.id_clave = id_clave;
        this.usuario = usuario;
        this.contrasenya = contrasenya;
        this.fecha = fecha;
        this.id_trabajador = id_trabajador;
    }

}
