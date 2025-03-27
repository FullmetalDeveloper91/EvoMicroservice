package ru.fmd.location.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.fmd.location.model.Location;
import ru.fmd.location.model.Weather;
import ru.fmd.location.service.LocationService;

import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationController {
    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Location> findAll(){
        return service.findAll();
    }

    @GetMapping("/{name}")
    public Optional<Location> findByName(@PathVariable String name){
        return service.findByName(name);
    }

    @PostMapping
    public ResponseEntity<Location> save(@RequestBody Location location){
        return service.save(location);
    }

    @PutMapping("/{name}")
    public Location update(@PathVariable String name, @RequestBody Location location) throws ResponseStatusException {
        return service.update(name, location);
    }

    @DeleteMapping("/{name}")
    public Location delete(@PathVariable String name) throws ResponseStatusException {
        return service.delete(name);
    }

    @GetMapping("/weather")
    public Weather redirectRequestWeather(@RequestParam String name){
        return service.getWeatherByCityName(name);
    }
}