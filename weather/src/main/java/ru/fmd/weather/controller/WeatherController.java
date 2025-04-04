package ru.fmd.weather.controller;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import ru.fmd.weather.model.Main;
import ru.fmd.weather.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService service;

    @Autowired
    ApplicationContext context;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

   @GetMapping
    public Main getWeather(@RequestParam String lon, @RequestParam String lat) throws BadRequestException {
        return service.getMainWeather(lon,lat);
   }
}
