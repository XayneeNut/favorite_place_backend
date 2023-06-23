package org.acme.controllers;

import java.util.List;

import org.acme.core.util.CommonStatic;
import org.acme.entity.PlacesEntity;
import org.acme.models.PlacesModel;
import org.acme.service.PlacesHandler;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(CommonStatic.V1 + "/places")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlacesController {

    @Inject
    PlacesHandler placesHandler;

    @GET
    @Path("/get/{id}")
    public PlacesEntity getPlacesEntityById(Long id){
        return placesHandler.getPlacesEntityById(id);
    }

    @GET
    @Path("/get-all")
    public List<PlacesEntity> getAllPlacesEntity(){
        return placesHandler.getAllPlacesEntity();
    } 

    @POST
    @Path("/create")
    @Transactional
    public PlacesEntity createPlacesEntity(PlacesModel placesModel){
        return placesHandler.createPlacesEntity(placesModel);
    }

    @PUT
    @Path("/update")
    @Transactional
    public PlacesEntity updatePlacesEntity(PlacesEntity placesEntity){
        return placesHandler.updatePlacesEntity(placesEntity);
    }

    @DELETE
    @Path("/delete-with-location/{id}")
    @Transactional
    public Response deletePlacesEntityWithLocationById(Long id){
        return placesHandler.deletePlacesEntityWithLocationById(id);
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response deletePlacesEntityById(Long id){
        return placesHandler.deletePlacesEntityById(id);
    }
}
