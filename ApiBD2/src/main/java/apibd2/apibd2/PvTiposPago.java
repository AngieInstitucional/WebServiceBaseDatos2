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
@Table(name = "PV_TIPOS_PAGO")
@NamedQueries({
    @NamedQuery(name = "PvTiposPago.findAll", query = "SELECT p FROM PvTiposPago p"),
    @NamedQuery(name = "PvTiposPago.findByTipId", query = "SELECT p FROM PvTiposPago p WHERE p.tipId = :tipId"),
    @NamedQuery(name = "PvTiposPago.findByTipNombre", query = "SELECT p FROM PvTiposPago p WHERE p.tipNombre = :tipNombre"),
    @NamedQuery(name = "PvTiposPago.findByTipDescripcion", query = "SELECT p FROM PvTiposPago p WHERE p.tipDescripcion = :tipDescripcion")})
public class PvTiposPago implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIP_ID")
    private BigDecimal tipId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TIP_NOMBRE")
    private String tipNombre;
    @Size(max = 128)
    @Column(name = "TIP_DESCRIPCION")
    private String tipDescripcion;

    public PvTiposPago() {
    }

    public PvTiposPago(BigDecimal tipId) {
        this.tipId = tipId;
    }

    public PvTiposPago(BigDecimal tipId, String tipNombre) {
        this.tipId = tipId;
        this.tipNombre = tipNombre;
    }

    public BigDecimal getTipId() {
        return tipId;
    }

    public void setTipId(BigDecimal tipId) {
        this.tipId = tipId;
    }

    public String getTipNombre() {
        return tipNombre;
    }

    public void setTipNombre(String tipNombre) {
        this.tipNombre = tipNombre;
    }

    public String getTipDescripcion() {
        return tipDescripcion;
    }

    public void setTipDescripcion(String tipDescripcion) {
        this.tipDescripcion = tipDescripcion;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipId != null ? tipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvTiposPago)) {
            return false;
        }
        PvTiposPago other = (PvTiposPago) object;
        if ((this.tipId == null && other.tipId != null) || (this.tipId != null && !this.tipId.equals(other.tipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvTiposPago[ tipId=" + tipId + " ]";
    }
    
}
