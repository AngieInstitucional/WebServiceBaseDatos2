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
@Table(name = "PV_CLIENTES")
@NamedQueries({
    @NamedQuery(name = "PvClientes.findAll", query = "SELECT p FROM PvClientes p"),
    @NamedQuery(name = "PvClientes.findByCliId", query = "SELECT p FROM PvClientes p WHERE p.cliId = :cliId"),
    @NamedQuery(name = "PvClientes.findByCliFolio", query = "SELECT p FROM PvClientes p WHERE p.cliFolio = :cliFolio"),
    @NamedQuery(name = "PvClientes.findByCliIdentificacion", query = "SELECT p FROM PvClientes p WHERE p.cliIdentificacion = :cliIdentificacion"),
    @NamedQuery(name = "PvClientes.findByCliTipo", query = "SELECT p FROM PvClientes p WHERE p.cliTipo = :cliTipo"),
    @NamedQuery(name = "PvClientes.findByCliNombre", query = "SELECT p FROM PvClientes p WHERE p.cliNombre = :cliNombre"),
    @NamedQuery(name = "PvClientes.findByCliPApellido", query = "SELECT p FROM PvClientes p WHERE p.cliPApellido = :cliPApellido"),
    @NamedQuery(name = "PvClientes.findByCliSApellido", query = "SELECT p FROM PvClientes p WHERE p.cliSApellido = :cliSApellido"),
    @NamedQuery(name = "PvClientes.findByCliFax", query = "SELECT p FROM PvClientes p WHERE p.cliFax = :cliFax"),
    @NamedQuery(name = "PvClientes.findByCliTelefono", query = "SELECT p FROM PvClientes p WHERE p.cliTelefono = :cliTelefono"),
    @NamedQuery(name = "PvClientes.findByCliEmail", query = "SELECT p FROM PvClientes p WHERE p.cliEmail = :cliEmail"),
    @NamedQuery(name = "PvClientes.findByCliSexo", query = "SELECT p FROM PvClientes p WHERE p.cliSexo = :cliSexo"),
    @NamedQuery(name = "PvClientes.findByCliEstadoCiv", query = "SELECT p FROM PvClientes p WHERE p.cliEstadoCiv = :cliEstadoCiv"),
    @NamedQuery(name = "PvClientes.findByCliPreferencial", query = "SELECT p FROM PvClientes p WHERE p.cliPreferencial = :cliPreferencial"),
    @NamedQuery(name = "PvClientes.findByCliDireccion", query = "SELECT p FROM PvClientes p WHERE p.cliDireccion = :cliDireccion"),
    @NamedQuery(name = "PvClientes.findByCliRecidencia", query = "SELECT p FROM PvClientes p WHERE p.cliRecidencia = :cliRecidencia"),
    @NamedQuery(name = "PvClientes.findByCliNacionalidad", query = "SELECT p FROM PvClientes p WHERE p.cliNacionalidad = :cliNacionalidad"),
    @NamedQuery(name = "PvClientes.findByCliFecRegistro", query = "SELECT p FROM PvClientes p WHERE p.cliFecRegistro = :cliFecRegistro"),
    @NamedQuery(name = "PvClientes.findByCliCredMax", query = "SELECT p FROM PvClientes p WHERE p.cliCredMax = :cliCredMax"),
    @NamedQuery(name = "PvClientes.findByCliNacimiento", query = "SELECT p FROM PvClientes p WHERE p.cliNacimiento = :cliNacimiento"),
    @NamedQuery(name = "PvClientes.findByCliEscolaridad", query = "SELECT p FROM PvClientes p WHERE p.cliEscolaridad = :cliEscolaridad"),
    @NamedQuery(name = "PvClientes.findByCliPuesto", query = "SELECT p FROM PvClientes p WHERE p.cliPuesto = :cliPuesto"),
    @NamedQuery(name = "PvClientes.findByCliEmpresaLabora", query = "SELECT p FROM PvClientes p WHERE p.cliEmpresaLabora = :cliEmpresaLabora"),
    @NamedQuery(name = "PvClientes.findByCliAsegurado", query = "SELECT p FROM PvClientes p WHERE p.cliAsegurado = :cliAsegurado"),
    @NamedQuery(name = "PvClientes.findByCliEstado", query = "SELECT p FROM PvClientes p WHERE p.cliEstado = :cliEstado")})
