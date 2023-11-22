package org.example.dao;

import org.example.entity.BaseEntity;

import java.util.Collection;

public interface CrudDao<E extends BaseEntity> {

    void create(E e);
    void update(E e);
    void delete(E e);
    E findById(Long id);
    Collection<E> findAll();
}
