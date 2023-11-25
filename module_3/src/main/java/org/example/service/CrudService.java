package org.example.service;

import org.example.entity.BaseEntity;

import java.util.Collection;

public interface CrudService<E extends BaseEntity> {

    void create(E e);
    void update(E e);
    E findById(Long id);
    Collection<E> findAll();
}
