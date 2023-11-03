package org.example.service;

import org.example.entity.BaseEntity;

import java.util.Collection;

public interface Mechanic<E extends BaseEntity> {

    void create(E be);
    void update(E be);
    void delete(E e);
    E findById(Long id);
    Collection<E> findAll();
}