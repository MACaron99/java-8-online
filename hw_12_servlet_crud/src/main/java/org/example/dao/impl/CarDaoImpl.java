package org.example.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.CarDao;
import org.example.entity.Car;

import java.util.Collection;
import java.util.Optional;

public class CarDaoImpl implements CarDao {

    private final EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("jpa-hibernate-mysql");
    private final EntityManager entityManager = emf.createEntityManager();

    @Override
    public void create(Car car) {
        entityManager.getTransaction().begin();
        entityManager.persist(car);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Car car) {
        entityManager.getTransaction().begin();
        entityManager.merge(car);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        findById(id).ifPresent(car -> {
            entityManager.getTransaction().begin();
            entityManager.remove(car);
            entityManager.getTransaction().commit();
        });
    }

    @Override
    public Optional<Car> findById(Long id) {
        entityManager.clear();
        return Optional.ofNullable(entityManager.find(Car.class, id));
    }

    @Override
    public Collection<Car> findAll() {
        entityManager.clear();
        return entityManager.createQuery("select c from Car c", Car.class).getResultList();
    }
}
