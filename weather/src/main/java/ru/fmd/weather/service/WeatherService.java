package ru.fmd.weather.service;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.fmd.weather.model.Coord;
import ru.fmd.weather.model.Main;
import ru.fmd.weather.model.Root;

@Service
@Cacheable(value="roots")
public class WeatherService {
    @Value("${weather.base_url}")
    private String BASE_URL;
    @Value("${weather.app_id}")
    private String appId;
    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Root getWeather(Coord coord) {
        return restTemplate.getForObject(String.format("%s?lat=%f&lon=%f&units=metric&appid=%s",
                        BASE_URL,
                        coord.getLat(),
                        coord.getLon(),
                        appId),
                Root.class);
    }

    public Main getMainWeather(Coord coord) {
        return getWeather(coord).getMain();
    }

    public Main getMainWeather(String lon, String lat) throws BadRequestException {
        try {
            Coord coord = new Coord(Double.parseDouble(lon), Double.parseDouble(lat));
            return getMainWeather(coord);
        }catch (NumberFormatException ex){
            throw new BadRequestException("Coordination must be double type");
        }
    }
}
