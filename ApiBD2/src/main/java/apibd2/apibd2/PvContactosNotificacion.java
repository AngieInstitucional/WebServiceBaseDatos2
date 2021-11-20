/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apibd2.apibd2;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cordo
 */
@Entity
@Table(name = "PV_CONTACTOS_NOTIFICACION")
@NamedQueries({
    @NamedQuery(name = "PvContactosNotificacion.findAll", query = "SELECT p FROM PvContactosNotificacion p"),
    @NamedQuery(name = "PvContactosNotificacion.findByConId", query = "SELECT p FROM PvContactosNotificacion p WHERE p.conId = :conId"),
    @NamedQuery(name = "PvContactosNotificacion.findByConNombreCompleto", query = "SELECT p FROM PvContactosNotificacion p WHERE p.conNombreCompleto = :conNombreCompleto"),
    @NamedQuery(name = "PvContactosNotificacion.findByConPuesto", query = "SELECT p FROM PvContactosNotificacion p WHERE p.conPuesto = :conPuesto"),
    @NamedQuery(name = "PvContactosNotificacion.findByConEmail", query = "SELECT p FROM PvContactosNotificacion p WHERE p.conEmail = :conEmail"),
    @NamedQuery(name = "PvContactosNotificacion.findByConEstado", query = "SELECT p FROM PvContactosNotificacion p WHERE p.conEstado = :conEstado")})
public class PvContactosNotificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CON_ID")
    private BigDecimal conId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "CON_NOMBRE_COMPLETO")
    private String conNombreCompleto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "CON_PUESTO")
    private String conPuesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "CON_EMAIL")
    private String conEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CON_ESTADO")
    private Character conEstado;

    public PvContactosNotificacion() {
    }

    public PvContactosNotificacion(BigDecimal conId) {
        this.conId = conId;
    }

    public PvContactosNotificacion(BigDecimal conId, String conNombreCompleto, String conPuesto, String conEmail, Character conEstado) {
        this.conId = conId;
        this.conNombreCompleto = conNombreCompleto;
        this.conPuesto = conPuesto;
        this.conEmail = conEmail;
        this.conEstado = conEstado;
    }

    public BigDecimal getConId() {
        return conId;
    }

    public void setConId(BigDecimal conId) {
        this.conId = conId;
    }

    public String getConNombreCompleto() {
        return conNombreCompleto;
    }

    public void setConNombreCompleto(String conNombreCompleto) {
        this.conNombreCompleto = conNombreCompleto;
    }

    public String getConPuesto() {
        return conPuesto;
    }

    public void setConPuesto(String conPuesto) {
        this.conPuesto = conPuesto;
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail;
    }

    public Character getConEstado() {
        return conEstado;
    }

    public void setConEstado(Character conEstado) {
        this.conEstado = conEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conId != null ? conId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvContactosNotificacion)) {
            return false;
        }
        PvContactosNotificacion other = (PvContactosNotificacion) object;
        if ((this.conId == null && other.conId != null) || (this.conId != null && !this.conId.equals(other.conId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvContactosNotificacion[ conId=" + conId + " ]";
    }
    
}
