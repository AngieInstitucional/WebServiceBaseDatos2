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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PV_PARAMETROS")
@NamedQueries({
    @NamedQuery(name = "PvParametros.findAll", query = "SELECT p FROM PvParametros p"),
    @NamedQuery(name = "PvParametros.findByParId", query = "SELECT p FROM PvParametros p WHERE p.parId = :parId"),
    @NamedQuery(name = "PvParametros.findByParUsuario", query = "SELECT p FROM PvParametros p WHERE p.parUsuario = :parUsuario"),
    @NamedQuery(name = "PvParametros.findByParContrasena", query = "SELECT p FROM PvParametros p WHERE p.parContrasena = :parContrasena"),
    @NamedQuery(name = "PvParametros.findByParCorreo", query = "SELECT p FROM PvParametros p WHERE p.parCorreo = :parCorreo"),
    @NamedQuery(name = "PvParametros.findByParEstado", query = "SELECT p FROM PvParametros p WHERE p.parEstado = :parEstado")})
public class PvParametros implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAR_ID")
    private BigDecimal parId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PAR_USUARIO")
    private String parUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 160)
    @Column(name = "PAR_CONTRASENA")
    private String parContrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "PAR_CORREO")
    private String parCorreo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PAR_ESTADO")
    private String parEstado;
    @JoinColumn(name = "PAR_ROL", referencedColumnName = "ROL_ID")
    @ManyToOne
    private PvRoles parRol;

    public PvParametros() {
    }

    public PvParametros(BigDecimal parId) {
        this.parId = parId;
    }

    public PvParametros(BigDecimal parId, String parUsuario, String parContrasena, String parCorreo, String parEstado) {
        this.parId = parId;
        this.parUsuario = parUsuario;
        this.parContrasena = parContrasena;
        this.parCorreo = parCorreo;
        this.parEstado = parEstado;
    }

    public BigDecimal getParId() {
        return parId;
    }

    public void setParId(BigDecimal parId) {
        this.parId = parId;
    }

    public String getParUsuario() {
        return parUsuario;
    }

    public void setParUsuario(String parUsuario) {
        this.parUsuario = parUsuario;
    }

    public String getParContrasena() {
        return parContrasena;
    }

    public void setParContrasena(String parContrasena) {
        this.parContrasena = parContrasena;
    }

    public String getParCorreo() {
        return parCorreo;
    }

    public void setParCorreo(String parCorreo) {
        this.parCorreo = parCorreo;
    }

    public String getParEstado() {
        return parEstado;
    }

    public void setParEstado(String parEstado) {
        this.parEstado = parEstado;
    }

    public PvRoles getParRol() {
        return parRol;
    }

    public void setParRol(PvRoles parRol) {
        this.parRol = parRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parId != null ? parId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvParametros)) {
            return false;
        }
        PvParametros other = (PvParametros) object;
        if ((this.parId == null && other.parId != null) || (this.parId != null && !this.parId.equals(other.parId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvParametros[ parId=" + parId + " ]";
    }
    
}
