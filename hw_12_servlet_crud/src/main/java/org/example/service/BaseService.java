package org.example.service;

import org.example.entity.BaseEntity;

import java.util.Collection;
import java.util.Optional;

public interface BaseService<E extends BaseEntity> {

    void create(E e);
    void update(E e);
    void delete(Long id);
    Optional<E> findById(Long id);
    Collection<E> findAll();
}