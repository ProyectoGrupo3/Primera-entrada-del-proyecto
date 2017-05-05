
package Modelo;

import java.sql.Date;

public class Aviso {

    private java.sql.Date fecha_aviso;
    private String texto;
    private int id_trabajador;
    private java.sql.Date fecha_parte;
    private int id_trabajador_parte;

    public Aviso (){
    
       fecha_aviso = null;
       texto = "";
       id_trabajador =0;
       fecha_parte = null;
       id_trabajador_parte =0;
    
    
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

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public Date getFecha_parte() {
        return fecha_parte;
    }

    public void setFecha_parte(Date fecha_parte) {
        this.fecha_parte = fecha_parte;
    }

    public int getId_trabajador_parte() {
        return id_trabajador_parte;
    }

    public void setId_trabajador_parte(int id_trabajador_parte) {
        this.id_trabajador_parte = id_trabajador_parte;
    }

    
}
