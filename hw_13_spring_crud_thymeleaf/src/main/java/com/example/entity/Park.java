package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Cacheable(value = false)
@Table(name = "parks")
public class Park extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "car_parks",
            joinColumns = @JoinColumn(name = "park_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    @ToString.Exclude
    private Set<Car> cars;

    public Park() {
        this.cars = new HashSet<>();
    }
}