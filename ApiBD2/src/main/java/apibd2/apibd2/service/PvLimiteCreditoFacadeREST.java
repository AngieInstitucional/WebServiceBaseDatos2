/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apibd2.apibd2.service;

import apibd2.apibd2.PvLimiteCredito;
import apibd2.apibd2.PvLimiteCreditoPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author cordo
 */
@Stateless
@Path("apibd2.apibd2.pvlimitecredito")
public class PvLimiteCreditoFacadeREST extends AbstractFacade<PvLimiteCredito> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    private PvLimiteCreditoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;limEmpresa=limEmpresaValue;limProveedor=limProveedorValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        apibd2.apibd2.PvLimiteCreditoPK key = new apibd2.apibd2.PvLimiteCreditoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> limEmpresa = map.get("limEmpresa");
        if (limEmpresa != null && !limEmpresa.isEmpty()) {
            key.setLimEmpresa(new java.math.BigInteger(limEmpresa.get(0)));
        }
        java.util.List<String> limProveedor = map.get("limProveedor");
        if (limProveedor != null && !limProveedor.isEmpty()) {
            key.setLimProveedor(new java.math.BigInteger(limProveedor.get(0)));
        }
        return key;
    }

    public PvLimiteCreditoFacadeREST() {
        super(PvLimiteCredito.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(PvLimiteCredito entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, PvLimiteCredito entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        apibd2.apibd2.PvLimiteCreditoPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public PvLimiteCredito find(@PathParam("id") PathSegment id) {
        apibd2.apibd2.PvLimiteCreditoPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PvLimiteCredito> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PvLimiteCredito> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
}
