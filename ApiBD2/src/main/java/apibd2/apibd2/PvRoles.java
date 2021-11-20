/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apibd2.apibd2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cordo
 */
@Entity
@Table(name = "PV_ROLES")
@NamedQueries({
    @NamedQuery(name = "PvRoles.findAll", query = "SELECT p FROM PvRoles p"),
    @NamedQuery(name = "PvRoles.findByRolId", query = "SELECT p FROM PvRoles p WHERE p.rolId = :rolId"),
    @NamedQuery(name = "PvRoles.findByRolNombre", query = "SELECT p FROM PvRoles p WHERE p.rolNombre = :rolNombre"),
    @NamedQuery(name = "PvRoles.findByRolContrasenna", query = "SELECT p FROM PvRoles p WHERE p.rolContrasenna = :rolContrasenna")})
public class PvRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROL_ID")
    private BigDecimal rolId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "ROL_NOMBRE")
    private String rolNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "ROL_CONTRASENNA")
    private String rolContrasenna;

    public PvRoles() {
    }

    public PvRoles(BigDecimal rolId) {
        this.rolId = rolId;
    }

    public PvRoles(BigDecimal rolId, String rolNombre, String rolContrasenna) {
        this.rolId = rolId;
        this.rolNombre = rolNombre;
        this.rolContrasenna = rolContrasenna;
    }

    public BigDecimal getRolId() {
        return rolId;
    }

    public void setRolId(BigDecimal rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getRolContrasenna() {
        return rolContrasenna;
    }

    public void setRolContrasenna(String rolContrasenna) {
        this.rolContrasenna = rolContrasenna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvRoles)) {
            return false;
        }
        PvRoles other = (PvRoles) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvRoles[ rolId=" + rolId + " ]";
    }
    
}
