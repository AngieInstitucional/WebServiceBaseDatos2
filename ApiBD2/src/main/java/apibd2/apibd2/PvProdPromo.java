/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apibd2.apibd2;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author cordo
 */
@Entity
@Table(name = "PV_PROD_PROMO")
@NamedQueries({
    @NamedQuery(name = "PvProdPromo.findAll", query = "SELECT p FROM PvProdPromo p"),
    @NamedQuery(name = "PvProdPromo.findByProProducto", query = "SELECT p FROM PvProdPromo p WHERE p.pvProdPromoPK.proProducto = :proProducto"),
    @NamedQuery(name = "PvProdPromo.findByProPromocion", query = "SELECT p FROM PvProdPromo p WHERE p.pvProdPromoPK.proPromocion = :proPromocion"),
    @NamedQuery(name = "PvProdPromo.findByProProdAccion", query = "SELECT p FROM PvProdPromo p WHERE p.proProdAccion = :proProdAccion")})
public class PvProdPromo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PvProdPromoPK pvProdPromoPK;
    @Column(name = "PRO_PROD_ACCION")
    private BigInteger proProdAccion;
    @JoinColumn(name = "PRO_PRODUCTO", referencedColumnName = "PRO_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PvProductos pvProductos;
    @JoinColumn(name = "PRO_PROMOCION", referencedColumnName = "PRO_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PvPromociones pvPromociones;

    public PvProdPromo() {
    }

    public PvProdPromo(PvProdPromoPK pvProdPromoPK) {
        this.pvProdPromoPK = pvProdPromoPK;
    }

    public PvProdPromo(BigInteger proProducto, BigInteger proPromocion) {
        this.pvProdPromoPK = new PvProdPromoPK(proProducto, proPromocion);
    }

    public PvProdPromoPK getPvProdPromoPK() {
        return pvProdPromoPK;
    }

    public void setPvProdPromoPK(PvProdPromoPK pvProdPromoPK) {
        this.pvProdPromoPK = pvProdPromoPK;
    }

    public BigInteger getProProdAccion() {
        return proProdAccion;
    }

    public void setProProdAccion(BigInteger proProdAccion) {
        this.proProdAccion = proProdAccion;
    }

    public PvProductos getPvProductos() {
        return pvProductos;
    }

    public void setPvProductos(PvProductos pvProductos) {
        this.pvProductos = pvProductos;
    }

    public PvPromociones getPvPromociones() {
        return pvPromociones;
    }

    public void setPvPromociones(PvPromociones pvPromociones) {
        this.pvPromociones = pvPromociones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pvProdPromoPK != null ? pvProdPromoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvProdPromo)) {
            return false;
        }
        PvProdPromo other = (PvProdPromo) object;
        if ((this.pvProdPromoPK == null && other.pvProdPromoPK != null) || (this.pvProdPromoPK != null && !this.pvProdPromoPK.equals(other.pvProdPromoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvProdPromo[ pvProdPromoPK=" + pvProdPromoPK + " ]";
    }
    
}
