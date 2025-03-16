package ru.fmd.person.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fmd.person.model.Person;
import ru.fmd.person.repository.PersonRepository;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Person> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> findById(@PathVariable int id){
        return repository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person){
        return repository.findById(person.getId()).isPresent()
                ? new ResponseEntity<>(repository.findById(person.getId()).get(), HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(repository.save(person), HttpStatus.CREATED);
    }
}
