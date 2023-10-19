package org.example.db;

import org.example.entity.Car;
import java.util.Arrays;
import java.util.UUID;

public class CarDb {
    public Car[] cars = new Car[10];
    private int lastCarIndex = 0;
    private int k;

    public void create(Car car) {
        if (lastCarIndex == cars.length - 1) {
            Car[] newCars = new Car[cars.length * 2];
            System.arraycopy(cars, 0, newCars, 0, cars.length);
            cars = newCars;
            add(car);
        } else add(car);
    }

    private void add(Car car) {
        car.setId(UUID.randomUUID().toString());
        cars[lastCarIndex] = car;
        lastCarIndex++;
    }

    public Car[] findAll() {
        return cars;
    }

    public Car findOne(String id) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                if (cars[i].getId().equalsIgnoreCase(id)) {
                    k = i;
                }
            }
        }
        return cars[k];
    }

    public Car update(String brand, String model, int mileage) {
        cars[k].setCarBrand(brand);
        cars[k].setCarModel(model);
        cars[k].setCarMileage(mileage);
        return cars[k];
    }

    public Car[] delete() {
        Car[] a = Arrays.copyOfRange(cars, 0, k);
        Car[] b = Arrays.copyOfRange(cars, k + 1, cars.length);
        Car[] cars = Arrays.copyOf(a, a.length + b.length + 1);
        System.arraycopy(b, 0, cars, a.length, b.length);
        return this.cars = cars;
    }
}