package ru.fmd.person.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fmd.person.model.Person;
import ru.fmd.person.model.Weather;
import ru.fmd.person.service.PersonService;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Person> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> findById(@PathVariable int id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person){
        return service.save(person);
    }

    @PutMapping("/{id}")
    public Person update (@PathVariable int id, @RequestBody Person person){
        return service.update(id, person);
    }

    @DeleteMapping("/{id}")
    public Person delete (@PathVariable int id){
        return service.delete(id);
    }

    @GetMapping("/{id}/weather")
    public ResponseEntity<Weather> getWeather(@PathVariable int id){
        return service.getWeather(id);
    }
}
