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
@Table(name = "PV_CUENTAS_COBRAR")
@NamedQueries({
    @NamedQuery(name = "PvCuentasCobrar.findAll", query = "SELECT p FROM PvCuentasCobrar p"),
    @NamedQuery(name = "PvCuentasCobrar.findByCueId", query = "SELECT p FROM PvCuentasCobrar p WHERE p.cueId = :cueId"),
    @NamedQuery(name = "PvCuentasCobrar.findByCueSaldoPendiente", query = "SELECT p FROM PvCuentasCobrar p WHERE p.cueSaldoPendiente = :cueSaldoPendiente")})
public class PvCuentasCobrar implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUE_ID")
    private BigDecimal cueId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUE_SALDO_PENDIENTE")
    private double cueSaldoPendiente;
    @JoinColumn(name = "CUE_CLIENTE", referencedColumnName = "CLI_ID")
    @ManyToOne(optional = false)
    private PvClientes cueCliente;

    public PvCuentasCobrar() {
    }

    public PvCuentasCobrar(BigDecimal cueId) {
        this.cueId = cueId;
    }

    public PvCuentasCobrar(BigDecimal cueId, double cueSaldoPendiente) {
        this.cueId = cueId;
        this.cueSaldoPendiente = cueSaldoPendiente;
    }

    public BigDecimal getCueId() {
        return cueId;
    }

    public void setCueId(BigDecimal cueId) {
        this.cueId = cueId;
    }

    public double getCueSaldoPendiente() {
        return cueSaldoPendiente;
    }

    public void setCueSaldoPendiente(double cueSaldoPendiente) {
        this.cueSaldoPendiente = cueSaldoPendiente;
    }

    public PvClientes getCueCliente() {
        return cueCliente;
    }

    public void setCueCliente(PvClientes cueCliente) {
        this.cueCliente = cueCliente;
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
        if (!(object instanceof PvCuentasCobrar)) {
            return false;
        }
        PvCuentasCobrar other = (PvCuentasCobrar) object;
        if ((this.cueId == null && other.cueId != null) || (this.cueId != null && !this.cueId.equals(other.cueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvCuentasCobrar[ cueId=" + cueId + " ]";
    }
    
}
