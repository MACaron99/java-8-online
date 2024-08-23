package com.example.facade.impl;

import com.example.entity.Car;
import com.example.entity.Park;
import com.example.facade.JoinFacade;
import com.example.service.CarService;
import com.example.service.ParkService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JoinFacadeImpl implements JoinFacade {

    CarService carService;
    ParkService parkService;

    @Override
    public List<Car> findAvailableCars(Long id) {
        Park park = parkService.findById(id);

        Set<Car> cars = park.getCars();

        Collection<Car> allCars = carService.findAll();

        return allCars.stream().filter(car -> !cars.contains(car)).collect(Collectors.toList());
    }

    @Override
    public void add(Long parkId, Long carId) {
        Car car = carService.findById(carId);

        Park park = parkService.findById(parkId);

        if (car != null && park != null) {
            park.getCars().add(car);

            parkService.update(park);
        }
    }

    @Override
    public void remove(Long parkId, Long carId) {
        Park park = parkService.findById(parkId);

        Set<Car> cars = park.getCars();

        cars.removeIf(car -> car.getId().equals(carId));

        parkService.update(park);
    }
}
