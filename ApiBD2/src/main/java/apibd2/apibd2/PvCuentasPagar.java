/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apibd2.apibd2;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "PV_CUENTAS_PAGAR")
@NamedQueries({
    @NamedQuery(name = "PvCuentasPagar.findAll", query = "SELECT p FROM PvCuentasPagar p"),
    @NamedQuery(name = "PvCuentasPagar.findByCueId", query = "SELECT p FROM PvCuentasPagar p WHERE p.cueId = :cueId"),
    @NamedQuery(name = "PvCuentasPagar.findByCueMonto", query = "SELECT p FROM PvCuentasPagar p WHERE p.cueMonto = :cueMonto")})
public class PvCuentasPagar implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUE_ID")
    private BigDecimal cueId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUE_MONTO")
    private double cueMonto;
    @JoinColumn(name = "CUE_PROVEEDOR", referencedColumnName = "PRO_ID")
    @ManyToOne(optional = false)
    private PvProveedores cueProveedor;

    public PvCuentasPagar() {
    }

    public PvCuentasPagar(BigDecimal cueId) {
        this.cueId = cueId;
    }

    public PvCuentasPagar(BigDecimal cueId, double cueMonto) {
        this.cueId = cueId;
        this.cueMonto = cueMonto;
    }

    public BigDecimal getCueId() {
        return cueId;
    }

    public void setCueId(BigDecimal cueId) {
        this.cueId = cueId;
    }

    public double getCueMonto() {
        return cueMonto;
    }

    public void setCueMonto(double cueMonto) {
        this.cueMonto = cueMonto;
    }

    public PvProveedores getCueProveedor() {
        return cueProveedor;
    }

    public void setCueProveedor(PvProveedores cueProveedor) {
        this.cueProveedor = cueProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cueId != null ? cueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvCuentasPagar)) {
            return false;
        }
        PvCuentasPagar other = (PvCuentasPagar) object;
        if ((this.cueId == null && other.cueId != null) || (this.cueId != null && !this.cueId.equals(other.cueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvCuentasPagar[ cueId=" + cueId + " ]";
    }
    
}
