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
@Table(name = "PV_ABONOS")
@NamedQueries({
    @NamedQuery(name = "PvAbonos.findAll", query = "SELECT p FROM PvAbonos p"),
    @NamedQuery(name = "PvAbonos.findByAboId", query = "SELECT p FROM PvAbonos p WHERE p.aboId = :aboId"),
    @NamedQuery(name = "PvAbonos.findByAboMonto", query = "SELECT p FROM PvAbonos p WHERE p.aboMonto = :aboMonto"),
    @NamedQuery(name = "PvAbonos.findByAboFechaAbono", query = "SELECT p FROM PvAbonos p WHERE p.aboFechaAbono = :aboFechaAbono")})
public class PvAbonos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ABO_ID")
    private BigDecimal aboId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ABO_MONTO")
    private double aboMonto;
    @Column(name = "ABO_FECHA_ABONO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aboFechaAbono;
    @JoinColumn(name = "ABO_FAC_ID", referencedColumnName = "FAC_ID")
    @ManyToOne
    private PvFacturasCompra aboFacId;

    public PvAbonos() {
    }

    public PvAbonos(BigDecimal aboId) {
        this.aboId = aboId;
    }

    public PvAbonos(BigDecimal aboId, double aboMonto) {
        this.aboId = aboId;
        this.aboMonto = aboMonto;
    }

    public BigDecimal getAboId() {
        return aboId;
    }

    public void setAboId(BigDecimal aboId) {
        this.aboId = aboId;
    }

    public double getAboMonto() {
        return aboMonto;
    }

    public void setAboMonto(double aboMonto) {
        this.aboMonto = aboMonto;
    }

    public Date getAboFechaAbono() {
        return aboFechaAbono;
    }

    public void setAboFechaAbono(Date aboFechaAbono) {
        this.aboFechaAbono = aboFechaAbono;
    }

    public PvFacturasCompra getAboFacId() {
        return aboFacId;
    }

    public void setAboFacId(PvFacturasCompra aboFacId) {
        this.aboFacId = aboFacId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aboId != null ? aboId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvAbonos)) {
            return false;
        }
        PvAbonos other = (PvAbonos) object;
        if ((this.aboId == null && other.aboId != null) || (this.aboId != null && !this.aboId.equals(other.aboId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvAbonos[ aboId=" + aboId + " ]";
    }
    
}
