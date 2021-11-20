/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apibd2.apibd2;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cordo
 */
@Entity
@Table(name = "PV_DESC_LIQUIDACION")
@NamedQueries({
    @NamedQuery(name = "PvDescLiquidacion.findAll", query = "SELECT p FROM PvDescLiquidacion p"),
    @NamedQuery(name = "PvDescLiquidacion.findByDesProducto", query = "SELECT p FROM PvDescLiquidacion p WHERE p.pvDescLiquidacionPK.desProducto = :desProducto"),
    @NamedQuery(name = "PvDescLiquidacion.findByDesDescuento", query = "SELECT p FROM PvDescLiquidacion p WHERE p.pvDescLiquidacionPK.desDescuento = :desDescuento"),
    @NamedQuery(name = "PvDescLiquidacion.findByDesEstado", query = "SELECT p FROM PvDescLiquidacion p WHERE p.desEstado = :desEstado")})
public class PvDescLiquidacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PvDescLiquidacionPK pvDescLiquidacionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DES_ESTADO")
    private Character desEstado;
    @JoinColumn(name = "DES_DESCUENTO", referencedColumnName = "DEC_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PvDescuentos pvDescuentos;
    @JoinColumn(name = "DES_PRODUCTO", referencedColumnName = "PRO_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PvProductos pvProductos;

    public PvDescLiquidacion() {
    }

    public PvDescLiquidacion(PvDescLiquidacionPK pvDescLiquidacionPK) {
        this.pvDescLiquidacionPK = pvDescLiquidacionPK;
    }

    public PvDescLiquidacion(PvDescLiquidacionPK pvDescLiquidacionPK, Character desEstado) {
        this.pvDescLiquidacionPK = pvDescLiquidacionPK;
        this.desEstado = desEstado;
    }

    public PvDescLiquidacion(BigInteger desProducto, BigInteger desDescuento) {
        this.pvDescLiquidacionPK = new PvDescLiquidacionPK(desProducto, desDescuento);
    }

    public PvDescLiquidacionPK getPvDescLiquidacionPK() {
        return pvDescLiquidacionPK;
    }

    public void setPvDescLiquidacionPK(PvDescLiquidacionPK pvDescLiquidacionPK) {
        this.pvDescLiquidacionPK = pvDescLiquidacionPK;
    }

    public Character getDesEstado() {
        return desEstado;
    }

    public void setDesEstado(Character desEstado) {
        this.desEstado = desEstado;
    }

    public PvDescuentos getPvDescuentos() {
        return pvDescuentos;
    }

    public void setPvDescuentos(PvDescuentos pvDescuentos) {
        this.pvDescuentos = pvDescuentos;
    }

    public PvProductos getPvProductos() {
        return pvProductos;
    }

    public void setPvProductos(PvProductos pvProductos) {
        this.pvProductos = pvProductos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pvDescLiquidacionPK != null ? pvDescLiquidacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvDescLiquidacion)) {
            return false;
        }
        PvDescLiquidacion other = (PvDescLiquidacion) object;
        if ((this.pvDescLiquidacionPK == null && other.pvDescLiquidacionPK != null) || (this.pvDescLiquidacionPK != null && !this.pvDescLiquidacionPK.equals(other.pvDescLiquidacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvDescLiquidacion[ pvDescLiquidacionPK=" + pvDescLiquidacionPK + " ]";
    }
    
}
