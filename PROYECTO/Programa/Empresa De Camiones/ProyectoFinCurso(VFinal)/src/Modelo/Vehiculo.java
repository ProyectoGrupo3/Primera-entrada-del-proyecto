
package Modelo;

import java.sql.Date;

public class Vehiculo {
    
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private int kms;
    
    public Vehiculo (){
        
        matricula="";
        marca="";
        modelo="";
        color="";
        kms=0;
       
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

}
