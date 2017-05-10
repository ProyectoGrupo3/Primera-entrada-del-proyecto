
package Modelo;

import java.sql.*;

public class Vista_CP {


    private java.sql.Date fecha;
    private int km_in;
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
    private String nombre;
    private String apellido1;
    private int ct;

    public Vista_CP (){
        fecha=null;
        km_in=0;
        km_fin=0;
        gasoil=0;
        autopista=0;
        dietas=0;
        otros=0;
        incidencias="";
        exceso_horas=0;
        cerrar_parte=false;
        verificar_parte=false;
        id_trabajador=0;
        matricula="";  
        nombre = "";
        apellido1 = "";
        ct = 0;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getKm_in() {
        return km_in;
    }

    public void setKm_in(int km_in) {
        this.km_in = km_in;
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

    public String getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(String incidencias) {
        this.incidencias = incidencias;
    }

    public long getExceso_horas() {
        return exceso_horas;
    }

    public void setExceso_horas(long exceso_horas) {
        this.exceso_horas = exceso_horas;
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

    public int getCt() {
        return ct;
    }

    public void setCt(int ct) {
        this.ct = ct;
    }
    
    
    
}
