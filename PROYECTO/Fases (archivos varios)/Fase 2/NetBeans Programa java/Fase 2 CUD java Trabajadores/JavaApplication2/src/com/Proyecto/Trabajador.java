/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyecto;

import java.util.Date;

/**
 *
 * @author 7fbd12
 */
public class Trabajador {
    
    private int ID_trabajador;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String calle;
    private String portal;
    private String piso;
    private String mano;
    private String telef_personal;
    private String movil_empresa;
    private double salario;
    private Date fecha_nac;
    private String categoría;
    
    private Clave clave;

    public Trabajador() {
    }

    public Clave getClave() {
        return clave;
    }

    public void setClave(Clave clave) {
        this.clave = clave;
    }

    
    public int getID_trabajador() {
        return ID_trabajador;
    }

    public void setID_trabajador(int ID_trabajador) {
        this.ID_trabajador = ID_trabajador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getMano() {
        return mano;
    }

    public void setMano(String mano) {
        this.mano = mano;
    }

    public String getTelef_personal() {
        return telef_personal;
    }

    public void setTelef_personal(String telef_personal) {
        this.telef_personal = telef_personal;
    }

    public String getMovil_empresa() {
        return movil_empresa;
    }

    public void setMovil_empresa(String movil_empresa) {
        this.movil_empresa = movil_empresa;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCategoría() {
        return categoría;
    }

    public void setCategoría(String categoría) {
        this.categoría = categoría;
    }
    
    
    
}
