package org.acme.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.acme.entity.LocationEntity;
import org.acme.entity.PlacesEntity;
import org.acme.exception.response.MessageResponse;
import org.acme.models.PlacesModel;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class PlacesHandler {

    public PlacesEntity getPlacesEntityById(Long id) {
        return PlacesEntity.findPlacesEntityById(id).orElseThrow(() -> MessageResponse.idNotFoundException(id));
    }

    public List<PlacesEntity> getAllPlacesEntity() {
        return PlacesEntity.findAllPlacesEntity().stream().collect(Collectors.toList());
    }

    public LocationEntity fetchLocationEntity(Long id) {
        return LocationEntity.findLocationEntityById(id)
                .orElseThrow(() -> MessageResponse.fetchMessageException(id, "LocationEntity"));
    }

    private PlacesEntity checkingWithCreate(PlacesModel placesModel, LocationEntity locationEntity) {
        var placesMap = placesModel.mapPlacesModel();
        placesMap.locationEntityId = locationEntity;
        return placesMap;
    }

    public PlacesEntity createPlacesEntity(PlacesModel placesModel) {
        Objects.requireNonNull(placesModel);
        var location = fetchLocationEntity(placesModel.locationId());
        return checkingWithCreate(placesModel, location);
    }

    private PlacesEntity checkingWithUpdate(PlacesEntity entity, LocationEntity locationEntity) {
        var placesList = getPlacesEntityById(entity.placesId);
        placesList.locationEntityId = locationEntity;
        entity.updatePlacesEntity(placesList);
        return placesList;
    }

    public PlacesEntity updatePlacesEntity(PlacesEntity entity) {
        var location = fetchLocationEntity(entity.locationEntityId.locationId);
        return checkingWithUpdate(entity, location);
    }

    public Response deletePlacesEntityById(Long id) {
        if (getPlacesEntityById(id) != null) {
            PlacesEntity.deleteById(id);
            return MessageResponse.deleteSucces(id);
        }
        return MessageResponse.idNotFound(id);
    }

}
