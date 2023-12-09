package org.example.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.ParkDao;
import org.example.entity.Park;

import java.util.Collection;
import java.util.Optional;

public class ParkDaoImpl implements ParkDao {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
    private final EntityManager entityManager = emf.createEntityManager();

    @Override
    public void create(Park park) {
        entityManager.getTransaction().begin();
        entityManager.persist(park);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Park park) {
        entityManager.getTransaction().begin();
        entityManager.merge(park);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        findById(id).ifPresent(park -> {
            entityManager.getTransaction().begin();
            entityManager.remove(park);
            entityManager.getTransaction().commit();
        });
    }

    @Override
    public Optional<Park> findById(Long id) {
        entityManager.clear();
        return Optional.ofNullable(entityManager.find(Park.class, id));
    }

    @Override
    public Collection<Park> findAll() {
        entityManager.clear();
        return entityManager.createQuery("select p from Park p", Park.class).getResultList();
    }
}