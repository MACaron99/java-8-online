package org.example.service;

import org.example.entity.CarPark;

import java.util.Collection;

public interface CarParkMechanic<E extends CarPark> {

    void create(E e);
    void deleteByCarId(String carId);
    void deleteByParkId(String parkId);
    void deleteByCarAndParkId(String carId, String parkId);
    Collection<E> findByCarId(String id);
    Collection<E> findByParkId(String id);
    E findOneByCarId(String id);
    E findOneByParkId(String id);
    E findByCarAndParkId(String carId, String parkId);
}
