package org.example.db;

import org.example.entity.Car;
import java.util.UUID;

public class CarDb {

    public Car[] cars = new Car[10];
    private int carIndex = 0;

    public void create(Car car) {
        if (carIndex == cars.length - 1) {
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

        cars[carIndex] = car;
        carIndex++;
    }

    public Car[] findAll() {
        return cars;
    }

    public Car findById(String id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    public void update(Car updatedCar) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getId().equals(updatedCar.getId())) {
                cars[i] = updatedCar;
                break;
            }
        }
    }

    public void delete(Car car) {
        int count = 0;

        Car[] newCars = new Car[10];

        for (int i = 0; i < carIndex; i++) {
            if (!cars[i].equals(car)) {
                newCars[count] = cars[i];
                count++;
            }
        }
        cars = newCars;
        carIndex--;
    }
}
