package ru.fmd.weather.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NonNull;

@Entity
public class Weather {
    @Id @GeneratedValue
    private int id;
    private double lat;
    private double lon;
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private double pressure;
    private double humidity;
    private int sea_level;
    private int grnd_level;

    public Weather() {
    }

    public Weather(
            double lat,
            double lon,
            double temp,
            double feels_like,
            double temp_min,
            double temp_max,
            double pressure,
            double humidity,
            int sea_level,
            int grnd_level
    ) {
        this.lat = lat;
        this.lon = lon;
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.humidity = humidity;
        this.sea_level = sea_level;
        this.grnd_level = grnd_level;
    }

    public Weather(
            int id,
            double lat,
            double lon,
            double temp,
            double feels_like,
            double temp_min,
            double temp_max,
            double pressure,
            double humidity,
            int sea_level,
            int grnd_level
    ) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.humidity = humidity;
        this.sea_level = sea_level;
        this.grnd_level = grnd_level;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public @NonNull Double getTemp() {
        return temp;
    }

    public void setTemp(@NonNull Double temp) {
        this.temp = temp;
    }

    public @NonNull Double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(@NonNull Double feels_like) {
        this.feels_like = feels_like;
    }

    public @NonNull Double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(@NonNull Double temp_min) {
        this.temp_min = temp_min;
    }

    public @NonNull Double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(@NonNull Double temp_max) {
        this.temp_max = temp_max;
    }

    public @NonNull Double getPressure() {
        return pressure;
    }

    public void setPressure(@NonNull Double pressure) {
        this.pressure = pressure;
    }

    public @NonNull Double getHumidity() {
        return humidity;
    }

    public void setHumidity(@NonNull Double humidity) {
        this.humidity = humidity;
    }

    public @NonNull Integer getSea_level() {
        return sea_level;
    }

    public void setSea_level(@NonNull Integer sea_level) {
        this.sea_level = sea_level;
    }

    public @NonNull Integer getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(@NonNull Integer grnd_level) {
        this.grnd_level = grnd_level;
    }
}