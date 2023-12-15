package com.example.facade;

import com.example.entity.Car;

import java.util.List;

public interface JoinFacade {

    List<Car> findAvailableCars(Long id);
    void add(Long parkId, Long carId);
    void remove(Long parkId, Long carId);
}
