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
@Table(name = "PV_DETALL_FAC_COMPRA")
@NamedQueries({
    @NamedQuery(name = "PvDetallFacCompra.findAll", query = "SELECT p FROM PvDetallFacCompra p"),
    @NamedQuery(name = "PvDetallFacCompra.findByDetProducto", query = "SELECT p FROM PvDetallFacCompra p WHERE p.pvDetallFacCompraPK.detProducto = :detProducto"),
    @NamedQuery(name = "PvDetallFacCompra.findByDetFactura", query = "SELECT p FROM PvDetallFacCompra p WHERE p.pvDetallFacCompraPK.detFactura = :detFactura"),
    @NamedQuery(name = "PvDetallFacCompra.findByDetCantidad", query = "SELECT p FROM PvDetallFacCompra p WHERE p.detCantidad = :detCantidad"),
    @NamedQuery(name = "PvDetallFacCompra.findByDetPrecioUnidad", query = "SELECT p FROM PvDetallFacCompra p WHERE p.detPrecioUnidad = :detPrecioUnidad")})
public class PvDetallFacCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PvDetallFacCompraPK pvDetallFacCompraPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DET_CANTIDAD")
    private double detCantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DET_PRECIO_UNIDAD")
    private double detPrecioUnidad;
    @JoinColumn(name = "DET_FACTURA", referencedColumnName = "FAC_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PvFacturasCompra pvFacturasCompra;
    @JoinColumn(name = "DET_NOTAS_CREDITO", referencedColumnName = "NOT_ID")
    @ManyToOne
    private PvNotasCred detNotasCredito;
    @JoinColumn(name = "DET_PRODUCTO", referencedColumnName = "PRO_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PvProductos pvProductos;

    public PvDetallFacCompra() {
    }

    public PvDetallFacCompra(PvDetallFacCompraPK pvDetallFacCompraPK) {
        this.pvDetallFacCompraPK = pvDetallFacCompraPK;
    }

    public PvDetallFacCompra(PvDetallFacCompraPK pvDetallFacCompraPK, double detCantidad, double detPrecioUnidad) {
        this.pvDetallFacCompraPK = pvDetallFacCompraPK;
        this.detCantidad = detCantidad;
        this.detPrecioUnidad = detPrecioUnidad;
    }

    public PvDetallFacCompra(BigInteger detProducto, BigInteger detFactura) {
        this.pvDetallFacCompraPK = new PvDetallFacCompraPK(detProducto, detFactura);
    }

    public PvDetallFacCompraPK getPvDetallFacCompraPK() {
        return pvDetallFacCompraPK;
    }

    public void setPvDetallFacCompraPK(PvDetallFacCompraPK pvDetallFacCompraPK) {
        this.pvDetallFacCompraPK = pvDetallFacCompraPK;
    }

    public double getDetCantidad() {
        return detCantidad;
    }

    public void setDetCantidad(double detCantidad) {
        this.detCantidad = detCantidad;
    }

    public double getDetPrecioUnidad() {
        return detPrecioUnidad;
    }

    public void setDetPrecioUnidad(double detPrecioUnidad) {
        this.detPrecioUnidad = detPrecioUnidad;
    }

    public PvFacturasCompra getPvFacturasCompra() {
        return pvFacturasCompra;
    }

    public void setPvFacturasCompra(PvFacturasCompra pvFacturasCompra) {
        this.pvFacturasCompra = pvFacturasCompra;
    }

    public PvNotasCred getDetNotasCredito() {
        return detNotasCredito;
    }

    public void setDetNotasCredito(PvNotasCred detNotasCredito) {
        this.detNotasCredito = detNotasCredito;
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
        hash += (pvDetallFacCompraPK != null ? pvDetallFacCompraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvDetallFacCompra)) {
            return false;
        }
        PvDetallFacCompra other = (PvDetallFacCompra) object;
        if ((this.pvDetallFacCompraPK == null && other.pvDetallFacCompraPK != null) || (this.pvDetallFacCompraPK != null && !this.pvDetallFacCompraPK.equals(other.pvDetallFacCompraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvDetallFacCompra[ pvDetallFacCompraPK=" + pvDetallFacCompraPK + " ]";
    }
    
}
