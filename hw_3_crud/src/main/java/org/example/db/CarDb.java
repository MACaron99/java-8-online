package org.example.db;

import org.example.entity.Car;
import org.example.entity.Collection;
import org.example.entity.CarCollection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

    public Car findOne(String id) throws IOException {
        int k = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                if (cars[i].getId() == id) {
                    k = i;
                }
            }
        }
        return cars[k];
    }

    private void add(Car car) {
        car.setId(UUID.randomUUID().toString());
        cars[lastCarIndex] = car;
        lastCarIndex++;
    }


    public Car update(String id) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter car brand");
        String brand = reader.readLine();
        System.out.println("Please enter car model");
        String model = reader.readLine();
        System.out.println("Please enter car mileage");
        int mileage = Integer.parseInt(reader.readLine());
        int k = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                if (cars[i].getId().equalsIgnoreCase(id)) {
                    k = i;
                }
            }
        }
        cars[k].setCarBrand(brand);
        cars[k].setCarModel(model);
        cars[k].setCarMileage(mileage);
        return cars[k];
    }

    public Car[] delete(String id) throws IOException {
        int k = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                System.out.println(cars[i].getId().equalsIgnoreCase(id));
                if (cars[i].getId().equalsIgnoreCase(id)) {
                    k = i;
                }
            }
        }
        System.out.println("k = " + k);
        Car[] a = Arrays.copyOfRange(cars, 0, k);
        Car[] b = Arrays.copyOfRange(cars, k + 1, cars.length);
        Car[] cars = Arrays.copyOf(a, a.length + b.length + 1);
        System.arraycopy(b, 0, cars, a.length, b.length);
        return this.cars = cars;
    }
}