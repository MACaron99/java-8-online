package org.example.dao.imp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.ParkGarage;
import org.example.entity.Park;

import java.util.Collection;

public class ParkGarageImp implements ParkGarage {

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
    public void delete(Park park) {
        entityManager.getTransaction().begin();
        entityManager.remove(park);
        entityManager.getTransaction().commit();
    }

    @Override
    public Park findById(Long id) {
        return entityManager.find(Park.class, id);
    }

    @Override
    public Collection<Park> findAll() {
        return entityManager.createQuery("select p from Park p", Park.class).getResultList();
    }
}