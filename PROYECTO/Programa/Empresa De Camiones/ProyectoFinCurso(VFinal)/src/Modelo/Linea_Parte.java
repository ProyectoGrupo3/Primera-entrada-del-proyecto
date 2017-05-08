package Modelo;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Linea_Parte {

    private String hora_inicio;
    private String hora_final;
    private java.sql.Date fecha;
    private int id_trabajador;

    private String nombre;
    private String apellido1;

    public Linea_Parte() {
        hora_inicio = null;
        hora_final = null;
        fecha = null;
        id_trabajador = 0;
        nombre = "";
        apellido1 = "";
    }

    public Linea_Parte(String hora_inicio, String hora_final, Date fecha, int id_trabajador) {
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
        this.fecha = fecha;
        this.id_trabajador = id_trabajador;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_final() {
        return hora_final;
    }

    public void setHora_final(String hora_final) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

<<<<<<< HEAD
=======
    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

>>>>>>> master
}
