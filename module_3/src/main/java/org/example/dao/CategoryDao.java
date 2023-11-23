package org.example.dao;

import org.example.entity.Category;

public interface CategoryDao extends BaseDao<Category> {

    Category findById(Long id);
}
