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
@Table(name = "PV_LIMITE_CREDITO")
@NamedQueries({
    @NamedQuery(name = "PvLimiteCredito.findAll", query = "SELECT p FROM PvLimiteCredito p"),
    @NamedQuery(name = "PvLimiteCredito.findByLimEmpresa", query = "SELECT p FROM PvLimiteCredito p WHERE p.pvLimiteCreditoPK.limEmpresa = :limEmpresa"),
    @NamedQuery(name = "PvLimiteCredito.findByLimProveedor", query = "SELECT p FROM PvLimiteCredito p WHERE p.pvLimiteCreditoPK.limProveedor = :limProveedor"),
    @NamedQuery(name = "PvLimiteCredito.findByLimLimiteMax", query = "SELECT p FROM PvLimiteCredito p WHERE p.limLimiteMax = :limLimiteMax")})
public class PvLimiteCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PvLimiteCreditoPK pvLimiteCreditoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LIM_LIMITE_MAX")
    private double limLimiteMax;
    @JoinColumn(name = "LIM_EMPRESA", referencedColumnName = "EMP_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PvCompania pvCompania;
    @JoinColumn(name = "LIM_PROVEEDOR", referencedColumnName = "PRO_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PvProveedores pvProveedores;

    public PvLimiteCredito() {
    }

    public PvLimiteCredito(PvLimiteCreditoPK pvLimiteCreditoPK) {
        this.pvLimiteCreditoPK = pvLimiteCreditoPK;
    }

    public PvLimiteCredito(PvLimiteCreditoPK pvLimiteCreditoPK, double limLimiteMax) {
        this.pvLimiteCreditoPK = pvLimiteCreditoPK;
        this.limLimiteMax = limLimiteMax;
    }

    public PvLimiteCredito(BigInteger limEmpresa, BigInteger limProveedor) {
        this.pvLimiteCreditoPK = new PvLimiteCreditoPK(limEmpresa, limProveedor);
    }

    public PvLimiteCreditoPK getPvLimiteCreditoPK() {
        return pvLimiteCreditoPK;
    }

    public void setPvLimiteCreditoPK(PvLimiteCreditoPK pvLimiteCreditoPK) {
        this.pvLimiteCreditoPK = pvLimiteCreditoPK;
    }

    public double getLimLimiteMax() {
        return limLimiteMax;
    }

    public void setLimLimiteMax(double limLimiteMax) {
        this.limLimiteMax = limLimiteMax;
    }

    public PvCompania getPvCompania() {
        return pvCompania;
    }

    public void setPvCompania(PvCompania pvCompania) {
        this.pvCompania = pvCompania;
    }

    public PvProveedores getPvProveedores() {
        return pvProveedores;
    }

    public void setPvProveedores(PvProveedores pvProveedores) {
        this.pvProveedores = pvProveedores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pvLimiteCreditoPK != null ? pvLimiteCreditoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvLimiteCredito)) {
            return false;
        }
        PvLimiteCredito other = (PvLimiteCredito) object;
        if ((this.pvLimiteCreditoPK == null && other.pvLimiteCreditoPK != null) || (this.pvLimiteCreditoPK != null && !this.pvLimiteCreditoPK.equals(other.pvLimiteCreditoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvLimiteCredito[ pvLimiteCreditoPK=" + pvLimiteCreditoPK + " ]";
    }
    
}
