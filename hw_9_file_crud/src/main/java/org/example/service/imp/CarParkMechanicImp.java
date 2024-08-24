package org.example.service.imp;

import org.example.dao.CarParkGarage;
import org.example.dao.imp.JsonCarParkGarage;
import org.example.entity.CarPark;
import org.example.service.CarParkMechanic;

import java.util.Collection;

public class CarParkMechanicImp implements CarParkMechanic<CarPark> {

    private final CarParkGarage<CarPark> carParkGarage = new JsonCarParkGarage();

    @Override
    public void create(CarPark carPark) {
        carParkGarage.create(carPark);
    }

    @Override
    public void deleteByCarId(String carId) {
        carParkGarage.deleteByCarId(carId);
    }

    @Override
    public void deleteByParkId(String parkId) {
        carParkGarage.deleteByParkId(parkId);
    }

    @Override
    public void deleteByCarAndParkId(String carId, String parkId) {
        carParkGarage.deleteByCarAndParkId(carId, parkId);
    }

    @Override
    public Collection<CarPark> findByCarId(String id) {
        return carParkGarage.findByCarId(id);
    }

    @Override
    public Collection<CarPark> findByParkId(String id) {
        return carParkGarage.findByParkId(id);
    }

    @Override
    public CarPark findOneByCarId(String id) {
        return carParkGarage.findOneByCarId(id);
    }

    @Override
    public CarPark findOneByParkId(String id) {
        return carParkGarage.findOneByParkId(id);
    }

    @Override
    public CarPark findByCarAndParkId(String carId, String parkId) {
        return carParkGarage.findByCarAndParkId(carId, parkId);
    }
}