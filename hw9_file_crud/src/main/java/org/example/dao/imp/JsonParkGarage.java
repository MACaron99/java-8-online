package org.example.dao.imp;

import com.google.gson.Gson;
import org.example.dao.ParkGarage;
import org.example.entity.Park;
import org.example.util.FileUtil;
import org.example.util.GarageUtil;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class JsonParkGarage implements ParkGarage {

    private List<Park> parks = new ArrayList<>();

    @Override
    public void create(Park park) {
        readJson();

        park.setId(GarageUtil.generateId(parks));
        parks.add(park);
        writeJson();

    }

    @Override
    public void update(Park park) {
        readJson();

        for (int i = 0; i < parks.size(); i++) {
            if (parks.get(i).getId().equals(park.getId())) {
                parks.set(i, park);
                writeJson();
                return;
            }
        }
    }

    @Override
    public void delete(String id) {
        readJson();

        parks.removeIf(student -> student.getId().equals(id));

        writeJson();
    }

    @Override
    public boolean exists(String id) {
        readJson();

        return parks.stream().anyMatch(collection -> collection.getId().equals(id));
    }

    @Override
    public Collection<Park> findAll() {
        readJson();

        return this.parks;
    }

    @Override
    public Collection<Park> findMany(String[] ids) {
        readJson();

        return parks.stream()
                .filter(collection -> Arrays.asList(ids).contains(collection.getId()))
                .collect(Collectors.toList());
    }

    private void readJson() {
        Gson gson = new Gson();

        FileUtil.fileCheck("parks.json");

        try {
            Park[] from = gson.fromJson(new FileReader("parks.json"), Park[].class);

            if (from != null) {
                this.parks = new ArrayList<>();
                this.parks.addAll(Arrays.asList(from));
            }
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void writeJson() {
        Gson gson = new Gson();

        FileUtil.fileCheck("parks.json");

        String json = gson.toJson(this.parks);

        try(FileWriter fileWriter = new FileWriter("parks.json")) {
            fileWriter.write(json);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }
}
