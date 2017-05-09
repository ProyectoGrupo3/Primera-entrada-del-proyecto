
package Modelo;

import java.sql.Date;

public class Aviso {

    private java.sql.Date fecha_aviso;
    private String texto;
    private int id_Admin;
    private java.sql.Date fecha_parte;
    private int id_Logis;

    public int getId_Admin() {
        return id_Admin;
    }

    public void setId_Admin(int id_Admin) {
        this.id_Admin = id_Admin;
    }

    public int getId_Logis() {
        return id_Logis;
    }

    public void setId_Logis(int id_Logis) {
        this.id_Logis = id_Logis;
    }
    private String nombre;
    private String apellido1;

    public Aviso (){
    
       fecha_aviso = null;
       texto = "";
       id_Admin = 0;
       fecha_parte = null;
       id_Logis = 0;
       nombre = "";
       apellido1 = "";
    
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

    public Date getFecha_aviso() {
        return fecha_aviso;
    }

    public void setFecha_aviso(Date fecha_aviso) {
        this.fecha_aviso = fecha_aviso;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

 

    public Date getFecha_parte() {
        return fecha_parte;
    }

    public void setFecha_parte(Date fecha_parte) {
        this.fecha_parte = fecha_parte;
    }


    
}
