package org.example.dao;

import org.example.entity.BaseEntity;

import java.util.Collection;

public interface Garage<E extends BaseEntity> {

    void create(E e);
    void update(E e);
    void delete(String id);
    boolean exists(String id);
    Collection<E> findAll();
    Collection<E> findMany(String[] id);
}
