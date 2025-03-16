package ru.fmd.location.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.fmd.location.model.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {
}
