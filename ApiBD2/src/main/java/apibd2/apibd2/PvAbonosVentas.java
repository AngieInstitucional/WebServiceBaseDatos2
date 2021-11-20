/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apibd2.apibd2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cordo
 */
@Entity
@Table(name = "PV_ABONOS_VENTAS")
@NamedQueries({
    @NamedQuery(name = "PvAbonosVentas.findAll", query = "SELECT p FROM PvAbonosVentas p"),
    @NamedQuery(name = "PvAbonosVentas.findByAbovId", query = "SELECT p FROM PvAbonosVentas p WHERE p.abovId = :abovId"),
    @NamedQuery(name = "PvAbonosVentas.findByAbovMonto", query = "SELECT p FROM PvAbonosVentas p WHERE p.abovMonto = :abovMonto"),
    @NamedQuery(name = "PvAbonosVentas.findByAbovFechaAbono", query = "SELECT p FROM PvAbonosVentas p WHERE p.abovFechaAbono = :abovFechaAbono")})
public class PvAbonosVentas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ABOV_ID")
    private BigDecimal abovId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ABOV_MONTO")
    private double abovMonto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ABOV_FECHA_ABONO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date abovFechaAbono;
    @JoinColumn(name = "ABOV_FAC_ID", referencedColumnName = "FAC_ID")
    @ManyToOne
    private PvFacturasVenta abovFacId;

    public PvAbonosVentas() {
    }

    public PvAbonosVentas(BigDecimal abovId) {
        this.abovId = abovId;
    }

    public PvAbonosVentas(BigDecimal abovId, double abovMonto, Date abovFechaAbono) {
        this.abovId = abovId;
        this.abovMonto = abovMonto;
        this.abovFechaAbono = abovFechaAbono;
    }

    public BigDecimal getAbovId() {
        return abovId;
    }

    public void setAbovId(BigDecimal abovId) {
        this.abovId = abovId;
    }

    public double getAbovMonto() {
        return abovMonto;
    }

    public void setAbovMonto(double abovMonto) {
        this.abovMonto = abovMonto;
    }

    public Date getAbovFechaAbono() {
        return abovFechaAbono;
    }

    public void setAbovFechaAbono(Date abovFechaAbono) {
        this.abovFechaAbono = abovFechaAbono;
    }

    public PvFacturasVenta getAbovFacId() {
        return abovFacId;
    }

    public void setAbovFacId(PvFacturasVenta abovFacId) {
        this.abovFacId = abovFacId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (abovId != null ? abovId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvAbonosVentas)) {
            return false;
        }
        PvAbonosVentas other = (PvAbonosVentas) object;
        if ((this.abovId == null && other.abovId != null) || (this.abovId != null && !this.abovId.equals(other.abovId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvAbonosVentas[ abovId=" + abovId + " ]";
    }
    
}
