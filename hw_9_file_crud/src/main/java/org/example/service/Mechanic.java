package org.example.service;

import org.example.entity.BaseEntity;

import java.util.Collection;

public interface Mechanic<E extends BaseEntity> {

    void create(E be);
    void update(E be);
    void delete(String id);
    boolean exists(String id);
    Collection<E> findAll();
    Collection<E> findMany(String[] ids);
}