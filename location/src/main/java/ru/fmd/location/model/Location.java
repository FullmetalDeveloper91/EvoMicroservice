package ru.fmd.location.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Location {
    @Id @GeneratedValue
    private int id;
    @NonNull private String locationName;
    @NonNull private double lat;
    @NonNull private double lon;

    public Location(@NonNull String locationName, @NonNull double lat, @NonNull double lon) {
        this.locationName = locationName;
        this.lat = lat;
        this.lon = lon;
    }
}
