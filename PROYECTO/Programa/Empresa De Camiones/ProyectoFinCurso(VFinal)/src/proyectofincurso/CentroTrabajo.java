/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofincurso;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Alf
 */
@Entity
@Table(name = "CENTRO_TRABAJO", catalog = "", schema = "SYSTEM")
@NamedQueries({
    @NamedQuery(name = "CentroTrabajo.findAll", query = "SELECT c FROM CentroTrabajo c")
    , @NamedQuery(name = "CentroTrabajo.findByIdCentro", query = "SELECT c FROM CentroTrabajo c WHERE c.idCentro = :idCentro")
    , @NamedQuery(name = "CentroTrabajo.findByNombre", query = "SELECT c FROM CentroTrabajo c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CentroTrabajo.findByCalle", query = "SELECT c FROM CentroTrabajo c WHERE c.calle = :calle")
    , @NamedQuery(name = "CentroTrabajo.findByN\u00famero", query = "SELECT c FROM CentroTrabajo c WHERE c.n\u00famero = :n\u00famero")
    , @NamedQuery(name = "CentroTrabajo.findByC\u00f3digoPostal", query = "SELECT c FROM CentroTrabajo c WHERE c.c\u00f3digoPostal = :c\u00f3digoPostal")
    , @NamedQuery(name = "CentroTrabajo.findByCiudad", query = "SELECT c FROM CentroTrabajo c WHERE c.ciudad = :ciudad")
    , @NamedQuery(name = "CentroTrabajo.findByProvincia", query = "SELECT c FROM CentroTrabajo c WHERE c.provincia = :provincia")
    , @NamedQuery(name = "CentroTrabajo.findByTel\u00e9fono", query = "SELECT c FROM CentroTrabajo c WHERE c.tel\u00e9fono = :tel\u00e9fono")})
public class CentroTrabajo implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CENTRO")
    private BigDecimal idCentro;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "CALLE")
    private String calle;
    @Basic(optional = false)
    @Column(name = "N\u00daMERO")
    private BigInteger número;
    @Basic(optional = false)
    @Column(name = "C\u00d3DIGO_POSTAL")
    private String códigoPostal;
    @Basic(optional = false)
    @Column(name = "CIUDAD")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "PROVINCIA")
    private String provincia;
    @Basic(optional = false)
    @Column(name = "TEL\u00c9FONO")
    private String teléfono;

    public CentroTrabajo() {
    }

    public CentroTrabajo(BigDecimal idCentro) {
        this.idCentro = idCentro;
    }

    public CentroTrabajo(BigDecimal idCentro, String nombre, String calle, BigInteger número, String códigoPostal, String ciudad, String provincia, String teléfono) {
        this.idCentro = idCentro;
        this.nombre = nombre;
        this.calle = calle;
        this.número = número;
        this.códigoPostal = códigoPostal;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.teléfono = teléfono;
    }

    public BigDecimal getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(BigDecimal idCentro) {
        BigDecimal oldIdCentro = this.idCentro;
        this.idCentro = idCentro;
        changeSupport.firePropertyChange("idCentro", oldIdCentro, idCentro);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        String oldCalle = this.calle;
        this.calle = calle;
        changeSupport.firePropertyChange("calle", oldCalle, calle);
    }

    public BigInteger getNúmero() {
        return número;
    }

    public void setNúmero(BigInteger número) {
        BigInteger oldNúmero = this.número;
        this.número = número;
        changeSupport.firePropertyChange("n\u00famero", oldNúmero, número);
    }

    public String getCódigoPostal() {
        return códigoPostal;
    }

    public void setCódigoPostal(String códigoPostal) {
        String oldCódigoPostal = this.códigoPostal;
        this.códigoPostal = códigoPostal;
        changeSupport.firePropertyChange("c\u00f3digoPostal", oldCódigoPostal, códigoPostal);
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        String oldCiudad = this.ciudad;
        this.ciudad = ciudad;
        changeSupport.firePropertyChange("ciudad", oldCiudad, ciudad);
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        String oldProvincia = this.provincia;
        this.provincia = provincia;
        changeSupport.firePropertyChange("provincia", oldProvincia, provincia);
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        String oldTeléfono = this.teléfono;
        this.teléfono = teléfono;
        changeSupport.firePropertyChange("tel\u00e9fono", oldTeléfono, teléfono);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCentro != null ? idCentro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroTrabajo)) {
            return false;
        }
        CentroTrabajo other = (CentroTrabajo) object;
        if ((this.idCentro == null && other.idCentro != null) || (this.idCentro != null && !this.idCentro.equals(other.idCentro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectofincurso.CentroTrabajo[ idCentro=" + idCentro + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
