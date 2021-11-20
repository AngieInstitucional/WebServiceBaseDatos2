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
public class PvPagoFacturaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "PAG_FACTURA")
    private BigInteger pagFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAG_TIPO_PAGO")
    private BigInteger pagTipoPago;

    public PvPagoFacturaPK() {
    }

    public PvPagoFacturaPK(BigInteger pagFactura, BigInteger pagTipoPago) {
        this.pagFactura = pagFactura;
        this.pagTipoPago = pagTipoPago;
    }

    public BigInteger getPagFactura() {
        return pagFactura;
    }

    public void setPagFactura(BigInteger pagFactura) {
        this.pagFactura = pagFactura;
    }

    public BigInteger getPagTipoPago() {
        return pagTipoPago;
    }

    public void setPagTipoPago(BigInteger pagTipoPago) {
        this.pagTipoPago = pagTipoPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagFactura != null ? pagFactura.hashCode() : 0);
        hash += (pagTipoPago != null ? pagTipoPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvPagoFacturaPK)) {
            return false;
        }
        PvPagoFacturaPK other = (PvPagoFacturaPK) object;
        if ((this.pagFactura == null && other.pagFactura != null) || (this.pagFactura != null && !this.pagFactura.equals(other.pagFactura))) {
            return false;
        }
        if ((this.pagTipoPago == null && other.pagTipoPago != null) || (this.pagTipoPago != null && !this.pagTipoPago.equals(other.pagTipoPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvPagoFacturaPK[ pagFactura=" + pagFactura + ", pagTipoPago=" + pagTipoPago + " ]";
    }
    
}
