package ru.fmd.location.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fmd.location.model.Location;
import ru.fmd.location.repository.LocationRepository;

import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationController {
    private final LocationRepository repository;

    public LocationController(LocationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Location> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Location> findById(@PathVariable int id){
        return repository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Location> save(@RequestBody Location location){
        return repository.findById(location.getId()).isPresent()
                ? new ResponseEntity<>(repository.findById(location.getId()).get(), HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(repository.save(location), HttpStatus.CREATED);
    }

}
