package org.example.service;

import org.example.entity.BaseEntity;

public interface BaseService<E extends BaseEntity> {

    void create(E e);
}
