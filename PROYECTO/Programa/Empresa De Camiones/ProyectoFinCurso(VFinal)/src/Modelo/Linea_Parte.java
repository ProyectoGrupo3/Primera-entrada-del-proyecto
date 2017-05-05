
package Modelo;

import java.sql.Date;

public class Linea_Parte {
    
    private java.sql.Date hora_inicio;
    private java.sql.Date hora_final;
    private java.sql.Date fecha;
    private int id_trabajador;
    private String nombre;
    private String apellido1;
    
    public Linea_Parte(){
        hora_inicio = null;
        hora_final = null;
        fecha = null;
        id_trabajador = 0;
        nombre = "";
        apellido1 = "";
    }

    public Date getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Date hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Date getHora_final() {
        return hora_final;
    }

    public void setHora_final(Date hora_final) {
        this.hora_final = hora_final;
    }

    public Date getfecha() {
        return fecha;
    }

    public void setfecha(Date cp_fecha) {
        this.fecha = cp_fecha;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
    
    
}
