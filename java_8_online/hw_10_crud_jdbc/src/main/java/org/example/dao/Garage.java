package org.example.dao;

import org.example.entity.BaseEntity;

import java.util.Collection;

public interface Garage<E extends BaseEntity> {

    void create(E e);
    void update(E e);
    void delete(Long id);
    boolean exists(Long id);
    Collection<E> findAll();
    Collection<E> findMany(Long[] ids);
}
