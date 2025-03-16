package ru.fmd.location.repository;

import org.springframework.data.repository.CrudRepository;
import ru.fmd.location.model.Location;

public interface LocationRepository extends CrudRepository<Location, Integer> {
}
