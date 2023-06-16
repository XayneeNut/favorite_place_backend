package org.acme.models;

import org.acme.entity.LocationEntity;

public record LocationModel(
    Long id,
    double longitude,
    double latitude,
    String formattedAddress
) {
    public LocationEntity mapLocation(){
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.longitude = longitude;
        locationEntity.latitude = latitude;
        locationEntity.formattedAddress = formattedAddress;
        return locationEntity;
    }
}
