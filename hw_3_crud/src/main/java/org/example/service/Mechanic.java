package org.example.service;

import org.example.entity.BaseEntity;

public interface Mechanic<CAR extends BaseEntity> {

    void create(CAR car);

    CAR[] findAll();

    CAR findById(String id);

    void update(CAR car);

    void delete(CAR car);
}
