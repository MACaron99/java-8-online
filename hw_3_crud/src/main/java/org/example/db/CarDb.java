package org.example.db;

import org.example.entity.Car;
import org.example.entity.Collection;
import org.example.entity.CarCollection;

import java.util.UUID;

public class CarDb {

    private Car[] cars = new Car[2];
    private Collection[] collections = new Collection[2];
    private CarCollection[] carCollections = new CarCollection[2];
    private int lastCarIndex = 0;

    public void create(Car car) {
        if (lastCarIndex == cars.length - 1) {
            Car[] newCars = new Car[cars.length * 2];
            System.arraycopy(cars, 0, newCars, 0, cars.length);
            cars = newCars;
            add(car);
        } else {
            add(car);
        }
    }

    public Car[] findAll() {
        return cars;
    }

    private void add(Car car) {
        car.setId(UUID.randomUUID().toString());
        cars[lastCarIndex] = car;
        lastCarIndex++;
    }
}