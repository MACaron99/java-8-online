package org.example.service;

import org.example.entity.Category;

public interface CategoryService extends BaseService<Category> {

    Category findById(Long id);
}
