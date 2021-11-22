/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apibd2.apibd2.service;

import apibd2.apibd2.PvParametros;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author cordo
 */
@Stateless
@Path("apibd2.apibd2.pvparametros")
public class PvParametrosFacadeREST extends AbstractFacade<PvParametros> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public PvParametrosFacadeREST() {
        super(PvParametros.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(PvParametros entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") BigDecimal id, PvParametros entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") BigDecimal id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public PvParametros find(@PathParam("id") BigDecimal id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PvParametros> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PvParametros> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @GET
    @Path("{nombreUsuario}/{contrasenna}/{nombreRol}/{correo}")
    @Produces({MediaType.TEXT_PLAIN})
    public String createRoles(@PathParam("nombreUsuario") String nombre, @PathParam("contrasenna") String contrasenna,
            @PathParam("nombreRol") String rol,@PathParam("correo") String correo) {

        StoredProcedureQuery procedure = this.em.createNamedStoredProcedureQuery("PROC_Registrar_Usuario");
        procedure.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN).setParameter("nombre", nombre);
        procedure.registerStoredProcedureParameter("contrasenna", String.class, ParameterMode.IN).setParameter("contrasenna",contrasenna);
        procedure.registerStoredProcedureParameter("rol", String.class, ParameterMode.IN).setParameter("rol",rol);
        procedure.registerStoredProcedureParameter("correo", String.class, ParameterMode.IN).setParameter("correo",correo);
        procedure.execute();
        return "Proceso realizado";
    }

}
