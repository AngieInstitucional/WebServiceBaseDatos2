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
@Table(name = "PV_FAMILIAS")
@NamedQueries({
    @NamedQuery(name = "PvFamilias.findAll", query = "SELECT p FROM PvFamilias p"),
    @NamedQuery(name = "PvFamilias.findByFamId", query = "SELECT p FROM PvFamilias p WHERE p.famId = :famId"),
    @NamedQuery(name = "PvFamilias.findByFamNombre", query = "SELECT p FROM PvFamilias p WHERE p.famNombre = :famNombre"),
    @NamedQuery(name = "PvFamilias.findByFamDescripcion", query = "SELECT p FROM PvFamilias p WHERE p.famDescripcion = :famDescripcion"),
    @NamedQuery(name = "PvFamilias.findByFamEstado", query = "SELECT p FROM PvFamilias p WHERE p.famEstado = :famEstado")})
public class PvFamilias implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FAM_ID")
    private BigDecimal famId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "FAM_NOMBRE")
    private String famNombre;
    @Size(max = 500)
    @Column(name = "FAM_DESCRIPCION")
    private String famDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FAM_ESTADO")
    private Character famEstado;

    public PvFamilias() {
    }

    public PvFamilias(BigDecimal famId) {
        this.famId = famId;
    }

    public PvFamilias(BigDecimal famId, String famNombre, Character famEstado) {
        this.famId = famId;
        this.famNombre = famNombre;
        this.famEstado = famEstado;
    }

    public BigDecimal getFamId() {
        return famId;
    }

    public void setFamId(BigDecimal famId) {
        this.famId = famId;
    }

    public String getFamNombre() {
        return famNombre;
    }

    public void setFamNombre(String famNombre) {
        this.famNombre = famNombre;
    }

    public String getFamDescripcion() {
        return famDescripcion;
    }

    public void setFamDescripcion(String famDescripcion) {
        this.famDescripcion = famDescripcion;
    }

    public Character getFamEstado() {
        return famEstado;
    }

    public void setFamEstado(Character famEstado) {
        this.famEstado = famEstado;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (famId != null ? famId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvFamilias)) {
            return false;
        }
        PvFamilias other = (PvFamilias) object;
        if ((this.famId == null && other.famId != null) || (this.famId != null && !this.famId.equals(other.famId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvFamilias[ famId=" + famId + " ]";
    }
    
}
