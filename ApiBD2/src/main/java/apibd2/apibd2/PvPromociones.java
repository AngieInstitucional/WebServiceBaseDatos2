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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cordo
 */
@Entity
@Table(name = "PV_PROMOCIONES")
@NamedQueries({
    @NamedQuery(name = "PvPromociones.findAll", query = "SELECT p FROM PvPromociones p"),
    @NamedQuery(name = "PvPromociones.findByProId", query = "SELECT p FROM PvPromociones p WHERE p.proId = :proId"),
    @NamedQuery(name = "PvPromociones.findByProNombre", query = "SELECT p FROM PvPromociones p WHERE p.proNombre = :proNombre"),
    @NamedQuery(name = "PvPromociones.findByProDescripcion", query = "SELECT p FROM PvPromociones p WHERE p.proDescripcion = :proDescripcion"),
    @NamedQuery(name = "PvPromociones.findByProValidezHasta", query = "SELECT p FROM PvPromociones p WHERE p.proValidezHasta = :proValidezHasta"),
    @NamedQuery(name = "PvPromociones.findByProEstado", query = "SELECT p FROM PvPromociones p WHERE p.proEstado = :proEstado")})
public class PvPromociones implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_ID")
    private BigDecimal proId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "PRO_NOMBRE")
    private String proNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "PRO_DESCRIPCION")
    private String proDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_VALIDEZ_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proValidezHasta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_ESTADO")
    private Character proEstado;
    @JoinColumn(name = "PRO_TIPO", referencedColumnName = "TIP_ID")
    @ManyToOne(optional = false)
    private PvTipoPromocion proTipo;

    public PvPromociones() {
    }

    public PvPromociones(BigDecimal proId) {
        this.proId = proId;
    }

    public PvPromociones(BigDecimal proId, String proNombre, String proDescripcion, Date proValidezHasta, Character proEstado) {
        this.proId = proId;
        this.proNombre = proNombre;
        this.proDescripcion = proDescripcion;
        this.proValidezHasta = proValidezHasta;
        this.proEstado = proEstado;
    }

    public BigDecimal getProId() {
        return proId;
    }

    public void setProId(BigDecimal proId) {
        this.proId = proId;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProDescripcion() {
        return proDescripcion;
    }

    public void setProDescripcion(String proDescripcion) {
        this.proDescripcion = proDescripcion;
    }

    public Date getProValidezHasta() {
        return proValidezHasta;
    }

    public void setProValidezHasta(Date proValidezHasta) {
        this.proValidezHasta = proValidezHasta;
    }

    public Character getProEstado() {
        return proEstado;
    }

    public void setProEstado(Character proEstado) {
        this.proEstado = proEstado;
    }

    public PvTipoPromocion getProTipo() {
        return proTipo;
    }

    public void setProTipo(PvTipoPromocion proTipo) {
        this.proTipo = proTipo;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvPromociones)) {
            return false;
        }
        PvPromociones other = (PvPromociones) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvPromociones[ proId=" + proId + " ]";
    }
    
}
