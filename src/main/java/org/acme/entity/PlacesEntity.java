package org.acme.entity;

import java.util.List;
import java.util.Optional;

import org.acme.core.util.ManipulateUtil;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "places")
public class PlacesEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "gusanta_id_gen")
    @Column(name = "places_id")
    public Long placesId;

    @Column(name = "places_name")
    public String name;

    @Column(name = "image")
    public String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    public LocationEntity locationId;

    public static Optional<PlacesEntity> findPlacesEntityById(Long id) {
        return find("id = ? 1", id).firstResultOptional();
    }

    public static List<PlacesEntity> findAllPlacesEntity() {
        return PlacesEntity.listAll();
    }

    public PlacesEntity updatePlacesEntity(PlacesEntity entity) {
        entity.name = ManipulateUtil.changeItOrNot(name, entity.name);
        entity.image = ManipulateUtil.changeItOrNot(image, entity.image);
        return entity;
    }
}
