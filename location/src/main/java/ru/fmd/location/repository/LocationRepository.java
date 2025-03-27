package ru.fmd.location.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ru.fmd.location.model.Location;

import java.util.Optional;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {
    Optional<Location> findByNameIgnoreCase(@NonNull String name);
}
