package org.acme.entity;



import java.util.List;
import java.util.Optional;

import org.acme.core.util.ManipulateUtil;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "location")
public class LocationEntity extends PanacheEntityBase{
    
    @Id
    @GeneratedValue(generator = "gusanta_id_gen")
    @Column(name = "location_id")
    public Long locationId;

    @Column(name = "longitude")
    public double longitude;

    @Column(name = "latitude")
    public double latitude;

    @Column(name = "formatedAddress")
    public String formattedAddress;

    public static Optional<LocationEntity> findLocationEntityById(long id){
        return find("id = ? 1", id).firstResultOptional();
    }

    public static List<LocationEntity> findAllLocationEntities (){
        return LocationEntity.listAll();
    }

    public LocationEntity updateLocationEntity(LocationEntity locationEntity){
        locationEntity.latitude = ManipulateUtil.changeItOrNot(latitude, locationEntity.latitude);
        locationEntity.longitude = ManipulateUtil.changeItOrNot(longitude, locationEntity.longitude);
        locationEntity.formattedAddress = ManipulateUtil.changeItOrNot(formattedAddress, locationEntity.formattedAddress);
        return locationEntity;
    }
}
