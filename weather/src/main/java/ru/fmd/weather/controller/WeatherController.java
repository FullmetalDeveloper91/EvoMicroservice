package ru.fmd.weather.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fmd.weather.model.Weather;
import ru.fmd.weather.model.WeatherResponseDTO;
import ru.fmd.weather.repository.WeatherRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherRepository repository;

    public WeatherController(WeatherRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<WeatherResponseDTO> findAll(){
        List<WeatherResponseDTO> weatherList = new ArrayList<>();
        repository.findAll().forEach(weather -> weatherList.add(new WeatherResponseDTO(weather)));
        return weatherList;
    }

    @GetMapping("/{id}")
    public Optional<WeatherResponseDTO> findById(@PathVariable int id){
        return repository.findById(id).stream().map(WeatherResponseDTO::new).findFirst();
    }

    @PostMapping
    public ResponseEntity<Weather> save (@RequestBody Weather weather){
        return repository.findById(weather.getId()).isPresent()
                ? new ResponseEntity<>(repository.findById(weather.getId()).get(), HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(repository.save(weather), HttpStatus.CREATED);
    }
}
