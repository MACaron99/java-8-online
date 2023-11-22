package org.example.service.imp;

import org.example.dao.ParkGarage;
import org.example.dao.imp.ParkGarageImp;
import org.example.entity.Park;
import org.example.service.ParkMechanic;

import java.util.Collection;

public class ParkMechanicImp implements ParkMechanic {

    private final ParkGarage parkGarage = new ParkGarageImp();

    @Override
    public void create(Park park) {
        parkGarage.create(park);
    }

    @Override
    public void update(Park park) {
        parkGarage.update(park);
    }

    @Override
    public void delete(Long id) {
        parkGarage.delete(id);
    }

    @Override
    public boolean exists(Long id) {
        return parkGarage.exists(id);
    }

    @Override
    public Collection<Park> findAll() {
        return parkGarage.findAll();
    }

    @Override
    public Collection<Park> findMany(Long[] ids) {
        return parkGarage.findMany(ids);
    }
}