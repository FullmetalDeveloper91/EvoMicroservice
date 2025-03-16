package ru.fmd.weather.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WeatherResponseDTO {
    private Double lat;
    private Double lon;
    private Double temp;
    private Double feels_like;
    private Double temp_min;
    private Double temp_max;
    private Double pressure;
    private Double humidity;
    private Integer sea_level;
    private Integer grnd_level;

    public WeatherResponseDTO(Weather weather) {
        this.temp = weather.getTemp();
        this.feels_like = weather.getFeels_like();
        this.temp_min = weather.getTemp_min();
        this.temp_max = weather.getTemp_max();
        this.pressure = weather.getPressure();
        this.humidity = weather.getHumidity();
        this.sea_level = weather.getSea_level();
        this.grnd_level = weather.getGrnd_level();
    }
}