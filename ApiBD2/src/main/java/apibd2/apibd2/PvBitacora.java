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
@Table(name = "PV_BITACORA")
@NamedQueries({
    @NamedQuery(name = "PvBitacora.findAll", query = "SELECT p FROM PvBitacora p"),
    @NamedQuery(name = "PvBitacora.findByBitId", query = "SELECT p FROM PvBitacora p WHERE p.bitId = :bitId"),
    @NamedQuery(name = "PvBitacora.findByBitAccion", query = "SELECT p FROM PvBitacora p WHERE p.bitAccion = :bitAccion"),
    @NamedQuery(name = "PvBitacora.findByBitTipo", query = "SELECT p FROM PvBitacora p WHERE p.bitTipo = :bitTipo"),
    @NamedQuery(name = "PvBitacora.findByBitDetalle", query = "SELECT p FROM PvBitacora p WHERE p.bitDetalle = :bitDetalle"),
    @NamedQuery(name = "PvBitacora.findByBitUsuario", query = "SELECT p FROM PvBitacora p WHERE p.bitUsuario = :bitUsuario"),
    @NamedQuery(name = "PvBitacora.findByBitFecha", query = "SELECT p FROM PvBitacora p WHERE p.bitFecha = :bitFecha")})
public class PvBitacora implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BIT_ID")
    private BigDecimal bitId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "BIT_ACCION")
    private String bitAccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "BIT_TIPO")
    private String bitTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "BIT_DETALLE")
    private String bitDetalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "BIT_USUARIO")
    private String bitUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BIT_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bitFecha;

    public PvBitacora() {
    }

    public PvBitacora(BigDecimal bitId) {
        this.bitId = bitId;
    }

    public PvBitacora(BigDecimal bitId, String bitAccion, String bitTipo, String bitDetalle, String bitUsuario, Date bitFecha) {
        this.bitId = bitId;
        this.bitAccion = bitAccion;
        this.bitTipo = bitTipo;
        this.bitDetalle = bitDetalle;
        this.bitUsuario = bitUsuario;
        this.bitFecha = bitFecha;
    }

    public BigDecimal getBitId() {
        return bitId;
    }

    public void setBitId(BigDecimal bitId) {
        this.bitId = bitId;
    }

    public String getBitAccion() {
        return bitAccion;
    }

    public void setBitAccion(String bitAccion) {
        this.bitAccion = bitAccion;
    }

    public String getBitTipo() {
        return bitTipo;
    }

    public void setBitTipo(String bitTipo) {
        this.bitTipo = bitTipo;
    }

    public String getBitDetalle() {
        return bitDetalle;
    }

    public void setBitDetalle(String bitDetalle) {
        this.bitDetalle = bitDetalle;
    }

    public String getBitUsuario() {
        return bitUsuario;
    }

    public void setBitUsuario(String bitUsuario) {
        this.bitUsuario = bitUsuario;
    }

    public Date getBitFecha() {
        return bitFecha;
    }

    public void setBitFecha(Date bitFecha) {
        this.bitFecha = bitFecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bitId != null ? bitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvBitacora)) {
            return false;
        }
        PvBitacora other = (PvBitacora) object;
        if ((this.bitId == null && other.bitId != null) || (this.bitId != null && !this.bitId.equals(other.bitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvBitacora[ bitId=" + bitId + " ]";
    }
    
}
