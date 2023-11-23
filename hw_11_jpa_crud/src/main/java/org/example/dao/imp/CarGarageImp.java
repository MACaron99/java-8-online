package org.example.dao.imp;

import jakarta.persistence.*;
import org.example.dao.CarGarage;
import org.example.entity.Car;

import java.util.Collection;

public class CarGarageImp implements CarGarage {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
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
    public void delete(Car car) {
        entityManager.getTransaction().begin();
        entityManager.remove(car);
        entityManager.getTransaction().commit();
    }

    @Override
    public Car findById(Long id) {
        return entityManager.find(Car.class, id);
    }

    @Override
    public Collection<Car> findAll() {
        return entityManager.createQuery("select c from Car c", Car.class).getResultList();
    }
}