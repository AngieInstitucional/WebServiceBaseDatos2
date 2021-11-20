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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cordo
 */
@Entity
@Table(name = "PV_COMPANIA")
@NamedQueries({
    @NamedQuery(name = "PvCompania.findAll", query = "SELECT p FROM PvCompania p"),
    @NamedQuery(name = "PvCompania.findByEmpId", query = "SELECT p FROM PvCompania p WHERE p.empId = :empId"),
    @NamedQuery(name = "PvCompania.findByEmpNombre", query = "SELECT p FROM PvCompania p WHERE p.empNombre = :empNombre"),
    @NamedQuery(name = "PvCompania.findByEmpTipo", query = "SELECT p FROM PvCompania p WHERE p.empTipo = :empTipo")})
public class PvCompania implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMP_ID")
    private BigDecimal empId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "EMP_NOMBRE")
    private String empNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "EMP_TIPO")
    private String empTipo;
    @JoinColumn(name = "EMP_INVENTARIO", referencedColumnName = "INV_ID")
    @ManyToOne(optional = false)
    private PvInventarios empInventario;


    public PvCompania() {
    }

    public PvCompania(BigDecimal empId) {
        this.empId = empId;
    }

    public PvCompania(BigDecimal empId, String empNombre, String empTipo) {
        this.empId = empId;
        this.empNombre = empNombre;
        this.empTipo = empTipo;
    }

    public BigDecimal getEmpId() {
        return empId;
    }

    public void setEmpId(BigDecimal empId) {
        this.empId = empId;
    }

    public String getEmpNombre() {
        return empNombre;
    }

    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    public String getEmpTipo() {
        return empTipo;
    }

    public void setEmpTipo(String empTipo) {
        this.empTipo = empTipo;
    }

    public PvInventarios getEmpInventario() {
        return empInventario;
    }

    public void setEmpInventario(PvInventarios empInventario) {
        this.empInventario = empInventario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvCompania)) {
            return false;
        }
        PvCompania other = (PvCompania) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvCompania[ empId=" + empId + " ]";
    }
    
}
