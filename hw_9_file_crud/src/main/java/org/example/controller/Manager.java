package org.example.controller;

import org.example.entity.Car;
import org.example.entity.Park;
import org.example.entity.CarPark;
import org.example.service.CarMechanic;
import org.example.service.ParkMechanic;
import org.example.service.CarParkMechanic;
import org.example.service.imp.CarMechanicImp;
import org.example.service.imp.ParkMechanicImp;
import org.example.service.imp.CarParkMechanicImp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class Manager {

    private static final CarMechanic carMechanic = new CarMechanicImp();
    private static final ParkMechanic parkMechanic = new ParkMechanicImp();
    private static final CarParkMechanic<CarPark> carParkMechanic = new CarParkMechanicImp();

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
        System.out.println("Program FILE CRUD");
        System.out.println("Welcome to the program FILE CRUD. CRUD-application for working with two entities, " +
                "joining them and keeping data in file");
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
                carMechanic.create(setCar(reader));
                System.out.println("Car has been created");
            }

            case "2" -> {
                parkMechanic.create(setPark(reader));
                System.out.println("Park has been created");
            }

            case "3" -> {
                Collection<Car> cars = carMechanic.findAll();

                if (!cars.isEmpty()) {
                    printCars(cars);

                    CarPark carPark = new CarPark();

                    System.out.println("Please enter car id");
                    String carId = reader.readLine();
                    System.out.println();

                    if (carMechanic.exists(carId)) {
                        carPark.setCarId(carId);
                        Collection<Park> parks = parkMechanic.findAll();

                        if (!parks.isEmpty()) {
                            printParks(parks);
                            System.out.println("Please enter park id");
                            String parkId = reader.readLine();
                            System.out.println();

                            if (parkMechanic.exists(parkId)) {
                                carPark.setParkId(parkId);
                                carParkMechanic.create(carPark);
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

                if (!cars.isEmpty()) {
                    printCars(cars);
                } else {
                    System.out.println("No car found");
                }
            }

            case "5" -> {
                Collection<Park> parks = parkMechanic.findAll();

                if (!parks.isEmpty()) {
                    printParks(parks);
                } else {
                    System.out.println("No park found");
                }
            }

            case "6" -> {
                Collection<Park> parks = parkMechanic.findAll();

                if (!parks.isEmpty()) {
                    printParks(parks);
                    System.out.println("Please enter park id");
                    String parkId = reader.readLine();
                    System.out.println();

                    if (parkMechanic.exists(parkId)) {
                        Collection<CarPark> carParks = carParkMechanic.findByParkId(parkId);

                        if (!carParks.isEmpty()) {
                            printCars(carMechanic.findMany(carParks.stream().map(CarPark::getCarId).toArray(String[]::new)));
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

                if (!cars.isEmpty()) {
                    printCars(cars);
                    System.out.println("Please enter car id");
                    String carId = String.valueOf(reader.readLine());
                    System.out.println();

                    if (carMechanic.exists(carId)) {
                        Car car = setCar(reader);
                        car.setId(carId);

                        carMechanic.update(car);

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

                if (!parks.isEmpty()) {
                    printParks(parks);
                    System.out.println("Please enter park id");
                    String parkId = String.valueOf(reader.readLine());
                    System.out.println();

                    if (parkMechanic.exists(parkId)) {
                        Park park = setPark(reader);
                        park.setId(parkId);

                        parkMechanic.update(park);

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
                    String carId = reader.readLine();
                    System.out.println();

                    if (carMechanic.exists(carId)) {
                        CarPark carPark = carParkMechanic.findOneByCarId(carId);

                        if (carPark != null) {
                            carParkMechanic.deleteByCarId(carId);
                        }
                        carMechanic.delete(carId);

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

                if (!parks.isEmpty()) {
                    printParks(parks);
                    System.out.println("Please enter park id");
                    String parkId = reader.readLine();
                    System.out.println();

                    if (parkMechanic.exists(parkId)) {
                        CarPark carPark = carParkMechanic.findOneByParkId(parkId);

                        if (carPark != null) {
                            carParkMechanic.deleteByParkId(parkId);
                        }
                        parkMechanic.delete(parkId);

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

                if (!cars.isEmpty()) {
                    printCars(cars);
                    System.out.println("Please enter car id");
                    String carId = reader.readLine();
                    System.out.println();

                    if (carMechanic.exists(carId)) {
                        Collection<CarPark> carParks = carParkMechanic.findByCarId(carId);

                        if (!carParks.isEmpty()) {
                            printParks(parkMechanic.findMany(carParks.stream().map(CarPark::getParkId).toArray(String[]::new)));
                            System.out.println("Please enter park id");
                            String parkId = reader.readLine();
                            System.out.println();

                            if (parkMechanic.exists(parkId)) {
                                CarPark carPark = carParkMechanic.findByCarAndParkId(carId, parkId);

                                if (carPark != null) {
                                    carParkMechanic.deleteByCarAndParkId(carId, parkId);

                                    System.out.println("Car has been deleted from park");
                                } else {
                                    System.out.println("This car hasn't been added to this park");
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
            System.out.println("name = " + park.getParkName());
            System.out.println();
        }
    }

    private Car setCar(BufferedReader reader) throws IOException {
        Car car = new Car();

        System.out.println("Please enter car brand");
        car.setCarBrand(reader.readLine());

        System.out.println("Please enter car model");
        car.setCarModel(reader.readLine());

        System.out.println("Please enter car year");
        car.setCarYear(Integer.parseInt(reader.readLine()));

        return car;
    }

    private Park setPark(BufferedReader reader) throws IOException {
        Park park = new Park();

        System.out.println("Please enter park name");
        park.setParkName(reader.readLine());

        return park;
    }
}
