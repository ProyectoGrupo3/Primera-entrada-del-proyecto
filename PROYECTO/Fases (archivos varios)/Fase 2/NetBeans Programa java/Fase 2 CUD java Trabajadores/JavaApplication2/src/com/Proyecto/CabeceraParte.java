/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyecto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ikitess
 */
public class CabeceraParte {
   // java.util.Date fechaActual = new java.util.Date(); //Fecha actual del sistema


    private Date fecha;
    private int km_inicio;
    private int km_final;
    private int gasto_gasoil;
    private int gasto_autopista;
    private int gastos_dietas;
    private int otros_gastos;
    private String incidencias_posibles;
    private Date exceso_horas;
    private boolean cerrar_logis = false;
    private boolean verificacion_admin = false;

    //Relaciones
    private List<LineaParte> lineasParte = new ArrayList<>();
    private Trabajador trabajador;
    private Vehiculo matricula;

    public CabeceraParte() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getKm_inicio() {
        return km_inicio;
    }

    public void setKm_inicio(int km_inicio) {
        this.km_inicio = km_inicio;
    }

    public int getKm_final() {
        return km_final;
    }

    public void setKm_final(int km_final) {
        this.km_final = km_final;
    }

    public int getGasto_gasoil() {
        return gasto_gasoil;
    }

    public void setGasto_gasoil(int gasto_gasoil) {
        this.gasto_gasoil = gasto_gasoil;
    }

    public int getGasto_autopista() {
        return gasto_autopista;
    }

    public void setGasto_autopista(int gasto_autopista) {
        this.gasto_autopista = gasto_autopista;
    }

    public int getGastos_dietas() {
        return gastos_dietas;
    }

    public void setGastos_dietas(int gastos_dietas) {
        this.gastos_dietas = gastos_dietas;
    }

    public int getOtros_gastos() {
        return otros_gastos;
    }

    public void setOtros_gastos(int otros_gastos) {
        this.otros_gastos = otros_gastos;
    }

    public String getIncidencias_posibles() {
        return incidencias_posibles;
    }

    public void setIncidencias_posibles(String incidencias_posibles) {
        this.incidencias_posibles = incidencias_posibles;
    }

    public Date getExceso_horas() {
        return exceso_horas;
    }

    public void setExceso_horas(Date exceso_horas) {
        this.exceso_horas = exceso_horas;
    }

    public boolean isCerrar_logis() {
        return cerrar_logis;
    }

    public void setCerrar_logis(boolean cerrar_logis) {
        this.cerrar_logis = cerrar_logis;
    }

    public boolean isVerificacion_admin() {
        return verificacion_admin;
    }

    public void setVerificacion_admin(boolean verificacion_admin) {
        this.verificacion_admin = verificacion_admin;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Vehiculo getMatricula() {
        return matricula;
    }

    public void setMatricula(Vehiculo matricula) {
        this.matricula = matricula;
    }

}
