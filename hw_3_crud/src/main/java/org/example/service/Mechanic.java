package org.example.service;

import org.example.entity.BaseEntity;
import org.example.entity.Car;

import java.io.IOException;

public interface Mechanic<MEC extends BaseEntity> {

    void create(MEC be);
    Car update(String be) throws IOException;
    Car[] delete(String id) throws IOException;
    MEC findOne(String id) throws IOException;
    MEC[] findAll();
}