public class PvClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLI_ID")
    private BigDecimal cliId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "CLI_FOLIO")
    private String cliFolio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "CLI_IDENTIFICACION")
    private String cliIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CLI_TIPO")
    private String cliTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "CLI_NOMBRE")
    private String cliNombre;
    @Size(max = 62)
    @Column(name = "CLI_P_APELLIDO")
    private String cliPApellido;
    @Size(max = 32)
    @Column(name = "CLI_S_APELLIDO")
    private String cliSApellido;
    @Size(max = 24)
    @Column(name = "CLI_FAX")
    private String cliFax;
    @Size(max = 24)
    @Column(name = "CLI_TELEFONO")
    private String cliTelefono;
    @Size(max = 64)
    @Column(name = "CLI_EMAIL")
    private String cliEmail;
    @Column(name = "CLI_SEXO")
    private Character cliSexo;
    @Size(max = 20)
    @Column(name = "CLI_ESTADO_CIV")
    private String cliEstadoCiv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLI_PREFERENCIAL")
    private Character cliPreferencial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CLI_DIRECCION")
    private String cliDireccion;
    @Size(max = 24)
    @Column(name = "CLI_RECIDENCIA")
    private String cliRecidencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "CLI_NACIONALIDAD")
    private String cliNacionalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLI_FEC_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cliFecRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLI_CRED_MAX")
    private double cliCredMax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLI_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cliNacimiento;
    @Size(max = 24)
    @Column(name = "CLI_ESCOLARIDAD")
    private String cliEscolaridad;
    @Size(max = 24)
    @Column(name = "CLI_PUESTO")
    private String cliPuesto;
    @Size(max = 64)
    @Column(name = "CLI_EMPRESA_LABORA")
    private String cliEmpresaLabora;
    @Column(name = "CLI_ASEGURADO")
    private Character cliAsegurado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLI_ESTADO")
    private Character cliEstado;


    public PvClientes() {
    }

    public PvClientes(BigDecimal cliId) {
        this.cliId = cliId;
    }

    public PvClientes(BigDecimal cliId, String cliFolio, String cliIdentificacion, String cliTipo, String cliNombre, Character cliPreferencial, String cliDireccion, String cliNacionalidad, Date cliFecRegistro, double cliCredMax, Date cliNacimiento, Character cliEstado) {
        this.cliId = cliId;
        this.cliFolio = cliFolio;
        this.cliIdentificacion = cliIdentificacion;
        this.cliTipo = cliTipo;
        this.cliNombre = cliNombre;
        this.cliPreferencial = cliPreferencial;
        this.cliDireccion = cliDireccion;
        this.cliNacionalidad = cliNacionalidad;
        this.cliFecRegistro = cliFecRegistro;
        this.cliCredMax = cliCredMax;
        this.cliNacimiento = cliNacimiento;
        this.cliEstado = cliEstado;
    }

    public BigDecimal getCliId() {
        return cliId;
    }

    public void setCliId(BigDecimal cliId) {
        this.cliId = cliId;
    }

    public String getCliFolio() {
        return cliFolio;
    }

    public void setCliFolio(String cliFolio) {
        this.cliFolio = cliFolio;
    }

    public String getCliIdentificacion() {
        return cliIdentificacion;
    }

    public void setCliIdentificacion(String cliIdentificacion) {
        this.cliIdentificacion = cliIdentificacion;
    }

    public String getCliTipo() {
        return cliTipo;
    }

    public void setCliTipo(String cliTipo) {
        this.cliTipo = cliTipo;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliPApellido() {
        return cliPApellido;
    }

    public void setCliPApellido(String cliPApellido) {
        this.cliPApellido = cliPApellido;
    }

    public String getCliSApellido() {
        return cliSApellido;
    }

    public void setCliSApellido(String cliSApellido) {
        this.cliSApellido = cliSApellido;
    }

    public String getCliFax() {
        return cliFax;
    }

    public void setCliFax(String cliFax) {
        this.cliFax = cliFax;
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public Character getCliSexo() {
        return cliSexo;
    }

    public void setCliSexo(Character cliSexo) {
        this.cliSexo = cliSexo;
    }

    public String getCliEstadoCiv() {
        return cliEstadoCiv;
    }

    public void setCliEstadoCiv(String cliEstadoCiv) {
        this.cliEstadoCiv = cliEstadoCiv;
    }

    public Character getCliPreferencial() {
        return cliPreferencial;
    }

    public void setCliPreferencial(Character cliPreferencial) {
        this.cliPreferencial = cliPreferencial;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliRecidencia() {
        return cliRecidencia;
    }

    public void setCliRecidencia(String cliRecidencia) {
        this.cliRecidencia = cliRecidencia;
    }

    public String getCliNacionalidad() {
        return cliNacionalidad;
    }

    public void setCliNacionalidad(String cliNacionalidad) {
        this.cliNacionalidad = cliNacionalidad;
    }

    public Date getCliFecRegistro() {
        return cliFecRegistro;
    }

    public void setCliFecRegistro(Date cliFecRegistro) {
        this.cliFecRegistro = cliFecRegistro;
    }

    public double getCliCredMax() {
        return cliCredMax;
    }

    public void setCliCredMax(double cliCredMax) {
        this.cliCredMax = cliCredMax;
    }

    public Date getCliNacimiento() {
        return cliNacimiento;
    }

    public void setCliNacimiento(Date cliNacimiento) {
        this.cliNacimiento = cliNacimiento;
    }

    public String getCliEscolaridad() {
        return cliEscolaridad;
    }

    public void setCliEscolaridad(String cliEscolaridad) {
        this.cliEscolaridad = cliEscolaridad;
    }

    public String getCliPuesto() {
        return cliPuesto;
    }

    public void setCliPuesto(String cliPuesto) {
        this.cliPuesto = cliPuesto;
    }

    public String getCliEmpresaLabora() {
        return cliEmpresaLabora;
    }

    public void setCliEmpresaLabora(String cliEmpresaLabora) {
        this.cliEmpresaLabora = cliEmpresaLabora;
    }

    public Character getCliAsegurado() {
        return cliAsegurado;
    }

    public void setCliAsegurado(Character cliAsegurado) {
        this.cliAsegurado = cliAsegurado;
    }

    public Character getCliEstado() {
        return cliEstado;
    }

    public void setCliEstado(Character cliEstado) {
        this.cliEstado = cliEstado;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliId != null ? cliId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvClientes)) {
            return false;
        }
        PvClientes other = (PvClientes) object;
        if ((this.cliId == null && other.cliId != null) || (this.cliId != null && !this.cliId.equals(other.cliId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apibd2.apibd2.PvClientes[ cliId=" + cliId + " ]";
    }
    
}
