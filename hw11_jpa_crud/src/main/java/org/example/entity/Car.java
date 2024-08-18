package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @Column(name = "brand")
    private String carBrand;

    @Column(name = "model")
    private String carModel;

    @Column(name = "age")
    @Min(1900)
    @Max(2023)
    private int carYear;

    @ManyToMany(mappedBy = "cars")
    @ToString.Exclude
    private Set<Park> parks;

    public Car() {
        this.parks = new HashSet<>();
    }
}