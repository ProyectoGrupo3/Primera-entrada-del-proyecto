
package Modelo;

import java.util.Date;


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
    private java.sql.Date  fecha_nac;
    private String categoria;
    private int ct;

    public Trabajador() {
       
        ID_trabajador=0;
        dni="";
        nombre="";
        apellido1="";
        apellido2="";
        calle="";
        portal="";
        piso="";
        mano="";
        telef_personal="";
        movil_empresa="";
        salario=0.0;
        fecha_nac=null;
        categoria="";
        ct=-1;
        
    }

    public Trabajador(int ID_trabajador, String dni, String nombre, String apellido1, String apellido2, String calle, String portal, String piso, String mano, String telef_personal, String movil_empresa, double salario, java.sql.Date fecha_nac, String categoria, int ct) {
        this.ID_trabajador = ID_trabajador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.calle = calle;
        this.portal = portal;
        this.piso = piso;
        this.mano = mano;
        this.telef_personal = telef_personal;
        this.movil_empresa = movil_empresa;
        this.salario = salario;
        this.fecha_nac = fecha_nac;
        this.categoria = categoria;
        this.ct = ct;
    }
    

    public int getCt() {
        return ct;
    }

    public void setCt(int ct) {
        this.ct = ct;
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

    public java.sql.Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(java.sql.Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoría) {
        this.categoria = categoría;
    }
    
    
    
}
