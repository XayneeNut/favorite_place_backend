package org.acme.entity;



import java.util.List;
import java.util.Optional;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;
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
    @NotNull
    @Column(name = "location_id")
    public Long locationId;

    @NotNull
    @Column(name = "longitude")
    public double longitude;

    @NotNull
    @Column(name = "latitude")
    public double latitude;

    @Column(name = "formatedAddress")
    public String formatedAddress;

    public static Optional<LocationEntity> findLocationEntityById(long id){
        return find("id = ? 1", id).firstResultOptional();
    }

    public static List<LocationEntity> findAllLocationEntities (){
        return LocationEntity.listAll();
    }
}
