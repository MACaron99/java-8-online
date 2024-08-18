package org.example.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.CategoryDao;
import org.example.entity.Category;

public class CategoryDaoImpl implements CategoryDao {

    private final EntityManagerFactory entityManagerFactory = Persistence.
            createEntityManagerFactory("jpa-hibernate-mysql");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void create(Category category) {
        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.getTransaction().commit();
    }

    @Override
    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }
}
