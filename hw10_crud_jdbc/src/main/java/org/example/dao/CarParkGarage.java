package org.example.dao;

import org.example.entity.CarPark;

import java.util.Collection;

public interface CarParkGarage<E extends CarPark> {

    void create(E e);
    void deleteByCarId(Long carId);
    void deleteByParkId(Long parkId);
    void deleteByCarAndParkId(Long carId, Long parkId);
    Collection<E> findByCarId(Long id);
    Collection<E> findByParkId(Long id);
    E findOneByCarId(Long id);
    E findOneByParkId(Long id);
    E findByCarAndParkId(Long carId, Long parkId);
}
