package ru.fmd.weather.model;

public class WeatherResponseDTO {
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

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public int getSea_level() {
        return sea_level;
    }

    public void setSea_level(int sea_level) {
        this.sea_level = sea_level;
    }

    public int getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(int grnd_level) {
        this.grnd_level = grnd_level;
    }
}