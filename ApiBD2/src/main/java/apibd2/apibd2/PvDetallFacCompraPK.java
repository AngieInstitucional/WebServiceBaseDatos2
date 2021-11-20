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
public class PvDetallFacCompraPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "DET_PRODUCTO")
    private BigInteger detProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DET_FACTURA")
    private BigInteger detFactura;

    public PvDetallFacCompraPK() {
    }

    public PvDetallFacCompraPK(BigInteger detProducto, BigInteger detFactura) {
        this.detProducto = detProducto;
        this.detFactura = detFactura;
    }

    public BigInteger getDetProducto() {
        return detProducto;
    }

    public void setDetProducto(BigInteger detProducto) {
        this.detProducto = detProducto;
    }

    public BigInteger getDetFactura() {
        return detFactura;
    }

    public void setDetFactura(BigInteger detFactura) {
        this.detFactura = detFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detProducto != null ? detProducto.hashCode() : 0);
        hash += (detFactura != null ? detFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvDetallFacCompraPK)) {
            return false;
        }
        PvDetallFacCompraPK other = (PvDetallFacCompraPK) object;
        if ((this.detProducto == null && other.detProducto != null) || (this.detProducto != null && !this.detProducto.equals(other.detProducto))) {
            return false;
        }
        if ((this.detFactura == null && other.detFactura != null) || (this.detFactura != null && !this.detFactura.equals(other.detFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvDetallFacCompraPK[ detProducto=" + detProducto + ", detFactura=" + detFactura + " ]";
    }
    
}
