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
@Table(name = "PV_DESCUENTOS")
@NamedQueries({
    @NamedQuery(name = "PvDescuentos.findAll", query = "SELECT p FROM PvDescuentos p"),
    @NamedQuery(name = "PvDescuentos.findByDecId", query = "SELECT p FROM PvDescuentos p WHERE p.decId = :decId"),
    @NamedQuery(name = "PvDescuentos.findByDecTipo", query = "SELECT p FROM PvDescuentos p WHERE p.decTipo = :decTipo"),
    @NamedQuery(name = "PvDescuentos.findByDecPorcDesc", query = "SELECT p FROM PvDescuentos p WHERE p.decPorcDesc = :decPorcDesc"),
    @NamedQuery(name = "PvDescuentos.findByDecVigenciaDesde", query = "SELECT p FROM PvDescuentos p WHERE p.decVigenciaDesde = :decVigenciaDesde"),
    @NamedQuery(name = "PvDescuentos.findByDecVigenciaHasta", query = "SELECT p FROM PvDescuentos p WHERE p.decVigenciaHasta = :decVigenciaHasta"),
    @NamedQuery(name = "PvDescuentos.findByDecEstado", query = "SELECT p FROM PvDescuentos p WHERE p.decEstado = :decEstado"),
    @NamedQuery(name = "PvDescuentos.findByDecIngreso", query = "SELECT p FROM PvDescuentos p WHERE p.decIngreso = :decIngreso"),
    @NamedQuery(name = "PvDescuentos.findByDecVencimiento", query = "SELECT p FROM PvDescuentos p WHERE p.decVencimiento = :decVencimiento")})
public class PvDescuentos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEC_ID")
    private BigDecimal decId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "DEC_TIPO")
    private String decTipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEC_PORC_DESC")
    private double decPorcDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEC_VIGENCIA_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date decVigenciaDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEC_VIGENCIA_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date decVigenciaHasta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEC_ESTADO")
    private Character decEstado;
    @Column(name = "DEC_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date decIngreso;
    @Column(name = "DEC_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date decVencimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pvDescuentos")
    private Collection<PvDescLiquidacion> pvDescLiquidacionCollection;
    @JoinColumn(name = "DEC_FAMILIA", referencedColumnName = "FAM_ID")
    @ManyToOne
    private PvFamilias decFamilia;
    @JoinColumn(name = "DEC_PROVEEDOR", referencedColumnName = "PRO_ID")
    @ManyToOne
    private PvProveedores decProveedor;
    @JoinColumn(name = "DEC_SEDE", referencedColumnName = "SED_ID")
    @ManyToOne(optional = false)
    private PvSedes decSede;

    public PvDescuentos() {
    }

    public PvDescuentos(BigDecimal decId) {
        this.decId = decId;
    }

    public PvDescuentos(BigDecimal decId, String decTipo, double decPorcDesc, Date decVigenciaDesde, Date decVigenciaHasta, Character decEstado) {
        this.decId = decId;
        this.decTipo = decTipo;
        this.decPorcDesc = decPorcDesc;
        this.decVigenciaDesde = decVigenciaDesde;
        this.decVigenciaHasta = decVigenciaHasta;
        this.decEstado = decEstado;
    }

    public BigDecimal getDecId() {
        return decId;
    }

    public void setDecId(BigDecimal decId) {
        this.decId = decId;
    }

    public String getDecTipo() {
        return decTipo;
    }

    public void setDecTipo(String decTipo) {
        this.decTipo = decTipo;
    }

    public double getDecPorcDesc() {
        return decPorcDesc;
    }

    public void setDecPorcDesc(double decPorcDesc) {
        this.decPorcDesc = decPorcDesc;
    }

    public Date getDecVigenciaDesde() {
        return decVigenciaDesde;
    }

    public void setDecVigenciaDesde(Date decVigenciaDesde) {
        this.decVigenciaDesde = decVigenciaDesde;
    }

    public Date getDecVigenciaHasta() {
        return decVigenciaHasta;
    }

    public void setDecVigenciaHasta(Date decVigenciaHasta) {
        this.decVigenciaHasta = decVigenciaHasta;
    }

    public Character getDecEstado() {
        return decEstado;
    }

    public void setDecEstado(Character decEstado) {
        this.decEstado = decEstado;
    }

    public Date getDecIngreso() {
        return decIngreso;
    }

    public void setDecIngreso(Date decIngreso) {
        this.decIngreso = decIngreso;
    }

    public Date getDecVencimiento() {
        return decVencimiento;
    }

    public void setDecVencimiento(Date decVencimiento) {
        this.decVencimiento = decVencimiento;
    }

    public Collection<PvDescLiquidacion> getPvDescLiquidacionCollection() {
        return pvDescLiquidacionCollection;
    }

    public void setPvDescLiquidacionCollection(Collection<PvDescLiquidacion> pvDescLiquidacionCollection) {
        this.pvDescLiquidacionCollection = pvDescLiquidacionCollection;
    }

    public PvFamilias getDecFamilia() {
        return decFamilia;
    }

    public void setDecFamilia(PvFamilias decFamilia) {
        this.decFamilia = decFamilia;
    }

    public PvProveedores getDecProveedor() {
        return decProveedor;
    }

    public void setDecProveedor(PvProveedores decProveedor) {
        this.decProveedor = decProveedor;
    }

    public PvSedes getDecSede() {
        return decSede;
    }

    public void setDecSede(PvSedes decSede) {
        this.decSede = decSede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (decId != null ? decId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvDescuentos)) {
            return false;
        }
        PvDescuentos other = (PvDescuentos) object;
        if ((this.decId == null && other.decId != null) || (this.decId != null && !this.decId.equals(other.decId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvDescuentos[ decId=" + decId + " ]";
    }
    
}
