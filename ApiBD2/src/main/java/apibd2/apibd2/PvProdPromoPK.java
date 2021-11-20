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
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cordo
 */
@Embeddable
public class PvProdPromoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_PRODUCTO")
    private BigInteger proProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_PROMOCION")
    private BigInteger proPromocion;

    public PvProdPromoPK() {
    }

    public PvProdPromoPK(BigInteger proProducto, BigInteger proPromocion) {
        this.proProducto = proProducto;
        this.proPromocion = proPromocion;
    }

    public BigInteger getProProducto() {
        return proProducto;
    }

    public void setProProducto(BigInteger proProducto) {
        this.proProducto = proProducto;
    }

    public BigInteger getProPromocion() {
        return proPromocion;
    }

    public void setProPromocion(BigInteger proPromocion) {
        this.proPromocion = proPromocion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proProducto != null ? proProducto.hashCode() : 0);
        hash += (proPromocion != null ? proPromocion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvProdPromoPK)) {
            return false;
        }
        PvProdPromoPK other = (PvProdPromoPK) object;
        if ((this.proProducto == null && other.proProducto != null) || (this.proProducto != null && !this.proProducto.equals(other.proProducto))) {
            return false;
        }
        if ((this.proPromocion == null && other.proPromocion != null) || (this.proPromocion != null && !this.proPromocion.equals(other.proPromocion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvProdPromoPK[ proProducto=" + proProducto + ", proPromocion=" + proPromocion + " ]";
    }
    
}
