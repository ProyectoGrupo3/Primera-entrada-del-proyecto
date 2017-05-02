
package Modelo;


public class CT {
    
    private int ID;
    private String nombre;
    private String calle;
    private int numero;
    private String cp;
    private String ciudad;
    private String provincia;
    private String telefono;
    
    public CT (){
        ID=0;
        nombre="";
        calle="";
        numero=0;
        cp="";
        ciudad="";
        provincia="";
        telefono="";
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public String getCp() {
        return cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
