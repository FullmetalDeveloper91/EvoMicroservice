package ru.fmd.location.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.server.ResponseStatusException;
import ru.fmd.location.model.Location;
import ru.fmd.location.model.Weather;
import ru.fmd.location.repository.LocationRepository;

import java.util.Optional;

@Service
public class LocationService {
    private final String NOT_FOUND_TEMPLATE="City with name %s not found";

    private final LocationRepository repository;
    private final RestTemplate restTemplate;

    @Value("${weather.base_url}")
    private String BASE_URL;

    public LocationService(LocationRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public Iterable<Location> findAll(){
        return repository.findAll();
    }

    public Optional<Location> findByName(String name){
        return repository.findByNameIgnoreCase(name);
    }

    public ResponseEntity<Location> save(Location location) {
        return findByName(location.getName()).isPresent()
                ? new ResponseEntity<>(null, HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(repository.save(location), HttpStatus.CREATED);
    }

    @Transactional
    public Location update(String name, Location location) throws ResponseStatusException  {
        Location oldLocation = repository.findByNameIgnoreCase(name).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_TEMPLATE.formatted(name)));

        oldLocation.setLatitude(location.getLatitude());
        oldLocation.setLongitude(location.getLongitude());

        return repository.save(oldLocation);
    }

    public Location delete(String name) {
        Location location = repository.findByNameIgnoreCase(name).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_TEMPLATE.formatted(name)));

        repository.delete(location);
        return location;
    }

    public Weather getWeatherByCityName(String name){
        var location =  repository.findByNameIgnoreCase(name).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_TEMPLATE.formatted(name)));

        return restTemplate.getForObject("%s?lat=%s&lon=%s"
                .formatted(BASE_URL, location.getLatitude(), location.getLongitude())
            , Weather.class);
    }
}