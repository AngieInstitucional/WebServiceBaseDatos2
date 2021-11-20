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

/**
 *
 * @author cordo
 */
@Entity
@Table(name = "PV_NOTAS_CRED")
@NamedQueries({
    @NamedQuery(name = "PvNotasCred.findAll", query = "SELECT p FROM PvNotasCred p"),
    @NamedQuery(name = "PvNotasCred.findByNotId", query = "SELECT p FROM PvNotasCred p WHERE p.notId = :notId"),
    @NamedQuery(name = "PvNotasCred.findByNotMonto", query = "SELECT p FROM PvNotasCred p WHERE p.notMonto = :notMonto"),
    @NamedQuery(name = "PvNotasCred.findByNotEstado", query = "SELECT p FROM PvNotasCred p WHERE p.notEstado = :notEstado"),
    @NamedQuery(name = "PvNotasCred.findByNotFechaEmision", query = "SELECT p FROM PvNotasCred p WHERE p.notFechaEmision = :notFechaEmision")})
public class PvNotasCred implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOT_ID")
    private BigDecimal notId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOT_MONTO")
    private double notMonto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOT_ESTADO")
    private Character notEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOT_FECHA_EMISION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date notFechaEmision;
    @JoinColumn(name = "NOT_CLIENTE", referencedColumnName = "CLI_ID")
    @ManyToOne
    private PvClientes notCliente;
    @JoinColumn(name = "NOT_EMPRESA", referencedColumnName = "EMP_ID")
    @ManyToOne
    private PvCompania notEmpresa;

    public PvNotasCred() {
    }

    public PvNotasCred(BigDecimal notId) {
        this.notId = notId;
    }

    public PvNotasCred(BigDecimal notId, double notMonto, Character notEstado, Date notFechaEmision) {
        this.notId = notId;
        this.notMonto = notMonto;
        this.notEstado = notEstado;
        this.notFechaEmision = notFechaEmision;
    }

    public BigDecimal getNotId() {
        return notId;
    }

    public void setNotId(BigDecimal notId) {
        this.notId = notId;
    }

    public double getNotMonto() {
        return notMonto;
    }

    public void setNotMonto(double notMonto) {
        this.notMonto = notMonto;
    }

    public Character getNotEstado() {
        return notEstado;
    }

    public void setNotEstado(Character notEstado) {
        this.notEstado = notEstado;
    }

    public Date getNotFechaEmision() {
        return notFechaEmision;
    }

    public void setNotFechaEmision(Date notFechaEmision) {
        this.notFechaEmision = notFechaEmision;
    }

    public PvClientes getNotCliente() {
        return notCliente;
    }

    public void setNotCliente(PvClientes notCliente) {
        this.notCliente = notCliente;
    }

    public PvCompania getNotEmpresa() {
        return notEmpresa;
    }

    public void setNotEmpresa(PvCompania notEmpresa) {
        this.notEmpresa = notEmpresa;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notId != null ? notId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvNotasCred)) {
            return false;
        }
        PvNotasCred other = (PvNotasCred) object;
        if ((this.notId == null && other.notId != null) || (this.notId != null && !this.notId.equals(other.notId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvNotasCred[ notId=" + notId + " ]";
    }
    
}
