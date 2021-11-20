/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apibd2.apibd2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "PV_MOVIMIENTOS")
@NamedQueries({
    @NamedQuery(name = "PvMovimientos.findAll", query = "SELECT p FROM PvMovimientos p"),
    @NamedQuery(name = "PvMovimientos.findByMovId", query = "SELECT p FROM PvMovimientos p WHERE p.movId = :movId"),
    @NamedQuery(name = "PvMovimientos.findByMovTipo", query = "SELECT p FROM PvMovimientos p WHERE p.movTipo = :movTipo"),
    @NamedQuery(name = "PvMovimientos.findByMovFecha", query = "SELECT p FROM PvMovimientos p WHERE p.movFecha = :movFecha"),
    @NamedQuery(name = "PvMovimientos.findByMovDescripcion", query = "SELECT p FROM PvMovimientos p WHERE p.movDescripcion = :movDescripcion"),
    @NamedQuery(name = "PvMovimientos.findByMovCantidad", query = "SELECT p FROM PvMovimientos p WHERE p.movCantidad = :movCantidad")})
public class PvMovimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOV_ID")
    private BigDecimal movId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOV_TIPO")
    private Character movTipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOV_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "MOV_DESCRIPCION")
    private String movDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOV_CANTIDAD")
    private BigInteger movCantidad;
    @JoinColumn(name = "MOV_PRODUCTO", referencedColumnName = "PRO_ID")
    @ManyToOne(optional = false)
    private PvProductos movProducto;

    public PvMovimientos() {
    }

    public PvMovimientos(BigDecimal movId) {
        this.movId = movId;
    }

    public PvMovimientos(BigDecimal movId, Character movTipo, Date movFecha, String movDescripcion, BigInteger movCantidad) {
        this.movId = movId;
        this.movTipo = movTipo;
        this.movFecha = movFecha;
        this.movDescripcion = movDescripcion;
        this.movCantidad = movCantidad;
    }

    public BigDecimal getMovId() {
        return movId;
    }

    public void setMovId(BigDecimal movId) {
        this.movId = movId;
    }

    public Character getMovTipo() {
        return movTipo;
    }

    public void setMovTipo(Character movTipo) {
        this.movTipo = movTipo;
    }

    public Date getMovFecha() {
        return movFecha;
    }

    public void setMovFecha(Date movFecha) {
        this.movFecha = movFecha;
    }

    public String getMovDescripcion() {
        return movDescripcion;
    }

    public void setMovDescripcion(String movDescripcion) {
        this.movDescripcion = movDescripcion;
    }

    public BigInteger getMovCantidad() {
        return movCantidad;
    }

    public void setMovCantidad(BigInteger movCantidad) {
        this.movCantidad = movCantidad;
    }

    public PvProductos getMovProducto() {
        return movProducto;
    }

    public void setMovProducto(PvProductos movProducto) {
        this.movProducto = movProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movId != null ? movId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvMovimientos)) {
            return false;
        }
        PvMovimientos other = (PvMovimientos) object;
        if ((this.movId == null && other.movId != null) || (this.movId != null && !this.movId.equals(other.movId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvMovimientos[ movId=" + movId + " ]";
    }
    
}
