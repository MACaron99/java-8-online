package org.example.service.impl;

import org.example.dao.ParkDao;
import org.example.dao.impl.ParkDaoImpl;
import org.example.entity.Park;
import org.example.service.ParkService;

import java.util.Collection;
import java.util.Optional;

public class ParkServiceImpl implements ParkService {

    private final ParkDao parkDao = new ParkDaoImpl();

    @Override
    public void create(Park park) {
        parkDao.create(park);
    }

    @Override
    public void update(Park park) {
        parkDao.update(park);
    }

    @Override
    public void delete(Long id) {
        parkDao.delete(id);
    }

    @Override
    public Optional<Park> findById(Long id) {
        return parkDao.findById(id);
    }

    @Override
    public Collection<Park> findAll() {
        return parkDao.findAll();
    }
}