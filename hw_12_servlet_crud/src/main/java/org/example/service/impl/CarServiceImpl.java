package org.example.service.impl;

import org.example.dao.CarDao;
import org.example.dao.impl.CarDaoImpl;
import org.example.entity.Car;
import org.example.service.CarService;

import java.util.Collection;
import java.util.Optional;

public class CarServiceImpl implements CarService {

    private final CarDao carDao = new CarDaoImpl();

    @Override
    public void create(Car car) {
        carDao.create(car);
    }

    @Override
    public void update(Car car) {
        carDao.update(car);
    }

    @Override
    public void delete(Long id) {
        carDao.delete(id);
    }

    @Override
    public Optional<Car> findById(Long id) {
        return carDao.findById(id);
    }

    @Override
    public Collection<Car> findAll() {
        return carDao.findAll();
    }
}