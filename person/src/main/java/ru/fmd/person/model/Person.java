package ru.fmd.person.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NonNull;

@Entity
public class Person {
    @Id @GeneratedValue
    private int id;
    private String name;
    private String locationName;

    public Person() {
    }

    public Person(@NonNull String name, @NonNull String locationName) {
        this.name = name;
        this.locationName = locationName;
    }

    public Person(int id, @NonNull String name, @NonNull String locationName) {
        this.id = id;
        this.name = name;
        this.locationName = locationName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NonNull String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public @NonNull String getLocationName() {
        return locationName;
    }

    public void setLocationName(@NonNull String locationName) {
        this.locationName = locationName;
    }
}
