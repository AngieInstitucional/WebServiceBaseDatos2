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
public class PvDescLiquidacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "DES_PRODUCTO")
    private BigInteger desProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DES_DESCUENTO")
    private BigInteger desDescuento;

    public PvDescLiquidacionPK() {
    }

    public PvDescLiquidacionPK(BigInteger desProducto, BigInteger desDescuento) {
        this.desProducto = desProducto;
        this.desDescuento = desDescuento;
    }

    public BigInteger getDesProducto() {
        return desProducto;
    }

    public void setDesProducto(BigInteger desProducto) {
        this.desProducto = desProducto;
    }

    public BigInteger getDesDescuento() {
        return desDescuento;
    }

    public void setDesDescuento(BigInteger desDescuento) {
        this.desDescuento = desDescuento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (desProducto != null ? desProducto.hashCode() : 0);
        hash += (desDescuento != null ? desDescuento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvDescLiquidacionPK)) {
            return false;
        }
        PvDescLiquidacionPK other = (PvDescLiquidacionPK) object;
        if ((this.desProducto == null && other.desProducto != null) || (this.desProducto != null && !this.desProducto.equals(other.desProducto))) {
            return false;
        }
        if ((this.desDescuento == null && other.desDescuento != null) || (this.desDescuento != null && !this.desDescuento.equals(other.desDescuento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvDescLiquidacionPK[ desProducto=" + desProducto + ", desDescuento=" + desDescuento + " ]";
    }
    
}
