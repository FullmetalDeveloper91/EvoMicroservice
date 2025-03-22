package ru.fmd.location.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NonNull;

@Entity
public class Location {
    @Id @GeneratedValue
    private int id;
    private String locationName;
    private Double lat;
    private Double lon;

    public Location() {
    }

    public Location(@NonNull String locationName, @NonNull Double lat, @NonNull Double lon) {
        this.locationName = locationName;
        this.lat = lat;
        this.lon = lon;
    }

    public Location(int id, @NonNull String locationName, @NonNull Double lat, @NonNull Double lon) {
        this.id = id;
        this.locationName = locationName;
        this.lat = lat;
        this.lon = lon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NonNull String getLocationName() {
        return locationName;
    }

    public void setLocationName(@NonNull String locationName) {
        this.locationName = locationName;
    }

    public @NonNull Double getLat() {
        return lat;
    }

    public void setLat(@NonNull Double lat) {
        this.lat = lat;
    }

    public @NonNull Double getLon() {
        return lon;
    }

    public void setLon(@NonNull Double lon) {
        this.lon = lon;
    }
}
