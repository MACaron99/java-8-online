package com.example.service;

import com.example.persistence.entity.BaseEntity;

public interface BaseService<E extends BaseEntity> {

    E findById (Long id);
}
