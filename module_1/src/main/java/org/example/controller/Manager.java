package org.example.controller;

import org.example.entity.Car;
import org.example.entity.Collection;
import org.example.entity.CarCollection;
import org.example.service.CarService;
import org.example.service.CollectionService;
import org.example.service.CarCollectionService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Manager {
    private static CarService carService = new CarService();
    private static CollectionService collectionService = new CollectionService();
    private static CarCollectionService carCollectionService = new CarCollectionService();

    public void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        program();
        menu();
        String position = "";
        while ((position = bufferedReader.readLine()) != null) {
            crud(position, bufferedReader);
            menu();
        }
    }

    private void program() {
        System.out.println();
        System.out.println("Program CARS & COLLECTIONS");
        System.out.println("Welcome to the program CARS & COLLECTIONS. CRUD-application with the ability to add cars to collections.");
    }

    private void menu() {
        System.out.println();
        System.out.println("Menu");
        System.out.println("If you want to create a car please enter 1");
        System.out.println("If you want to create a collection please enter 2");
        System.out.println("If you want to add a car to collection please enter 3");
        System.out.println("If you want to find cars please enter 4");
        System.out.println("If you want to find collections please enter 5");
        System.out.println("If you want to find cars in collections please enter 6");
        System.out.println("If you want to update the car please enter 7");
        System.out.println("If you want to update the collection please enter 8");
        System.out.println("If you want to delete car please enter 9");
        System.out.println("If you want to delete collection please enter 10");
        System.out.println("If you want to delete car from the collection please enter 11");
        System.out.println("If you want close app please enter 12");

    }

    private void crud(String position, BufferedReader reader) throws IOException {
        String id = "";
        switch (position) {
            case "1" -> {
                System.out.println("Please enter car brand");
                String brand = reader.readLine();
                System.out.println("Please enter car model");
                String model = reader.readLine();
                System.out.println("Please enter car mileage");
                int mileage = Integer.parseInt(reader.readLine());
                System.out.println();
                Car car = new Car();
                car.setCarBrand(brand);
                car.setCarModel(model);
                car.setCarMileage(mileage);
                carService.create(car);
                System.out.println("Your car has successfully created");
            }
            case "2" -> {
                System.out.println("Please enter collection name");
                String name = reader.readLine();
                System.out.println();
                Collection collection = new Collection();
                collection.setCollectionName(name);
                collectionService.create(collection);
                System.out.println("Your collection has successfully created");
            }
            case "3" -> {
                Car[] cars = carService.findAll();
                boolean truth1 = false;
                for (int i = 0; i < carService.carNumber; i++) {
                    Car car = cars[i];
                    if (car != null) {
                        truth1 = true;
                        System.out.println("Car");
                        System.out.println("id = " + car.getId());
                        System.out.println("brand = " + car.getCarBrand());
                        System.out.println("model = " + car.getCarModel());
                        System.out.println("mileage = " + car.getCarMileage());
                        System.out.println();
                    }
                }
                if (truth1 == true) {
                    System.out.println();
                    System.out.println("Please enter car id");
                    String carId = reader.readLine();
                    System.out.println();
                    Collection[] collections = collectionService.findAll();
                    boolean truth2 = false;
                    for (int i = 0; i < collectionService.collectionNumber; i++) {
                        Collection collection = collections[i];
                        if (collection != null) {
                            truth2 = true;
                            System.out.println("Collection");
                            System.out.println("id = " + collection.getId());
                            System.out.println("name = " + collection.getCollectionName());
                            System.out.println();
                        }
                    }
                    if (truth2 == true) {
                        System.out.println();
                        System.out.println("Please enter collection id");
                        String collectionId = reader.readLine();
                        System.out.println();
                        CarCollection carCollection = new CarCollection();
                        carCollection.setCarId(carId);
                        carCollection.setCollectionId(collectionId);
                        carCollectionService.create(carCollection);
                        System.out.println("Your car has successfully added to your collection");
                    } else {
                        System.out.println("There is no collection created");
                    }
                } else {
                    System.out.println("There is no car created");
                }
            }
            case "4" -> {
                Car[] cars = carService.findAll();
                boolean truth = false;
                for (int i = 0; i < carService.carNumber; i++) {
                    Car car = cars[i];
                    if (car != null) {
                        truth = true;
                        System.out.println("Car");
                        System.out.println("id = " + car.getId());
                        System.out.println("brand = " + car.getCarBrand());
                        System.out.println("model = " + car.getCarModel());
                        System.out.println("mileage = " + car.getCarMileage());
                        System.out.println();
                    }
                }
                if (truth == false) {
                    System.out.println("There is no car created");
                }
            }
            case "5" -> {
                Collection[] collections = collectionService.findAll();
                boolean truth = false;
                for (int i = 0; i < collectionService.collectionNumber; i++) {
                    Collection collection = collections[i];
                    if (collection != null) {
                        truth = true;
                        System.out.println("Collection");
                        System.out.println("id = " + collection.getId());
                        System.out.println("name = " + collection.getCollectionName());
                        System.out.println();
                    }
                }
                if (truth == false) {
                    System.out.println("There is no collection created");
                }
            }
            case "6" -> {
                Collection[] collections = collectionService.findAll();
                boolean truth = false;
                for (int i = 0; i < collectionService.collectionNumber; i++) {
                    Collection collection = collections[i];
                    if (collection != null) {
                        truth = true;
                        System.out.println("Collection");
                        System.out.println("id = " + collection.getId());
                        System.out.println("name = " + collection.getCollectionName());
                        System.out.println();
                    }
                }
                if (truth == true) {
                    System.out.println("Please enter collection id if you want to find cars in collection");
                    id = String.valueOf(reader.readLine());
                    String[] ids = carCollectionService.findByCollectionId(id);
                    if (ids != null) {
                        Car[] vehicles = carService.findMany(ids);
                        for (int i = 0; i < vehicles.length; i++) {
                            Car car = vehicles[i];
                            if (car != null) {
                                System.out.println("Car");
                                System.out.println("id = " + car.getId());
                                System.out.println("brand = " + car.getCarBrand());
                                System.out.println("model = " + car.getCarModel());
                                System.out.println("mileage = " + car.getCarMileage());
                                System.out.println();
                            }
                        }
                    } else {
                        System.out.println("There is no cars in collection");
                    }
                } else {
                    System.out.println("There is no collection created");
                }
            }
            case "7" -> {
                Car[] cars = carService.findAll();
                boolean truth = false;
                for (int i = 0; i < cars.length; i++) {
                    Car car = cars[i];
                    if (car != null) {
                        truth = true;
                        System.out.println("Car");
                        System.out.println("id = " + car.getId());
                        System.out.println("car brand = " + car.getCarBrand());
                        System.out.println("car model = " + car.getCarModel());
                        System.out.println("car mileage = " + car.getCarMileage());
                        System.out.println();
                    }
                }
                if (truth == true) {
                    System.out.println("Please enter id if you want to update the car");
                    id = String.valueOf(reader.readLine());
                    System.out.println();
                    Car newCar = new Car();
                    System.out.println("Please enter car brand");
                    String brand = reader.readLine();
                    System.out.println("Please enter car model");
                    String model = reader.readLine();
                    System.out.println("Please enter car mileage");
                    int mileage = Integer.parseInt(reader.readLine());
                    System.out.println();
                    newCar.setId(id);
                    newCar.setCarBrand(brand);
                    newCar.setCarModel(model);
                    newCar.setCarMileage(mileage);
                    carService.update(id, newCar);
                    System.out.println("Your car was successfully updated");
                } else {
                    System.out.println("There is no car created");
                }
            }
            case "8" -> {
                Collection[] collections = collectionService.findAll();
                boolean truth = false;
                for (int i = 0; i < collections.length; i++) {
                    Collection collection = collections[i];
                    if (collection != null) {
                        truth = true;
                        System.out.println("Collection");
                        System.out.println("id = " + collection.getId());
                        System.out.println("name = " + collection.getCollectionName());
                        System.out.println();
                    }
                }
                if (truth ==true) {
                    System.out.println("Please enter id if you want to update the collection");
                    id = String.valueOf(reader.readLine());
                    System.out.println();
                    Collection newCollection = new Collection();
                    System.out.println("Please enter collection name");
                    String name = reader.readLine();
                    System.out.println();
                    newCollection.setId(id);
                    newCollection.setCollectionName(name);
                    collectionService.update(id, newCollection);
                    System.out.println("Your collection was successfully updated");
                } else {
                    System.out.println("There is no collection created");
                }
            }
            case "9" -> {
                Car[] cars = carService.findAll();
                boolean truth = false;
                for (int i = 0; i < cars.length; i++) {
                    Car car = cars[i];
                    if (car != null) {
                        truth = true;
                        System.out.println("Car");
                        System.out.println("id = " + car.getId());
                        System.out.println("car brand = " + car.getCarBrand());
                        System.out.println("car model = " + car.getCarModel());
                        System.out.println("car mileage = " + car.getCarMileage());
                        System.out.println();
                    }
                }
                if (truth == true) {
                    System.out.println("Please enter id if you want to delete the car");
                    id = String.valueOf(reader.readLine());
                    CarCollection carCollection = carCollectionService.findOneByCarId(id);
                    if (carCollection != null) {
                        carCollectionService.delete(carCollection);
                    }
                    Car car = carService.findOne(id);
                    if (car != null) {
                        carService.delete(car);
                        System.out.println();
                        System.out.println("Your car was successfully deleted");
                    } else {
                        System.out.println("Car not found");
                    }
                } else {
                    System.out.println("There is no car created");
                }
            }
            case "10" -> {
                Collection[] collections = collectionService.findAll();
                boolean truth = false;
                for (int i = 0; i < collections.length; i++) {
                    Collection collection = collections[i];
                    if (collection != null) {
                        truth = true;
                        System.out.println("Collection");
                        System.out.println("id = " + collection.getId());
                        System.out.println("name = " + collection.getCollectionName());
                        System.out.println();
                    }
                }
                if (truth == true) {
                    System.out.println("Please enter id if you want to delete the collection");
                    id = String.valueOf(reader.readLine());
                    CarCollection carCollection = carCollectionService.findOneByCollectionId(id);
                    if (carCollection != null) {
                        carCollectionService.delete(carCollection);
                    }
                    Collection collection = collectionService.findOne(id);
                    if (collection != null) {
                        collectionService.delete(collection);
                        System.out.println("Your collection was successfully deleted");
                    } else {
                        System.out.println("Collection not found");
                    }
                } else {
                    System.out.println("There is no collection created");
                }
            }
            case "11" -> {
                Car[] cars = carService.findAll();
                boolean truth1 = false;
                for (int i = 0; i < carService.carNumber; i++) {
                    Car car = cars[i];
                    if (car != null) {
                        truth1 = true;
                        System.out.println("Car");
                        System.out.println("id = " + car.getId());
                        System.out.println("car brand = " + car.getCarBrand());
                        System.out.println("car model = " + car.getCarModel());
                        System.out.println("car mileage = " + car.getCarMileage());
                        System.out.println();
                    } else {
                        System.out.println("There is no cars created");
                    }
                }
                if (truth1 == true) {
                    System.out.println();
                    System.out.println("Please enter car id");
                    id = String.valueOf(reader.readLine());
                    String carId = id;
                    String[] ids = carCollectionService.findByCarId(id);
                    if (ids != null) {
                        Collection[] selections = collectionService.findMany(ids);
                        boolean truth2 = false;
                        for (int i = 0; i < selections.length; i++) {
                            Collection collection = selections[i];
                            if (collection != null) {
                                truth2 = true;
                                System.out.println("Collection");
                                System.out.println("id = " + collection.getId());
                                System.out.println("brand = " + collection.getCollectionName());
                                System.out.println();
                            }
                        }
                        if (truth2 == true) {
                            System.out.println("Please enter collection id");
                            id = String.valueOf(reader.readLine());
                            String collectionId = id;
                            CarCollection carCollection = carCollectionService.findByCarAndCollectionId(carId, collectionId);
                            if (carCollection != null) {
                                carCollectionService.delete(carCollection);
                                System.out.println("Your Car has successfully deleted from the collection");
                            } else {
                                System.out.println("Car or collection not found");
                            }
                        } else {
                            System.out.println();
                        }
                    } else {
                        System.out.println("This car is not added to collection");
                    }
                } else {
                    System.out.println("There is no car created");
                }
            }
            case "12" -> {
                System.out.print("Goodbye!");
                System.exit(0);
            }
        }
    }
}