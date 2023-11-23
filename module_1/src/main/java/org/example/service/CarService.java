package org.example.service;

import org.example.entity.Car;

import java.util.UUID;

public class CarService {

    public Car[] cars = new Car[10];
    public int carNumber = 0;

    public void create(Car car) {
        if (carNumber == cars.length - 1) {
            Car[] newCars = new Car[cars.length * 2];
            System.arraycopy(cars, 0, newCars, 0, cars.length);
            cars = newCars;
            add(car);
        } else {
            add(car);
        }
    }

    private void add(Car car) {
        car.setId(UUID.randomUUID().toString());
        cars[carNumber] = car;
        carNumber++;
    }

    public Car[] findAll() {
        return cars;
    }

    public Car findOne(String id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    public Car[] findMany(String[] ids) {
        Car[] vehicles = new Car[carNumber * carNumber];
        int number = 0;
        for (String id : ids) {
            for (int j = 0; j < carNumber; j++) {
                if (id.equals(cars[j].getId())) {
                    vehicles[number] = cars[j];
                    number++;
                }
            }
        }
        if (number > 0) {
            return vehicles;
        } else {
            return null;
        }
    }

    public void update(String id, Car newCar) {
        for (int i = 0; i < carNumber; i++) {
            if (cars[i].getId().equals(id)) {
                cars[i] = newCar;
                return;
            }
        }
    }

    public void delete(Car car) {
        int count = 0;
        Car[] newCars = new Car[10];
        for (int i = 0; i < carNumber; i++) {
            if (!cars[i].equals(car)) {
                newCars[count] = cars[i];
                count++;
            }
        }
        cars = newCars;
        carNumber--;
    }
}