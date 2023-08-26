package org.example.service;

import org.example.entity.BaseEntity;

public interface Mechanic<MEC extends BaseEntity> {

    void create(MEC be);
    void update(MEC be);
    void delete(String id);
    MEC findOne(String id);
    MEC[] findAll();
}