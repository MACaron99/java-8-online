package org.example.service;

import org.example.entity.BaseEntity;
import org.example.entity.Car;
import java.io.IOException;

public interface Mechanic<MEC extends BaseEntity> {

    void create(MEC be);

    MEC[] findAll();

    MEC findOne(String id) throws IOException;

    Car update(String brand, String model, int mileage) throws IOException;

    Car[] delete() throws IOException;
}