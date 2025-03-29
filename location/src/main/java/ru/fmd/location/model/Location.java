package ru.fmd.location.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Location {
    private Double longitude;
    private Double latitude;
    @Id
    private String name;

    public Location() {
    }

    public Location(Double longitude, Double latitude, String name) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
