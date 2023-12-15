package com.example.service;

import com.example.entity.BaseEntity;

public interface BaseService<E extends BaseEntity> {

    void create(E e);
    void update(E e);
    void delete(Long id);
    E findById(Long id);
}
