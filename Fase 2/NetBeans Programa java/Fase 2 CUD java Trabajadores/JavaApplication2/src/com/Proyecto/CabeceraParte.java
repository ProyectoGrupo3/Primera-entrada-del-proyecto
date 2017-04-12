/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyecto;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author ikitess
 */
public class CabeceraParte {

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the km_inicio
     */
    public int getKm_inicio() {
        return km_inicio;
    }

    /**
     * @param km_inicio the km_inicio to set
     */
    public void setKm_inicio(int km_inicio) {
        this.km_inicio = km_inicio;
    }

    /**
     * @return the km_final
     */
    public int getKm_final() {
        return km_final;
    }

    /**
     * @param km_final the km_final to set
     */
    public void setKm_final(int km_final) {
        this.km_final = km_final;
    }

    /**
     * @return the gasto_gasoil
     */
    public int getGasto_gasoil() {
        return gasto_gasoil;
    }

    /**
     * @param gasto_gasoil the gasto_gasoil to set
     */
    public void setGasto_gasoil(int gasto_gasoil) {
        this.gasto_gasoil = gasto_gasoil;
    }

    /**
     * @return the gasto_autopista
     */
    public int getGasto_autopista() {
        return gasto_autopista;
    }

    /**
     * @param gasto_autopista the gasto_autopista to set
     */
    public void setGasto_autopista(int gasto_autopista) {
        this.gasto_autopista = gasto_autopista;
    }

    /**
     * @return the gastos_dietas
     */
    public int getGastos_dietas() {
        return gastos_dietas;
    }

    /**
     * @param gastos_dietas the gastos_dietas to set
     */
    public void setGastos_dietas(int gastos_dietas) {
        this.gastos_dietas = gastos_dietas;
    }

    /**
     * @return the otros_gastos
     */
    public int getOtros_gastos() {
        return otros_gastos;
    }

    /**
     * @param otros_gastos the otros_gastos to set
     */
    public void setOtros_gastos(int otros_gastos) {
        this.otros_gastos = otros_gastos;
    }

    /**
     * @return the incidencias_posibles
     */
    public String getIncidencias_posibles() {
        return incidencias_posibles;
    }

    /**
     * @param incidencias_posibles the incidencias_posibles to set
     */
    public void setIncidencias_posibles(String incidencias_posibles) {
        this.incidencias_posibles = incidencias_posibles;
    }

    /**
     * @return the exceso_horas
     */
    public Date getExceso_horas() {
        return exceso_horas;
    }

    /**
     * @param exceso_horas the exceso_horas to set
     */
    public void setExceso_horas(Date exceso_horas) {
        this.exceso_horas = exceso_horas;
    }

    /**
     * @return the cerrar_logis
     */
    public boolean isCerrar_logis() {
        return cerrar_logis;
    }

    /**
     * @param cerrar_logis the cerrar_logis to set
     */
    public void setCerrar_logis(boolean cerrar_logis) {
        this.cerrar_logis = cerrar_logis;
    }

    /**
     * @return the verificacion_admin
     */
    public boolean isVerificacion_admin() {
        return verificacion_admin;
    }

    /**
     * @param verificacion_admin the verificacion_admin to set
     */
    public void setVerificacion_admin(boolean verificacion_admin) {
        this.verificacion_admin = verificacion_admin;
    }

    /**
     * @return the trabajador
     */
    public Trabajador getTrabajador() {
        return trabajador;
    }

    /**
     * @param trabajador the trabajador to set
     */
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    /**
     * @return the matricula
     */
    public Vehiculo getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(Vehiculo matricula) {
        this.matricula = matricula;
    }
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
    
    private Trabajador trabajador;
    private Vehiculo matricula;

    public CabeceraParte(Date fecha, int km_inicio, int km_final, int gasto_gasoil, int gasto_autopista, int gastos_dietas, int otros_gastos, String incidencias_posibles, Date exceso_horas) {
        this.fecha = fecha;
        this.km_inicio = km_inicio;
        this.km_final = km_final;
        this.gasto_gasoil = gasto_gasoil;
        this.gasto_autopista = gasto_autopista;
        this.gastos_dietas = gastos_dietas;
        this.otros_gastos = otros_gastos;
        this.incidencias_posibles = incidencias_posibles;
        this.exceso_horas = exceso_horas;
    }

    public void isCerrar (){
    cerrar_logis = true;
    }

    
    
}
