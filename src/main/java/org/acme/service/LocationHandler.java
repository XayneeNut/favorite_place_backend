package org.acme.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.acme.entity.LocationEntity;
import org.acme.exception.response.MessageResponse;
import org.acme.models.LocationModel;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class LocationHandler {

    public LocationEntity getLocationEntityById(Long id) {
        return LocationEntity.findLocationEntityById(id).orElseThrow(() -> MessageResponse.idNotFoundException(id));
    }

    public List<LocationEntity> getAllLocationEntities() {
        return LocationEntity.findAllLocationEntities().stream().collect(Collectors.toList());
    }

    public LocationEntity updateLocationEntity(LocationEntity entity) {
        var validatingId = getLocationEntityById(entity.locationId);
        entity.updateLocationEntity(validatingId);
        return validatingId;
    }

    public LocationEntity createLocationEntity(LocationModel locationModel) {
        Objects.requireNonNull(locationModel);
        var location = locationModel.mapLocation();
        location.persist();
        return location;
    }

    public Response deleteLocationEntity(Long id) {
        if (getLocationEntityById(id) != null) {
            LocationEntity.deleteById(id);
            return MessageResponse.deleteSucces(id);
        } else {
            return MessageResponse.idNotFound(id);
        }
    }
}
