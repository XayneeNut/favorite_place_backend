package org.acme.controllers;

import java.util.List;

import org.acme.core.util.CommonStatic;
import org.acme.entity.LocationEntity;
import org.acme.models.LocationModel;
import org.acme.service.LocationHandler;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(CommonStatic.V1 + "/location")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LocationController {

    @Inject
    LocationHandler locationHandler;

    @GET
    @Path("/get/{id}")
    public LocationEntity getLocationEntityById( Long id){
        return locationHandler.getLocationEntityById(id);
    }

    @GET
    @Path("/get-all")
    public List<LocationEntity> getAllLocationEntity(){
        return locationHandler.getAllLocationEntities();
    }

    @POST
    @Path("/create")
    @Transactional
    public LocationEntity createLocationEntity(LocationModel locationModel){
        return locationHandler.createLocationEntity(locationModel);
    }

    @DELETE
    @Path("/delete{id}")
    @Transactional
    public Response deleteLocationEntityById(Long id){
        return locationHandler.deleteLocationEntity(id);
    }
    
}
