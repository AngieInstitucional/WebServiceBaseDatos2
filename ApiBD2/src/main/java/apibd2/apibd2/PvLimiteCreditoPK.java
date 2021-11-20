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
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cordo
 */
@Embeddable
public class PvLimiteCreditoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "LIM_EMPRESA")
    private BigInteger limEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LIM_PROVEEDOR")
    private BigInteger limProveedor;

    public PvLimiteCreditoPK() {
    }

    public PvLimiteCreditoPK(BigInteger limEmpresa, BigInteger limProveedor) {
        this.limEmpresa = limEmpresa;
        this.limProveedor = limProveedor;
    }

    public BigInteger getLimEmpresa() {
        return limEmpresa;
    }

    public void setLimEmpresa(BigInteger limEmpresa) {
        this.limEmpresa = limEmpresa;
    }

    public BigInteger getLimProveedor() {
        return limProveedor;
    }

    public void setLimProveedor(BigInteger limProveedor) {
        this.limProveedor = limProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (limEmpresa != null ? limEmpresa.hashCode() : 0);
        hash += (limProveedor != null ? limProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvLimiteCreditoPK)) {
            return false;
        }
        PvLimiteCreditoPK other = (PvLimiteCreditoPK) object;
        if ((this.limEmpresa == null && other.limEmpresa != null) || (this.limEmpresa != null && !this.limEmpresa.equals(other.limEmpresa))) {
            return false;
        }
        if ((this.limProveedor == null && other.limProveedor != null) || (this.limProveedor != null && !this.limProveedor.equals(other.limProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvLimiteCreditoPK[ limEmpresa=" + limEmpresa + ", limProveedor=" + limProveedor + " ]";
    }
    
}
