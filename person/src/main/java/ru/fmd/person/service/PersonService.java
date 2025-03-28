package ru.fmd.person.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import ru.fmd.person.model.Person;
import ru.fmd.person.model.Weather;
import ru.fmd.person.repository.PersonRepository;

import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository repository;
    private final RestTemplate restTemplate;

    @Value("${location.weather.base_url}")
    private String BASE_URL;

    public PersonService(PersonRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Weather> getWeather(int id){
        if(repository.existsById(id)){
            String location = repository.findById(id).get().getLocation();
            Weather weather = restTemplate.getForObject(
                    "%s?name=%s".formatted(BASE_URL, location), Weather.class);
            return new ResponseEntity<>(weather, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public Iterable<Person> findAll() {
        return repository.findAll();
    }

    public Optional<Person> findById(int id) {
        return repository.findById(id);
    }

    public ResponseEntity<Person> save(Person person) {
        return repository.findById(person.getId()).isPresent()
                ? new ResponseEntity<>(repository.findById(person.getId()).get(), HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(repository.save(person), HttpStatus.CREATED);
    }

    @Transactional
    public Person update(int id, Person person) {
        Person oldPerson = repository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));

        oldPerson.setFirstname(person.getFirstname());
        oldPerson.setSurname(person.getSurname());
        oldPerson.setLastname(person.getLastname());
        oldPerson.setBirthday(person.getBirthday());
        oldPerson.setLocation(person.getLocation());

        return repository.save(oldPerson);
    }

    public Person delete(int id) {
        Person person = repository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));

        repository.delete(person);
        return person;
    }
}
