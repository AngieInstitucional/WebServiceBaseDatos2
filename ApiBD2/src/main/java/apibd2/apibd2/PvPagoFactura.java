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
@Table(name = "PV_PAGO_FACTURA")
@NamedQueries({
    @NamedQuery(name = "PvPagoFactura.findAll", query = "SELECT p FROM PvPagoFactura p"),
    @NamedQuery(name = "PvPagoFactura.findByPagFactura", query = "SELECT p FROM PvPagoFactura p WHERE p.pvPagoFacturaPK.pagFactura = :pagFactura"),
    @NamedQuery(name = "PvPagoFactura.findByPagTipoPago", query = "SELECT p FROM PvPagoFactura p WHERE p.pvPagoFacturaPK.pagTipoPago = :pagTipoPago"),
    @NamedQuery(name = "PvPagoFactura.findByPagMontoCancelado", query = "SELECT p FROM PvPagoFactura p WHERE p.pagMontoCancelado = :pagMontoCancelado"),
    @NamedQuery(name = "PvPagoFactura.findByPagMontoCambio", query = "SELECT p FROM PvPagoFactura p WHERE p.pagMontoCambio = :pagMontoCambio")})
public class PvPagoFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PvPagoFacturaPK pvPagoFacturaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAG_MONTO_CANCELADO")
    private double pagMontoCancelado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PAG_MONTO_CAMBIO")
    private Double pagMontoCambio;
    @JoinColumn(name = "PAG_FACTURA", referencedColumnName = "FAC_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PvFacturasVenta pvFacturasVenta;
    @JoinColumn(name = "PAG_TIPO_PAGO", referencedColumnName = "TIP_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PvTiposPago pvTiposPago;

    public PvPagoFactura() {
    }

    public PvPagoFactura(PvPagoFacturaPK pvPagoFacturaPK) {
        this.pvPagoFacturaPK = pvPagoFacturaPK;
    }

    public PvPagoFactura(PvPagoFacturaPK pvPagoFacturaPK, double pagMontoCancelado) {
        this.pvPagoFacturaPK = pvPagoFacturaPK;
        this.pagMontoCancelado = pagMontoCancelado;
    }

    public PvPagoFactura(BigInteger pagFactura, BigInteger pagTipoPago) {
        this.pvPagoFacturaPK = new PvPagoFacturaPK(pagFactura, pagTipoPago);
    }

    public PvPagoFacturaPK getPvPagoFacturaPK() {
        return pvPagoFacturaPK;
    }

    public void setPvPagoFacturaPK(PvPagoFacturaPK pvPagoFacturaPK) {
        this.pvPagoFacturaPK = pvPagoFacturaPK;
    }

    public double getPagMontoCancelado() {
        return pagMontoCancelado;
    }

    public void setPagMontoCancelado(double pagMontoCancelado) {
        this.pagMontoCancelado = pagMontoCancelado;
    }

    public Double getPagMontoCambio() {
        return pagMontoCambio;
    }

    public void setPagMontoCambio(Double pagMontoCambio) {
        this.pagMontoCambio = pagMontoCambio;
    }

    public PvFacturasVenta getPvFacturasVenta() {
        return pvFacturasVenta;
    }

    public void setPvFacturasVenta(PvFacturasVenta pvFacturasVenta) {
        this.pvFacturasVenta = pvFacturasVenta;
    }

    public PvTiposPago getPvTiposPago() {
        return pvTiposPago;
    }

    public void setPvTiposPago(PvTiposPago pvTiposPago) {
        this.pvTiposPago = pvTiposPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pvPagoFacturaPK != null ? pvPagoFacturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvPagoFactura)) {
            return false;
        }
        PvPagoFactura other = (PvPagoFactura) object;
        if ((this.pvPagoFacturaPK == null && other.pvPagoFacturaPK != null) || (this.pvPagoFacturaPK != null && !this.pvPagoFacturaPK.equals(other.pvPagoFacturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvPagoFactura[ pvPagoFacturaPK=" + pvPagoFacturaPK + " ]";
    }
    
}
