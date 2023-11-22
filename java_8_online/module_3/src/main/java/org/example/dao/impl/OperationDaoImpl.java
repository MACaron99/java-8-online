package org.example.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.OperationDao;
import org.example.entity.Operation;


public class OperationDaoImpl implements OperationDao {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void create(Operation operation) {
        entityManager.getTransaction().begin();
        entityManager.persist(operation);
        entityManager.getTransaction().commit();
    }
}
