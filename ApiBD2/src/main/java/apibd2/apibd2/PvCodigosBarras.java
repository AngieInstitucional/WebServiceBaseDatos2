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
@Table(name = "PV_CODIGOS_BARRAS")
@NamedQueries({
    @NamedQuery(name = "PvCodigosBarras.findAll", query = "SELECT p FROM PvCodigosBarras p"),
    @NamedQuery(name = "PvCodigosBarras.findByCodId", query = "SELECT p FROM PvCodigosBarras p WHERE p.codId = :codId"),
    @NamedQuery(name = "PvCodigosBarras.findByCodCodigo", query = "SELECT p FROM PvCodigosBarras p WHERE p.codCodigo = :codCodigo"),
    @NamedQuery(name = "PvCodigosBarras.findByCodActivo", query = "SELECT p FROM PvCodigosBarras p WHERE p.codActivo = :codActivo")})
public class PvCodigosBarras implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ID")
    private BigDecimal codId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "COD_CODIGO")
    private String codCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ACTIVO")
    private Character codActivo;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "PRO_ID")
    @ManyToOne(optional = false)
    private PvProductos codProducto;

    public PvCodigosBarras() {
    }

    public PvCodigosBarras(BigDecimal codId) {
        this.codId = codId;
    }

    public PvCodigosBarras(BigDecimal codId, String codCodigo, Character codActivo) {
        this.codId = codId;
        this.codCodigo = codCodigo;
        this.codActivo = codActivo;
    }

    public BigDecimal getCodId() {
        return codId;
    }

    public void setCodId(BigDecimal codId) {
        this.codId = codId;
    }

    public String getCodCodigo() {
        return codCodigo;
    }

    public void setCodCodigo(String codCodigo) {
        this.codCodigo = codCodigo;
    }

    public Character getCodActivo() {
        return codActivo;
    }

    public void setCodActivo(Character codActivo) {
        this.codActivo = codActivo;
    }

    public PvProductos getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(PvProductos codProducto) {
        this.codProducto = codProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codId != null ? codId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvCodigosBarras)) {
            return false;
        }
        PvCodigosBarras other = (PvCodigosBarras) object;
        if ((this.codId == null && other.codId != null) || (this.codId != null && !this.codId.equals(other.codId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvCodigosBarras[ codId=" + codId + " ]";
    }
    
}
