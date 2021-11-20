/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apibd2.apibd2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cordo
 */
@Entity
@Table(name = "PV_PRECIOS")
@NamedQueries({
    @NamedQuery(name = "PvPrecios.findAll", query = "SELECT p FROM PvPrecios p"),
    @NamedQuery(name = "PvPrecios.findByPreId", query = "SELECT p FROM PvPrecios p WHERE p.preId = :preId"),
    @NamedQuery(name = "PvPrecios.findByPrePrecioCosto", query = "SELECT p FROM PvPrecios p WHERE p.prePrecioCosto = :prePrecioCosto"),
    @NamedQuery(name = "PvPrecios.findByPreImpuesto", query = "SELECT p FROM PvPrecios p WHERE p.preImpuesto = :preImpuesto"),
    @NamedQuery(name = "PvPrecios.findByPreUtilidad", query = "SELECT p FROM PvPrecios p WHERE p.preUtilidad = :preUtilidad"),
    @NamedQuery(name = "PvPrecios.findByPreFecha", query = "SELECT p FROM PvPrecios p WHERE p.preFecha = :preFecha"),
    @NamedQuery(name = "PvPrecios.findByPreEstado", query = "SELECT p FROM PvPrecios p WHERE p.preEstado = :preEstado")})
public class PvPrecios implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRE_ID")
    private BigDecimal preId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRE_PRECIO_COSTO")
    private double prePrecioCosto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRE_IMPUESTO")
    private double preImpuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRE_UTILIDAD")
    private double preUtilidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRE_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date preFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PRE_ESTADO")
    private String preEstado;
    @JoinColumn(name = "PRE_PRODUCTO", referencedColumnName = "PRO_ID")
    @ManyToOne(optional = false)
    private PvProductos preProducto;

    public PvPrecios() {
    }

    public PvPrecios(BigDecimal preId) {
        this.preId = preId;
    }

    public PvPrecios(BigDecimal preId, double prePrecioCosto, double preImpuesto, double preUtilidad, Date preFecha, String preEstado) {
        this.preId = preId;
        this.prePrecioCosto = prePrecioCosto;
        this.preImpuesto = preImpuesto;
        this.preUtilidad = preUtilidad;
        this.preFecha = preFecha;
        this.preEstado = preEstado;
    }

    public BigDecimal getPreId() {
        return preId;
    }

    public void setPreId(BigDecimal preId) {
        this.preId = preId;
    }

    public double getPrePrecioCosto() {
        return prePrecioCosto;
    }

    public void setPrePrecioCosto(double prePrecioCosto) {
        this.prePrecioCosto = prePrecioCosto;
    }

    public double getPreImpuesto() {
        return preImpuesto;
    }

    public void setPreImpuesto(double preImpuesto) {
        this.preImpuesto = preImpuesto;
    }

    public double getPreUtilidad() {
        return preUtilidad;
    }

    public void setPreUtilidad(double preUtilidad) {
        this.preUtilidad = preUtilidad;
    }

    public Date getPreFecha() {
        return preFecha;
    }

    public void setPreFecha(Date preFecha) {
        this.preFecha = preFecha;
    }

    public String getPreEstado() {
        return preEstado;
    }

    public void setPreEstado(String preEstado) {
        this.preEstado = preEstado;
    }

    public PvProductos getPreProducto() {
        return preProducto;
    }

    public void setPreProducto(PvProductos preProducto) {
        this.preProducto = preProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preId != null ? preId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvPrecios)) {
            return false;
        }
        PvPrecios other = (PvPrecios) object;
        if ((this.preId == null && other.preId != null) || (this.preId != null && !this.preId.equals(other.preId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvPrecios[ preId=" + preId + " ]";
    }
    
}
