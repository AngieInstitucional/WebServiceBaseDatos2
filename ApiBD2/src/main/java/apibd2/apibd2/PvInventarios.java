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
@Table(name = "PV_INVENTARIOS")
@NamedQueries({
    @NamedQuery(name = "PvInventarios.findAll", query = "SELECT p FROM PvInventarios p"),
    @NamedQuery(name = "PvInventarios.findByInvId", query = "SELECT p FROM PvInventarios p WHERE p.invId = :invId"),
    @NamedQuery(name = "PvInventarios.findByInvTipo", query = "SELECT p FROM PvInventarios p WHERE p.invTipo = :invTipo"),
    @NamedQuery(name = "PvInventarios.findByInvOberservacion", query = "SELECT p FROM PvInventarios p WHERE p.invOberservacion = :invOberservacion"),
    @NamedQuery(name = "PvInventarios.findByInvEstado", query = "SELECT p FROM PvInventarios p WHERE p.invEstado = :invEstado")})
public class PvInventarios implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INV_ID")
    private BigDecimal invId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "INV_TIPO")
    private String invTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "INV_OBERSERVACION")
    private String invOberservacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INV_ESTADO")
    private Character invEstado;

    @JoinColumn(name = "INV_SEDE", referencedColumnName = "SED_ID")
    @ManyToOne
    private PvSedes invSede;

    public PvInventarios() {
    }

    public PvInventarios(BigDecimal invId) {
        this.invId = invId;
    }

    public PvInventarios(BigDecimal invId, String invTipo, String invOberservacion, Character invEstado) {
        this.invId = invId;
        this.invTipo = invTipo;
        this.invOberservacion = invOberservacion;
        this.invEstado = invEstado;
    }

    public BigDecimal getInvId() {
        return invId;
    }

    public void setInvId(BigDecimal invId) {
        this.invId = invId;
    }

    public String getInvTipo() {
        return invTipo;
    }

    public void setInvTipo(String invTipo) {
        this.invTipo = invTipo;
    }

    public String getInvOberservacion() {
        return invOberservacion;
    }

    public void setInvOberservacion(String invOberservacion) {
        this.invOberservacion = invOberservacion;
    }

    public Character getInvEstado() {
        return invEstado;
    }

    public void setInvEstado(Character invEstado) {
        this.invEstado = invEstado;
    }

    public PvSedes getInvSede() {
        return invSede;
    }

    public void setInvSede(PvSedes invSede) {
        this.invSede = invSede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invId != null ? invId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvInventarios)) {
            return false;
        }
        PvInventarios other = (PvInventarios) object;
        if ((this.invId == null && other.invId != null) || (this.invId != null && !this.invId.equals(other.invId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvInventarios[ invId=" + invId + " ]";
    }
    
}
