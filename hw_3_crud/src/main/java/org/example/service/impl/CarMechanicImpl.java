package org.example.service.impl;

import org.example.db.CarDb;
import org.example.entity.Car;
import org.example.service.CarMechanic;

import java.io.IOException;

public class CarMechanicImpl implements CarMechanic {

    private CarDb carDb = new CarDb();

    @Override
    public void create(Car car) {
        carDb.create(car);
    }

    @Override
    public Car[] findAll() {
        return carDb.findAll();
    }

    @Override
    public Car findOne(String id) throws IOException{
        return carDb.findOne(id);
    }

    @Override
    public Car update(String brand, String model, int mileage) throws IOException {
        return carDb.update(brand, model, mileage);
    }

    @Override
    public Car[] delete() throws IOException{
        return carDb.delete();
    }
}