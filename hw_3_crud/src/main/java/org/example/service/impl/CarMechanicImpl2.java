package org.example.service.impl;

import org.example.entity.Car;
import org.example.service.CarMechanic;

public class CarMechanicImpl2 implements CarMechanic {

    @Override
    public void create(Car car) {
        System.out.println("CarMechanicImpl2.create");
    }

    @Override
    public void update(Car car) {}

    @Override
    public void delete(String id) {}

    @Override
    public Car findOne(String id) {
        return null;
    }

    @Override
    public Car[] findAll() {
        return new Car[0];
    }
}