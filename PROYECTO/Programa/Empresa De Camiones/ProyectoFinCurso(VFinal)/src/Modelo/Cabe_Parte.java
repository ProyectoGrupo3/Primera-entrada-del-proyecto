package Modelo;

import java.sql.Date;

public class Cabe_Parte {

    private java.sql.Date fecha;
    private int km_inicio;
    private int km_fin;
    private int gasoil;
    private int autopista;
    private int dietas;
    private int otros;
    private String incidencias;
    private long exceso_horas;
    private boolean cerrar_parte;
    private boolean verificar_parte;
    private int id_trabajador;
    private String matricula;

    public Cabe_Parte() {
        fecha = null;
        km_inicio = 0;
        km_fin = 0;
        gasoil = 0;
        autopista = 0;
        dietas = 0;
        otros = 0;
        incidencias = "";
        exceso_horas = 0;
        cerrar_parte = false;
        verificar_parte = false;
        id_trabajador = 0;
        matricula = "";
    }

    public Cabe_Parte(Date fecha, int km_in, int km_fin, int gasoil, int autopista, int dietas, int otros, String incidencias, long exceso_horas, boolean cerrar_parte, boolean verificar_parte, int id_trabajador, String matricula) {
        this.fecha = fecha;
        this.km_inicio = km_in;
        this.km_fin = km_fin;
        this.gasoil = gasoil;
        this.autopista = autopista;
        this.dietas = dietas;
        this.otros = otros;
        this.incidencias = incidencias;
        this.exceso_horas = exceso_horas;
        this.cerrar_parte = cerrar_parte;
        this.verificar_parte = verificar_parte;
        this.id_trabajador = id_trabajador;
        this.matricula = matricula;
    }

    public long getExceso_horas() {
        return exceso_horas;
    }

    public void setExceso_horas(long exceso_horas) {
        this.exceso_horas = exceso_horas;
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

    public void setKm_inicio(int km_In) {
        this.km_inicio = km_inicio;
    }

    public int getKm_Fin() {
        return km_fin;
    }

    public void setKm_Fin(int km_Fin) {
        this.km_fin = km_fin;
    }

    public String getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(String incidencias) {
        this.incidencias = incidencias;
    }

    public boolean isCerrar_parte() {
        return cerrar_parte;
    }

    public void setCerrar_parte(boolean cerrar_parte) {
        this.cerrar_parte = cerrar_parte;
    }

    public boolean isVerificar_parte() {
        return verificar_parte;
    }

    public void setVerificar_parte(boolean verificar_parte) {
        this.verificar_parte = verificar_parte;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getKm_fin() {
        return km_fin;
    }

    public void setKm_fin(int km_fin) {
        this.km_fin = km_fin;
    }

    public int getGasoil() {
        return gasoil;
    }

    public void setGasoil(int gasoil) {
        this.gasoil = gasoil;
    }

    public int getAutopista() {
        return autopista;
    }

    public void setAutopista(int autopista) {
        this.autopista = autopista;
    }

    public int getDietas() {
        return dietas;
    }

    public void setDietas(int dietas) {
        this.dietas = dietas;
    }

    public int getOtros() {
        return otros;
    }

    public void setOtros(int otros) {
        this.otros = otros;
    }

}
