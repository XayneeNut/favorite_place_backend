package org.acme.entity;

import java.util.List;
import java.util.Optional;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "places")
public class PlacesEntity extends PanacheEntityBase{

    @Id
    @NotNull
    @GeneratedValue(generator = "gusanta_id_gen")
    @Column(name = "places_id")
    public Long id;

    @Column(name = "places_name")
    public String name;

    @Column(name = "image")
    public String image;
    
    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "location_id")
    public LocationEntity locationEntityId;

    public static Optional<PlacesEntity> findPlacesEntityById(Long id){
        return find("id = ? 1", id).firstResultOptional();
    }

    public static List<PlacesEntity> findAllPlacesEntity(){
        return PlacesEntity.listAll();
    }
    
}
