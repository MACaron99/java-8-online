package org.example.service.impl;

import org.example.dao.CategoryDao;
import org.example.dao.impl.CategoryDaoImpl;
import org.example.entity.Category;
import org.example.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public void create(Category category) {
        categoryDao.create(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryDao.findById(id);
    }
}
