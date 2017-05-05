
package Modelo;

import java.sql.Date;

public class Cabe_Parte {

    private java.sql.Date fecha;
    private int km_in;
    private int km_fin;
    private Double gasoil;
    private Double autopista;
    private Double dietas;
    private Double otros;
    private String incidencias;
    private java.sql.Date exceso_horas;
    private boolean cerrar_parte;
    private boolean verificar_parte;
    private int id_trabajador;
    private String matricula;

    public Cabe_Parte (){
        fecha=null;
        km_in=0;
        km_fin=0;
        gasoil=0.0;
        autopista=0.0;
        dietas=0.0;
        otros=0.0;
        incidencias="";
        exceso_horas=null;
        cerrar_parte=false;
        verificar_parte=false;
        id_trabajador=0;
        matricula="";        
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

    public void setKm_in(int km_In) {
        this.km_in = km_in;
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

    public Date getExceso_horas() {
        return exceso_horas;
    }

    public void setExceso_horas(Date exceso_horas) {
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

    public int getKm_fin() {
        return km_fin;
    }

    public void setKm_fin(int km_fin) {
        this.km_fin = km_fin;
    }

    public Double getGasoil() {
        return gasoil;
    }

    public void setGasoil(Double gasoil) {
        this.gasoil = gasoil;
    }

    public Double getAutopista() {
        return autopista;
    }

    public void setAutopista(Double autopista) {
        this.autopista = autopista;
    }

    public Double getDietas() {
        return dietas;
    }

    public void setDietas(Double dietas) {
        this.dietas = dietas;
    }

    public Double getOtros() {
        return otros;
    }

    public void setOtros(Double otros) {
        this.otros = otros;
    }

    

    
}
