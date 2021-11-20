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
import javax.validation.constraints.Size;

/**
 *
 * @author cordo
 */
@Entity
@Table(name = "PV_ACCIONES")
@NamedQueries({
    @NamedQuery(name = "PvAcciones.findAll", query = "SELECT p FROM PvAcciones p"),
    @NamedQuery(name = "PvAcciones.findByAccCodigo", query = "SELECT p FROM PvAcciones p WHERE p.accCodigo = :accCodigo"),
    @NamedQuery(name = "PvAcciones.findByAccVencimiento", query = "SELECT p FROM PvAcciones p WHERE p.accVencimiento = :accVencimiento"),
    @NamedQuery(name = "PvAcciones.findByAccEstado", query = "SELECT p FROM PvAcciones p WHERE p.accEstado = :accEstado")})
public class PvAcciones implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACC_CODIGO")
    private BigDecimal accCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACC_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date accVencimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ACC_ESTADO")
    private String accEstado;
    @JoinColumn(name = "ACC_CLIENTE", referencedColumnName = "CLI_ID")
    @ManyToOne(optional = false)
    private PvClientes accCliente;
    @JoinColumn(name = "ACC_PROMOCION", referencedColumnName = "PRO_ID")
    @ManyToOne
    private PvPromociones accPromocion;

    public PvAcciones() {
    }

    public PvAcciones(BigDecimal accCodigo) {
        this.accCodigo = accCodigo;
    }

    public PvAcciones(BigDecimal accCodigo, Date accVencimiento, String accEstado) {
        this.accCodigo = accCodigo;
        this.accVencimiento = accVencimiento;
        this.accEstado = accEstado;
    }

    public BigDecimal getAccCodigo() {
        return accCodigo;
    }

    public void setAccCodigo(BigDecimal accCodigo) {
        this.accCodigo = accCodigo;
    }

    public Date getAccVencimiento() {
        return accVencimiento;
    }

    public void setAccVencimiento(Date accVencimiento) {
        this.accVencimiento = accVencimiento;
    }

    public String getAccEstado() {
        return accEstado;
    }

    public void setAccEstado(String accEstado) {
        this.accEstado = accEstado;
    }

    public PvClientes getAccCliente() {
        return accCliente;
    }

    public void setAccCliente(PvClientes accCliente) {
        this.accCliente = accCliente;
    }

    public PvPromociones getAccPromocion() {
        return accPromocion;
    }

    public void setAccPromocion(PvPromociones accPromocion) {
        this.accPromocion = accPromocion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accCodigo != null ? accCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvAcciones)) {
            return false;
        }
        PvAcciones other = (PvAcciones) object;
        if ((this.accCodigo == null && other.accCodigo != null) || (this.accCodigo != null && !this.accCodigo.equals(other.accCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvAcciones[ accCodigo=" + accCodigo + " ]";
    }
    
}
