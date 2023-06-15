package org.acme.models;

import org.acme.entity.LocationEntity;

public record LocationModel(
    Long id,
    double longitude,
    double latitude,
    String formattedAdrres
) {
    public LocationEntity mapLocation(){
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.longitude = longitude;
        locationEntity.latitude = latitude;
        locationEntity.formatedAddress = formattedAdrres;
        return locationEntity;
    }
}
