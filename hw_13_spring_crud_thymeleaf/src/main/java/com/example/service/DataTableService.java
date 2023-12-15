package com.example.service;

import com.example.dto.request.PageRequestDto;
import com.example.entity.BaseEntity;
import org.springframework.data.domain.Page;

public interface DataTableService<E extends BaseEntity> {

    Page<E> findAll(PageRequestDto pageRequestDto);
}
