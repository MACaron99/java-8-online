package org.example.dao.imp;

import com.google.gson.Gson;
import org.example.dao.CarParkGarage;
import org.example.entity.CarPark;
import org.example.util.FileUtil;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class JsonCarParkGarage implements CarParkGarage<CarPark> {

    private List<CarPark> carParks = new ArrayList<>();

    @Override
    public void create(CarPark carPark) {
        readJson();

        carParks.add(carPark);

        writeJson();
    }

    @Override
    public void deleteByCarId(String carId) {
        readJson();

        carParks.removeIf(carPark -> carPark.getCarId().equals(carId));
        writeJson();

    }

    @Override
    public void deleteByParkId(String parkId) {
        readJson();

        carParks.removeIf(carPark -> carPark.getParkId().equals(parkId));
        writeJson();

    }

    @Override
    public void deleteByCarAndParkId(String carId, String parkId) {
        readJson();

        carParks.removeIf(carPark -> carPark.getCarId().equals(carId) && carPark.getParkId().equals(parkId));
        writeJson();

    }

    @Override
    public Collection<CarPark> findByCarId(String id) {
        readJson();

        return carParks.stream()
                .filter(carPark -> Objects.equals(id, carPark.getCarId()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<CarPark> findByParkId(String id) {
        readJson();

        return carParks.stream()
                .filter(carPark -> Objects.equals(id, carPark.getParkId()))
                .collect(Collectors.toList());
    }

    @Override
    public CarPark findOneByCarId(String id) {
        readJson();

        return carParks.stream()
                .filter(carPark -> carPark.getCarId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public CarPark findOneByParkId(String id) {
        readJson();

        return carParks.stream()
                .filter(carPark -> carPark.getParkId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public CarPark findByCarAndParkId(String carId, String parkId) {
        readJson();

        return carParks.stream()
                .filter(carPark -> carPark.getCarId().equals(carId) && carPark.getParkId().equals(parkId))
                .findFirst()
                .orElse(null);
    }

    private void readJson() {
        Gson gson = new Gson();

        FileUtil.fileCheck("car_parks.json");

        try {
            CarPark[] from = gson.fromJson(new FileReader("car_parks.json"), CarPark[].class);

            if (from != null) {
                this.carParks = new ArrayList<>();
                this.carParks.addAll(Arrays.asList(from));
            }
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void writeJson() {
        Gson gson = new Gson();

        FileUtil.fileCheck("car_parks.json");

        String json = gson.toJson(this.carParks);

        try(FileWriter fileWriter = new FileWriter("car_parks.json")) {
            fileWriter.write(json);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }
}
