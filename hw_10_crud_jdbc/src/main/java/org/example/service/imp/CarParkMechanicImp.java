package org.example.service.imp;

import org.example.dao.CarParkGarage;
import org.example.dao.imp.CarParkGarageImp;
import org.example.entity.CarPark;
import org.example.service.CarParkMechanic;

import java.util.Collection;

public class CarParkMechanicImp implements CarParkMechanic<CarPark> {

    private final CarParkGarage<CarPark> carParkGarage = new CarParkGarageImp();

    @Override
    public void create(CarPark carPark) {
        carParkGarage.create(carPark);
    }

    @Override
    public void deleteByCarId(Long carId) {
        carParkGarage.deleteByCarId(carId);
    }

    @Override
    public void deleteByParkId(Long parkId) {
        carParkGarage.deleteByParkId(parkId);
    }

    @Override
    public void deleteByCarAndParkId(Long carId, Long parkId) {
        carParkGarage.deleteByCarAndParkId(carId, parkId);
    }

    @Override
    public Collection<CarPark> findByCarId(Long id) {
        return carParkGarage.findByCarId(id);
    }

    @Override
    public Collection<CarPark> findByParkId(Long id) {
        return carParkGarage.findByParkId(id);
    }

    @Override
    public CarPark findOneByCarId(Long id) {
        return carParkGarage.findOneByCarId(id);
    }

    @Override
    public CarPark findOneByParkId(Long id) {
        return carParkGarage.findOneByParkId(id);
    }

    @Override
    public CarPark findByCarAndParkId(Long carId, Long parkId) {
        return carParkGarage.findByCarAndParkId(carId, parkId);
    }
}