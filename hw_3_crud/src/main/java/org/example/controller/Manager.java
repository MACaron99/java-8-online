package org.example.controller;

import org.example.entity.Car;
import org.example.service.CarMechanic;
import org.example.service.impl.CarMechanicImpl;
import org.example.service.impl.CarMechanicImpl2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Manager {

    private CarMechanic carMechanic = new CarMechanicImpl();

    public void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position = "";
        while ((position = bufferedReader.readLine()) != null) {
            crud(position, bufferedReader);
            menu();
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("If you want create a car please enter 1");
        System.out.println("If you want find cars please enter 2");
        System.out.println("If you want close app please enter 3");
    }

    private void crud(String position, BufferedReader bufferedReader) throws IOException {
        switch (position) {
            case "1" -> create(bufferedReader);
            case "2" -> findAll();
            case "3" -> System.exit(0);
        }
    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("Please enter car brand");
        String cb = reader.readLine();
        System.out.println("Please enter car model");
        String cm = reader.readLine();
        System.out.println("Please enter car mileage");
        int carMileage = Integer.parseInt(reader.readLine());
        Car car = new Car();
        car.setCarBrand(cb);
        car.setCarModel(cm);
        car.setCarMileage(carMileage);
        carMechanic.create(car);
    }

    private void findAll() {
        Car[] cars = carMechanic.findAll();
        for (int i = 0; i < cars.length; i++) {
            Car car = cars[i];
            if (car != null) {
                System.out.println("id = " + car.getId());
                System.out.println("car brand = " + car.getCarBrand());
                System.out.println("car model = " + car.getCarModel());
                System.out.println("car mileage = " + car.getCarMileage());
            }
        }
    }
}