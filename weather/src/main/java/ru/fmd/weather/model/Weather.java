package ru.fmd.weather.model;

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
public class Weather {
    @Id @GeneratedValue
    private int id;
    @NonNull private Double lat;
    @NonNull private Double lon;
    @NonNull private Double temp;
    @NonNull private Double feels_like;
    @NonNull private Double temp_min;
    @NonNull private Double temp_max;
    @NonNull private Double pressure;
    @NonNull private Double humidity;
    @NonNull private Integer sea_level;
    @NonNull private Integer grnd_level;
}
