package org.example.dao.imp;

import com.google.gson.Gson;
import org.example.dao.CarGarage;
import org.example.entity.Car;
import org.example.util.FileUtil;
import org.example.util.GarageUtil;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class JsonCarGarage implements CarGarage {
    private List<Car> cars = new ArrayList<>();

    @Override
    public void create(Car car) {
        readJson();
        car.setId(GarageUtil.generateId(cars));
        cars.add(car);
        writeJson();
    }

    @Override
    public void update(Car car) {
        readJson();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId().equals(car.getId())) {
                cars.set(i, car);
                writeJson();
                return;
            }
        }
    }

    @Override
    public void delete(String id) {
        readJson();
        cars.removeIf(student -> student.getId().equals(id));
        writeJson();
    }

    @Override
    public boolean exists(String id) {
        readJson();
        return cars.stream().anyMatch(car -> car.getId().equals(id));
    }

    @Override
    public Collection<Car> findAll() {
        readJson();
        return this.cars;
    }

    @Override
    public Collection<Car> findMany(String[] ids) {
        readJson();
        return cars.stream()
                .filter(car -> Arrays.asList(ids).contains(car.getId()))
                .collect(Collectors.toList());
    }

    private void readJson() {
        Gson gson = new Gson();
        FileUtil.fileCheck("cars.json");
        try {
            Car[] from = gson.fromJson(new FileReader("cars.json"), Car[].class);
            if (from != null) {
                this.cars = new ArrayList<>();
                this.cars.addAll(Arrays.asList(from));
            }
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void writeJson() {
        Gson gson = new Gson();
        FileUtil.fileCheck("cars.json");
        String json = gson.toJson(this.cars);
        try(FileWriter fileWriter = new FileWriter("cars.json")) {
            fileWriter.write(json);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }
}