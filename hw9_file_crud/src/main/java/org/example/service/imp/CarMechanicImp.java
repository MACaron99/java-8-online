package org.example.service.imp;

import org.example.dao.CarGarage;
import org.example.dao.imp.JsonCarGarage;
import org.example.entity.Car;
import org.example.service.CarMechanic;

import java.util.Collection;

public class CarMechanicImp implements CarMechanic {

    private final CarGarage carGarage = new JsonCarGarage();

    @Override
    public void create(Car car) {
        carGarage.create(car);
    }

    @Override
    public void update(Car car) {
        carGarage.update(car);
    }

    @Override
    public void delete(String id) {
        carGarage.delete(id);
    }

    @Override
    public boolean exists(String id) {
        return carGarage.exists(id);
    }

    @Override
    public Collection<Car> findAll() {
        return carGarage.findAll();
    }

    @Override
    public Collection<Car> findMany(String[] ids) {
        return carGarage.findMany(ids);
    }
}