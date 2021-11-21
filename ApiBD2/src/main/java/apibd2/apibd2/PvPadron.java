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
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cordo
 */
@Entity
@Table(name = "PV_PADRON")
@NamedQueries({
    @NamedQuery(name = "PvPadron.findAll", query = "SELECT p FROM PvPadron p"),
    @NamedQuery(name = "PvPadron.findByPadId", query = "SELECT p FROM PvPadron p WHERE p.padId = :padId"),
    @NamedQuery(name = "PvPadron.findByPadNombre", query = "SELECT p FROM PvPadron p WHERE p.padNombre = :padNombre"),
    @NamedQuery(name = "PvPadron.findByPadApellidos1", query = "SELECT p FROM PvPadron p WHERE p.padApellidos1 = :padApellidos1"),
    @NamedQuery(name = "PvPadron.findByPadApellidos2", query = "SELECT p FROM PvPadron p WHERE p.padApellidos2 = :padApellidos2"),
    @NamedQuery(name = "PvPadron.findByPadCedula", query = "SELECT p FROM PvPadron p WHERE p.padCedula = :padCedula"),
    @NamedQuery(name = "PvPadron.count", query = "SELECT COUNT(p) FROM PvPadron p")})

@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
        name="READ_FILE",
        procedureName="READ_FILE",
        parameters={}
    )
})
public class PvPadron implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAD_ID")
    private BigDecimal padId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "PAD_NOMBRE")
    private String padNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "PAD_APELLIDOS1")
    private String padApellidos1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "PAD_APELLIDOS2")
    private String padApellidos2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "PAD_CEDULA")
    private String padCedula;

    public PvPadron() {
    }

    public PvPadron(BigDecimal padId) {
        this.padId = padId;
    }

    public PvPadron(BigDecimal padId, String padNombre, String padApellidos1, String padApellidos2, String padCedula) {
        this.padId = padId;
        this.padNombre = padNombre;
        this.padApellidos1 = padApellidos1;
        this.padApellidos2 = padApellidos2;
        this.padCedula = padCedula;
    }

    public BigDecimal getPadId() {
        return padId;
    }

    public void setPadId(BigDecimal padId) {
        this.padId = padId;
    }

    public String getPadNombre() {
        return padNombre;
    }

    public void setPadNombre(String padNombre) {
        this.padNombre = padNombre;
    }

    public String getPadApellidos1() {
        return padApellidos1;
    }

    public void setPadApellidos1(String padApellidos1) {
        this.padApellidos1 = padApellidos1;
    }

    public String getPadApellidos2() {
        return padApellidos2;
    }

    public void setPadApellidos2(String padApellidos2) {
        this.padApellidos2 = padApellidos2;
    }

    public String getPadCedula() {
        return padCedula;
    }

    public void setPadCedula(String padCedula) {
        this.padCedula = padCedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (padId != null ? padId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvPadron)) {
            return false;
        }
        PvPadron other = (PvPadron) object;
        if ((this.padId == null && other.padId != null) || (this.padId != null && !this.padId.equals(other.padId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvPadron[ padId=" + padId + " ]";
    }
    
}
