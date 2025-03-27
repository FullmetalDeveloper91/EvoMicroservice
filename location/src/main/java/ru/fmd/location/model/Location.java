package ru.fmd.location.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @NonNull private Double longitude;
    @NonNull private Double latitude;
    @Id
    @NonNull private String name;
}
