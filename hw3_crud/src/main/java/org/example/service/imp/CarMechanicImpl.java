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
    public void findOne(String id) {
        carDb.findOne(id);
    }

    @Override
    public void update(String brand, String model, int mileage) {
        carDb.update(brand, model, mileage);
    }

    @Override
    public void delete() {
        carDb.delete();
    }
}
