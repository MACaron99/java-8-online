package org.example.dao;

import org.example.entity.BaseEntity;

public interface BaseDao<E extends BaseEntity> {

    void create(E e);
}
