package org.example.service.impl;

import org.example.db.CarDb;
import org.example.entity.Car;
import org.example.service.CarMechanic;

public class CarMechanicImpl implements CarMechanic {

    private CarDb carDb = new CarDb();

    @Override
    public void create(Car car) {
        carDb.create(car);
        System.out.println("CarMechanicImpl.create");
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
        return carDb.findAll();
    }
}