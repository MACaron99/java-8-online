package org.example.dao.imp;

import org.example.dao.CarParkGarage;
import org.example.entity.CarPark;
import org.example.factory.JdbcFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class CarParkGarageImp implements CarParkGarage<CarPark> {

    private final JdbcFactory jdbcFactory = JdbcFactory.getInstance();

    private static final String CREATE = "insert into car_parks values (?, ?)";
    private static final String DELETE_BY_CAR_ID = "delete from car_parks where car_id = ?";
    private static final String DELETE_BY_PARK_ID = "delete from car_parks where park_id = ?";
    private static final String DELETE_BY_CAR_AND_PARK_ID = "delete from car_parks where car_id = ? and park_id = ?";
    private static final String FIND_BY_CAR_ID = "select * from car_parks where car_id = ";
    private static final String FIND_BY_PARK_ID = "select * from car_parks where park_id = ";
    private static final String FIND_ONE_BY_CAR_ID = "select * from car_parks where car_id = ";
    private static final String FIND_ONE_BY_PARK_ID = "select * from car_parks where park_id = ";
    private static final String FIND_ONE_BY_CAR_AND_PARK_ID = "select * from car_parks where car_id = ? and park_id = ?";

    @Override
    public void create(CarPark carPark) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(CREATE)) {
            ps.setLong(1, carPark.getParkId());
            ps.setLong(2, carPark.getCarId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteByCarId(Long carId) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(DELETE_BY_CAR_ID)) {
            ps.setLong(1, carId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteByParkId(Long parkId) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(DELETE_BY_PARK_ID)) {
            ps.setLong(1, parkId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteByCarAndParkId(Long carId, Long parkId) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(DELETE_BY_CAR_AND_PARK_ID)) {
            ps.setLong(1, carId);
            ps.setLong(2, parkId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Collection<CarPark> findByCarId(Long id) {
        Collection<CarPark> carParks = new ArrayList<>();
        try (PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(FIND_BY_CAR_ID + id)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                carParks.add(generate(rs));
            }
            return carParks;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Collection<CarPark> findByParkId(Long id) {
        Collection<CarPark> carParks = new ArrayList<>();
        try (PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(FIND_BY_PARK_ID + id)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                carParks.add(generate(rs));
            }
            return carParks;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public CarPark findOneByCarId(Long id) {
        try(ResultSet rs = jdbcFactory.getStatement().executeQuery(FIND_ONE_BY_CAR_ID + id)) {
            rs.next();
            return generate(rs);
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return null;
    }

    @Override
    public CarPark findOneByParkId(Long id) {
        try(ResultSet rs = jdbcFactory.getStatement().executeQuery(FIND_ONE_BY_PARK_ID + id)) {
            rs.next();
            return generate(rs);
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return null;
    }

    @Override
    public CarPark findByCarAndParkId(Long carId, Long parkId) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(FIND_ONE_BY_CAR_AND_PARK_ID)) {
            ps.setLong(1, carId);
            ps.setLong(2, parkId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return generate(rs);
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return null;
    }

    private CarPark generate(ResultSet rs) throws SQLException {
        CarPark carPark = new CarPark();
        carPark.setParkId(rs.getLong("park_id"));
        carPark.setCarId(rs.getLong("car_id"));
        return carPark;
    }
}
