/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apibd2.apibd2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "PV_FACTURAS_VENTA")
@NamedQueries({
    @NamedQuery(name = "PvFacturasVenta.findAll", query = "SELECT p FROM PvFacturasVenta p"),
    @NamedQuery(name = "PvFacturasVenta.findByFacId", query = "SELECT p FROM PvFacturasVenta p WHERE p.facId = :facId"),
    @NamedQuery(name = "PvFacturasVenta.findByFacFecha", query = "SELECT p FROM PvFacturasVenta p WHERE p.facFecha = :facFecha"),
    @NamedQuery(name = "PvFacturasVenta.findByFacSubtotal", query = "SELECT p FROM PvFacturasVenta p WHERE p.facSubtotal = :facSubtotal"),
    @NamedQuery(name = "PvFacturasVenta.findByFacTotal", query = "SELECT p FROM PvFacturasVenta p WHERE p.facTotal = :facTotal"),
    @NamedQuery(name = "PvFacturasVenta.findByFacTipoPago", query = "SELECT p FROM PvFacturasVenta p WHERE p.facTipoPago = :facTipoPago"),
    @NamedQuery(name = "PvFacturasVenta.findByFacEstado", query = "SELECT p FROM PvFacturasVenta p WHERE p.facEstado = :facEstado"),
    @NamedQuery(name = "PvFacturasVenta.findByFacCodigo", query = "SELECT p FROM PvFacturasVenta p WHERE p.facCodigo = :facCodigo")})
public class PvFacturasVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FAC_ID")
    private BigDecimal facId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FAC_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date facFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FAC_SUBTOTAL")
    private double facSubtotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FAC_TOTAL")
    private double facTotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FAC_TIPO_PAGO")
    private String facTipoPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "FAC_ESTADO")
    private String facEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FAC_CODIGO")
    private String facCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pvFacturasVenta")
    private Collection<PvPagoFactura> pvPagoFacturaCollection;
    @JoinColumn(name = "FAC_CLIENTE", referencedColumnName = "CLI_ID")
    @ManyToOne(optional = false)
    private PvClientes facCliente;
    @JoinColumn(name = "FAC_SEDE", referencedColumnName = "SED_ID")
    @ManyToOne(optional = false)
    private PvSedes facSede;

    public PvFacturasVenta() {
    }

    public PvFacturasVenta(BigDecimal facId) {
        this.facId = facId;
    }

    public PvFacturasVenta(BigDecimal facId, Date facFecha, double facSubtotal, double facTotal, String facTipoPago, String facEstado, String facCodigo) {
        this.facId = facId;
        this.facFecha = facFecha;
        this.facSubtotal = facSubtotal;
        this.facTotal = facTotal;
        this.facTipoPago = facTipoPago;
        this.facEstado = facEstado;
        this.facCodigo = facCodigo;
    }

    public BigDecimal getFacId() {
        return facId;
    }

    public void setFacId(BigDecimal facId) {
        this.facId = facId;
    }

    public Date getFacFecha() {
        return facFecha;
    }

    public void setFacFecha(Date facFecha) {
        this.facFecha = facFecha;
    }

    public double getFacSubtotal() {
        return facSubtotal;
    }

    public void setFacSubtotal(double facSubtotal) {
        this.facSubtotal = facSubtotal;
    }

    public double getFacTotal() {
        return facTotal;
    }

    public void setFacTotal(double facTotal) {
        this.facTotal = facTotal;
    }

    public String getFacTipoPago() {
        return facTipoPago;
    }

    public void setFacTipoPago(String facTipoPago) {
        this.facTipoPago = facTipoPago;
    }

    public String getFacEstado() {
        return facEstado;
    }

    public void setFacEstado(String facEstado) {
        this.facEstado = facEstado;
    }

    public String getFacCodigo() {
        return facCodigo;
    }

    public void setFacCodigo(String facCodigo) {
        this.facCodigo = facCodigo;
    }

    public Collection<PvPagoFactura> getPvPagoFacturaCollection() {
        return pvPagoFacturaCollection;
    }

    public void setPvPagoFacturaCollection(Collection<PvPagoFactura> pvPagoFacturaCollection) {
        this.pvPagoFacturaCollection = pvPagoFacturaCollection;
    }

    public PvClientes getFacCliente() {
        return facCliente;
    }

    public void setFacCliente(PvClientes facCliente) {
        this.facCliente = facCliente;
    }

    public PvSedes getFacSede() {
        return facSede;
    }

    public void setFacSede(PvSedes facSede) {
        this.facSede = facSede;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facId != null ? facId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvFacturasVenta)) {
            return false;
        }
        PvFacturasVenta other = (PvFacturasVenta) object;
        if ((this.facId == null && other.facId != null) || (this.facId != null && !this.facId.equals(other.facId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvFacturasVenta[ facId=" + facId + " ]";
    }
    
}
