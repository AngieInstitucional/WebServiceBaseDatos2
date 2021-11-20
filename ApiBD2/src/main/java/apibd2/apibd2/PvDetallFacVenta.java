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
@Table(name = "PV_DETALL_FAC_VENTA")
@NamedQueries({
    @NamedQuery(name = "PvDetallFacVenta.findAll", query = "SELECT p FROM PvDetallFacVenta p"),
    @NamedQuery(name = "PvDetallFacVenta.findByDetProducto", query = "SELECT p FROM PvDetallFacVenta p WHERE p.pvDetallFacVentaPK.detProducto = :detProducto"),
    @NamedQuery(name = "PvDetallFacVenta.findByDetFactura", query = "SELECT p FROM PvDetallFacVenta p WHERE p.pvDetallFacVentaPK.detFactura = :detFactura"),
    @NamedQuery(name = "PvDetallFacVenta.findByDetPrecio", query = "SELECT p FROM PvDetallFacVenta p WHERE p.pvDetallFacVentaPK.detPrecio = :detPrecio"),
    @NamedQuery(name = "PvDetallFacVenta.findByDetUnidades", query = "SELECT p FROM PvDetallFacVenta p WHERE p.detUnidades = :detUnidades"),
    @NamedQuery(name = "PvDetallFacVenta.findByDetSubtotal", query = "SELECT p FROM PvDetallFacVenta p WHERE p.detSubtotal = :detSubtotal"),
    @NamedQuery(name = "PvDetallFacVenta.findByDetDescuento", query = "SELECT p FROM PvDetallFacVenta p WHERE p.detDescuento = :detDescuento")})
public class PvDetallFacVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PvDetallFacVentaPK pvDetallFacVentaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DET_UNIDADES")
    private BigInteger detUnidades;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DET_SUBTOTAL")
    private double detSubtotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DET_DESCUENTO")
    private double detDescuento;
    @JoinColumn(name = "DET_FACTURA", referencedColumnName = "FAC_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PvFacturasVenta pvFacturasVenta;
    @JoinColumn(name = "DET_NOTA_CREDITO", referencedColumnName = "NOT_ID")
    @ManyToOne
    private PvNotasCred detNotaCredito;
    @JoinColumn(name = "DET_PRECIO", referencedColumnName = "PRE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PvPrecios pvPrecios;
    @JoinColumn(name = "DET_PRODUCTO", referencedColumnName = "PRO_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PvProductos pvProductos;
    @JoinColumn(name = "DET_PROMOCION", referencedColumnName = "PRO_ID")
    @ManyToOne
    private PvPromociones detPromocion;

    public PvDetallFacVenta() {
    }

    public PvDetallFacVenta(PvDetallFacVentaPK pvDetallFacVentaPK) {
        this.pvDetallFacVentaPK = pvDetallFacVentaPK;
    }

    public PvDetallFacVenta(PvDetallFacVentaPK pvDetallFacVentaPK, BigInteger detUnidades, double detSubtotal, double detDescuento) {
        this.pvDetallFacVentaPK = pvDetallFacVentaPK;
        this.detUnidades = detUnidades;
        this.detSubtotal = detSubtotal;
        this.detDescuento = detDescuento;
    }

    public PvDetallFacVenta(BigInteger detProducto, BigInteger detFactura, BigInteger detPrecio) {
        this.pvDetallFacVentaPK = new PvDetallFacVentaPK(detProducto, detFactura, detPrecio);
    }

    public PvDetallFacVentaPK getPvDetallFacVentaPK() {
        return pvDetallFacVentaPK;
    }

    public void setPvDetallFacVentaPK(PvDetallFacVentaPK pvDetallFacVentaPK) {
        this.pvDetallFacVentaPK = pvDetallFacVentaPK;
    }

    public BigInteger getDetUnidades() {
        return detUnidades;
    }

    public void setDetUnidades(BigInteger detUnidades) {
        this.detUnidades = detUnidades;
    }

    public double getDetSubtotal() {
        return detSubtotal;
    }

    public void setDetSubtotal(double detSubtotal) {
        this.detSubtotal = detSubtotal;
    }

    public double getDetDescuento() {
        return detDescuento;
    }

    public void setDetDescuento(double detDescuento) {
        this.detDescuento = detDescuento;
    }

    public PvFacturasVenta getPvFacturasVenta() {
        return pvFacturasVenta;
    }

    public void setPvFacturasVenta(PvFacturasVenta pvFacturasVenta) {
        this.pvFacturasVenta = pvFacturasVenta;
    }

    public PvNotasCred getDetNotaCredito() {
        return detNotaCredito;
    }

    public void setDetNotaCredito(PvNotasCred detNotaCredito) {
        this.detNotaCredito = detNotaCredito;
    }

    public PvPrecios getPvPrecios() {
        return pvPrecios;
    }

    public void setPvPrecios(PvPrecios pvPrecios) {
        this.pvPrecios = pvPrecios;
    }

    public PvProductos getPvProductos() {
        return pvProductos;
    }

    public void setPvProductos(PvProductos pvProductos) {
        this.pvProductos = pvProductos;
    }

    public PvPromociones getDetPromocion() {
        return detPromocion;
    }

    public void setDetPromocion(PvPromociones detPromocion) {
        this.detPromocion = detPromocion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pvDetallFacVentaPK != null ? pvDetallFacVentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvDetallFacVenta)) {
            return false;
        }
        PvDetallFacVenta other = (PvDetallFacVenta) object;
        if ((this.pvDetallFacVentaPK == null && other.pvDetallFacVentaPK != null) || (this.pvDetallFacVentaPK != null && !this.pvDetallFacVentaPK.equals(other.pvDetallFacVentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvDetallFacVenta[ pvDetallFacVentaPK=" + pvDetallFacVentaPK + " ]";
    }
    
}
