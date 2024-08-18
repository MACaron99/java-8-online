package org.example.service;

import org.example.entity.BaseEntity;

public interface Mechanic<MEC extends BaseEntity> {

    void create(MEC be);

    MEC[] findAll();

    void findOne(String id);

    void update(String brand, String model, int mileage);

    void delete();
}
