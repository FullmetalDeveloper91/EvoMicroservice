package ru.fmd.person.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.fmd.person.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
