package org.example.controller;

import org.apache.commons.collections4.CollectionUtils;
import org.example.entity.Car;
import org.example.entity.Park;
import org.example.service.CarMechanic;
import org.example.service.ParkMechanic;
import org.example.service.imp.CarMechanicImp;
import org.example.service.imp.ParkMechanicImp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Set;

public class Manager {

    private static final CarMechanic carMechanic = new CarMechanicImp();
    private static final ParkMechanic parkMechanic = new ParkMechanicImp();
    public void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        program();
        menu();
        String position;
        while ((position = bufferedReader.readLine()) != null) {
            crud(position, bufferedReader);
            menu();
        }
    }

    private void program() {
        System.out.println();
        System.out.println("Program CRUD SQL");
        System.out.println("Welcome to the program CRUD SQL. CRUD-application for working with two entities, joining them and keeping data in database");
    }

    private void menu() {
        System.out.println();
        System.out.println("Menu");
        System.out.println("1. Create car");
        System.out.println("2. Create park");
        System.out.println("3. Add car to park");
        System.out.println("4. Find cars");
        System.out.println("5. Find parks");
        System.out.println("6. Find cars in park");
        System.out.println("7. Update car");
        System.out.println("8. Update park");
        System.out.println("9. Delete car");
        System.out.println("10. Delete park");
        System.out.println("11. Delete car from park");
        System.out.println("0. Close app");
    }

    private void crud(String position, BufferedReader reader) throws IOException {
        switch (position) {
            case "1" -> {
                carMechanic.create(setCar(new Car(), reader));
                System.out.println("Car has been created");
            }
            case "2" -> {
                parkMechanic.create(setPark(new Park(), reader));
                System.out.println("Park has been created");
            }
            case "3" -> {
                Collection<Car> cars = carMechanic.findAll();
                if (CollectionUtils.isNotEmpty(cars)) {
                    printCars(cars);
                    System.out.println("Please enter car id");
                    Car car = carMechanic.findById(Long.valueOf(reader.readLine()));
                    System.out.println();
                    if (car != null) {
                        Collection<Park> parks = parkMechanic.findAll();
                        if (CollectionUtils.isNotEmpty(parks)) {
                            printParks(parks);
                            System.out.println("Please enter park id");
                            Park park = parkMechanic.findById(Long.valueOf(reader.readLine()));
                            System.out.println();
                            if (park != null) {
                                park.getCars().add(car);
                                parkMechanic.update(park);
                                System.out.println("Сar has been added to park");
                            } else {
                                System.out.println("Park not found");
                            }
                        } else {
                            System.out.println("No park found");
                        }
                    } else {
                        System.out.println("Car not found");
                    }
                } else {
                    System.out.println("No car found");
                }
            }
            case "4" -> {
                Collection<Car> cars = carMechanic.findAll();
                if (CollectionUtils.isNotEmpty(cars)) {
                    printCars(cars);
                } else {
                    System.out.println("No car found");
                }
            }
            case "5" -> {
                Collection<Park> parks = parkMechanic.findAll();
                if (CollectionUtils.isNotEmpty(parks)) {
                    printParks(parks);
                } else {
                    System.out.println("No park found");
                }
            }
            case "6" -> {
                Collection<Park> parks = parkMechanic.findAll();
                if (CollectionUtils.isNotEmpty(parks)) {
                    printParks(parks);
                    System.out.println("Please enter park id");
                    Park park = parkMechanic.findById(Long.valueOf(reader.readLine()));
                    System.out.println();
                    if (park != null) {
                        Set<Car> cars = park.getCars();
                        if (CollectionUtils.isNotEmpty(cars)) {
                            printCars(cars);
                        } else {
                            System.out.println("No car found");
                        }
                    } else {
                        System.out.println("Park not found");
                    }
                } else {
                    System.out.println("No park found");
                }
            }
            case "7" -> {
                Collection<Car> cars = carMechanic.findAll();
                if (CollectionUtils.isNotEmpty(cars)) {
                    printCars(cars);
                    System.out.println("Please enter car id");
                    Car car = carMechanic.findById(Long.valueOf(reader.readLine()));
                    System.out.println();
                    if (car != null) {
                        carMechanic.update(setCar(car, reader));
                        System.out.println("Car has been updated");
                    } else {
                        System.out.println("Car not found");
                    }
                } else {
                    System.out.println("No car found");
                }
            }
            case "8" -> {
                Collection<Park> parks = parkMechanic.findAll();
                if (CollectionUtils.isNotEmpty(parks)) {
                    printParks(parks);
                    System.out.println("Please enter park id");
                    Park park = parkMechanic.findById(Long.valueOf(reader.readLine()));
                    System.out.println();
                    if (park != null) {
                        parkMechanic.update(setPark(park, reader));
                        System.out.println("Park has been updated");
                    } else {
                        System.out.println("Park not found");
                    }
                } else {
                    System.out.println("No park found");
                }
            }
            case "9" -> {
                Collection<Car> cars = carMechanic.findAll();
                if (!cars.isEmpty()) {
                    printCars(cars);
                    System.out.println("Please enter car id");
                    Long id = Long.valueOf(reader.readLine());
                    Car car = carMechanic.findById(id);
                    System.out.println();
                    if (car != null) {
                        Set<Park> parks = car.getParks();
                        if (CollectionUtils.isNotEmpty(parks)) {
                            for (Park park : parks) {
                                Set<Car> cars1 = park.getCars();
                                if (CollectionUtils.isNotEmpty(cars1)) {
                                    cars1.removeIf(car1 -> car1.getId().equals(id));
                                    parkMechanic.update(park);
                                }
                            }
                        }
                        carMechanic.delete(car);
                        System.out.println("Car has been deleted");
                    } else {
                        System.out.println("Car not found");
                    }
                } else {
                    System.out.println("No car found");
                }
            }
            case "10" -> {
                Collection<Park> parks = parkMechanic.findAll();
                if (CollectionUtils.isNotEmpty(parks)) {
                    printParks(parks);
                    System.out.println("Please enter park id");
                    Park park = parkMechanic.findById(Long.valueOf(reader.readLine()));
                    System.out.println();
                    if (park != null) {
                        parkMechanic.delete(park);
                        System.out.println("Park has been deleted");
                    } else {
                        System.out.println("Park not found");
                    }
                } else {
                    System.out.println("No park found");
                }
            }
            case "11" -> {
                Collection<Car> cars = carMechanic.findAll();
                if (CollectionUtils.isNotEmpty(cars)) {
                    printCars(cars);
                    System.out.println("Please enter car id");
                    Long id = Long.valueOf(reader.readLine());
                    System.out.println();
                    Car car = carMechanic.findById(id);
                    if (car != null) {
                        Set<Park> parks = car.getParks();
                        if (CollectionUtils.isNotEmpty(parks)) {
                            printParks(parks);
                            System.out.println("Please enter park id");
                            Park park = parkMechanic.findById(Long.valueOf(reader.readLine()));
                            System.out.println();
                            if (park != null) {
                                Set<Car> cars1 = park.getCars();
                                if (CollectionUtils.isNotEmpty(cars1)) {
                                    cars1.removeIf(car1 -> car1.getId().equals(id));
                                    parkMechanic.update(park);
                                    System.out.println("Car has been deleted from park");
                                } else {
                                    System.out.println("No car found");
                                }
                            } else {
                                System.out.println("Park not found");
                            }
                        } else {
                            System.out.println("Car hasn't been added to park");
                        }
                    } else {
                        System.out.println("Car not found");
                    }
                } else {
                    System.out.println("No car found");
                }
            }
            case "0" -> {
                System.out.println("Goodbye!");
                System.exit(0);
            }
        }
    }

    private void printCars(Collection<Car> cars) {
        for (Car car : cars) {
            System.out.println("Car");
            System.out.println("id = " + car.getId());
            System.out.println("brand = " + car.getCarBrand());
            System.out.println("model = " + car.getCarModel());
            System.out.println("year = " + car.getCarYear());
            System.out.println();
        }
    }

    private void printParks(Collection<Park> parks) {
        for (Park park : parks) {
            System.out.println("Park");
            System.out.println("id = " + park.getId());
            System.out.println("name = " + park.getName());
            System.out.println();
        }
    }

    private Car setCar(Car car, BufferedReader reader) throws IOException {
        System.out.println("Please enter car brand");
        car.setCarBrand(reader.readLine());
        System.out.println("Please enter car model");
        car.setCarModel(reader.readLine());
        System.out.println("Please enter car year");
        car.setCarYear(Integer.parseInt(reader.readLine()));
        return car;
    }

    private Park setPark(Park park, BufferedReader reader) throws IOException {
        System.out.println("Please enter park name");
        park.setName(reader.readLine());
        return park;
    }
}