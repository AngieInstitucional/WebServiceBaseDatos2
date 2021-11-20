/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apibd2.apibd2.service;

import apibd2.apibd2.PvDetallFacCompra;
import apibd2.apibd2.PvDetallFacCompraPK;
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
@Path("apibd2.apibd2.pvdetallfaccompra")
public class PvDetallFacCompraFacadeREST extends AbstractFacade<PvDetallFacCompra> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    private PvDetallFacCompraPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;detProducto=detProductoValue;detFactura=detFacturaValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        apibd2.apibd2.PvDetallFacCompraPK key = new apibd2.apibd2.PvDetallFacCompraPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> detProducto = map.get("detProducto");
        if (detProducto != null && !detProducto.isEmpty()) {
            key.setDetProducto(new java.math.BigInteger(detProducto.get(0)));
        }
        java.util.List<String> detFactura = map.get("detFactura");
        if (detFactura != null && !detFactura.isEmpty()) {
            key.setDetFactura(new java.math.BigInteger(detFactura.get(0)));
        }
        return key;
    }

    public PvDetallFacCompraFacadeREST() {
        super(PvDetallFacCompra.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(PvDetallFacCompra entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, PvDetallFacCompra entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        apibd2.apibd2.PvDetallFacCompraPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public PvDetallFacCompra find(@PathParam("id") PathSegment id) {
        apibd2.apibd2.PvDetallFacCompraPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PvDetallFacCompra> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PvDetallFacCompra> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
