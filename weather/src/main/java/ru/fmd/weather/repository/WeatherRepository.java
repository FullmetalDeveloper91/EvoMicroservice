package ru.fmd.weather.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.fmd.weather.model.Weather;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Integer> {
}
