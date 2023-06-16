package org.acme.models;

import org.acme.entity.PlacesEntity;

public record PlacesModel(
    Long placesId,
    String name,
    String image,
    Long locationId
) {
    public PlacesEntity mapPlacesModel(){
        var placesEntity = new PlacesEntity();
        placesEntity.name = name;
        placesEntity.image = image;
        return placesEntity;
    }
}
