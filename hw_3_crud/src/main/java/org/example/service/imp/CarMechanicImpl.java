package org.example.service.imp;

import org.example.db.CarDb;
import org.example.entity.Car;
import org.example.service.CarMechanic;

public class CarMechanicImpl implements CarMechanic {

    private final CarDb carDb = new CarDb();

    @Override
    public void create(Car car) {
        carDb.create(car);
    }

    @Override
    public Car[] findAll() {
        return carDb.findAll();
    }

    @Override
    public Car findById(String id) {
        return carDb.findById(id);
    }

    @Override
    public void update(Car car) {
        carDb.update(car);
    }

    @Override
    public void delete(Car car) {
        carDb.delete(car);
    }
}
