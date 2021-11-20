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
@Table(name = "PV_FACTURAS_COMPRA")
@NamedQueries({
    @NamedQuery(name = "PvFacturasCompra.findAll", query = "SELECT p FROM PvFacturasCompra p"),
    @NamedQuery(name = "PvFacturasCompra.findByFacId", query = "SELECT p FROM PvFacturasCompra p WHERE p.facId = :facId"),
    @NamedQuery(name = "PvFacturasCompra.findByFacMontoTotal", query = "SELECT p FROM PvFacturasCompra p WHERE p.facMontoTotal = :facMontoTotal"),
    @NamedQuery(name = "PvFacturasCompra.findByFacTipo", query = "SELECT p FROM PvFacturasCompra p WHERE p.facTipo = :facTipo"),
    @NamedQuery(name = "PvFacturasCompra.findByFacEstado", query = "SELECT p FROM PvFacturasCompra p WHERE p.facEstado = :facEstado")})
public class PvFacturasCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FAC_ID")
    private BigDecimal facId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FAC_MONTO_TOTAL")
    private double facMontoTotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "FAC_TIPO")
    private String facTipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FAC_ESTADO")
    private Character facEstado;
    @JoinColumn(name = "FAC_EMPRESA", referencedColumnName = "EMP_ID")
    @ManyToOne(optional = false)
    private PvCompania facEmpresa;
    @JoinColumn(name = "FAC_PROVEDOR", referencedColumnName = "PRO_ID")
    @ManyToOne(optional = false)
    private PvProveedores facProvedor;

    public PvFacturasCompra() {
    }

    public PvFacturasCompra(BigDecimal facId) {
        this.facId = facId;
    }

    public PvFacturasCompra(BigDecimal facId, double facMontoTotal, String facTipo, Character facEstado) {
        this.facId = facId;
        this.facMontoTotal = facMontoTotal;
        this.facTipo = facTipo;
        this.facEstado = facEstado;
    }

    public BigDecimal getFacId() {
        return facId;
    }

    public void setFacId(BigDecimal facId) {
        this.facId = facId;
    }

    public double getFacMontoTotal() {
        return facMontoTotal;
    }

    public void setFacMontoTotal(double facMontoTotal) {
        this.facMontoTotal = facMontoTotal;
    }

    public String getFacTipo() {
        return facTipo;
    }

    public void setFacTipo(String facTipo) {
        this.facTipo = facTipo;
    }

    public Character getFacEstado() {
        return facEstado;
    }

    public void setFacEstado(Character facEstado) {
        this.facEstado = facEstado;
    }

    public PvCompania getFacEmpresa() {
        return facEmpresa;
    }

    public void setFacEmpresa(PvCompania facEmpresa) {
        this.facEmpresa = facEmpresa;
    }

    public PvProveedores getFacProvedor() {
        return facProvedor;
    }

    public void setFacProvedor(PvProveedores facProvedor) {
        this.facProvedor = facProvedor;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facId != null ? facId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvFacturasCompra)) {
            return false;
        }
        PvFacturasCompra other = (PvFacturasCompra) object;
        if ((this.facId == null && other.facId != null) || (this.facId != null && !this.facId.equals(other.facId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvFacturasCompra[ facId=" + facId + " ]";
    }
    
}
