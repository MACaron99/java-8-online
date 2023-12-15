package com.example.service;

import com.example.entity.Car;

import java.util.Collection;

public interface CarService extends BaseService<Car>, DataTableService<Car> {

    Collection<Car> findAll();
}
