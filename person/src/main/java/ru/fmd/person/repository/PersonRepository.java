package ru.fmd.person.repository;

import org.springframework.data.repository.CrudRepository;
import ru.fmd.person.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
