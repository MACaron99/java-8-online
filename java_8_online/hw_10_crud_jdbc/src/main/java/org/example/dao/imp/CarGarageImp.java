package org.example.dao.imp;

import org.example.dao.CarGarage;
import org.example.entity.Car;
import org.example.factory.JdbcFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class CarGarageImp implements CarGarage {

    private final JdbcFactory jdbcFactory = JdbcFactory.getInstance();

    private static final String CREATE = "insert into cars values (default, ?, ?, ?)";
    private static final String UPDATE = "update cars set brand = ?, model = ?, age = ? where id = ?";
    private static final String DELETE = "delete from cars where id = ?";
    private static final String EXISTS = "select count(id) as count_of_cars from cars where id = ";
    private static final String FIND_ALL = "select * from cars";
    private static final String FIND_MANY = "select * from cars where id in (";

    @Override
    public void create(Car car) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(CREATE)) {
            ps.setString(1, car.getCarBrand());
            ps.setString(2, car.getCarModel());
            ps.setInt(3, car.getCarYear());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Car car) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(UPDATE)) {
            ps.setString(1, car.getCarBrand());
            ps.setString(2, car.getCarModel());
            ps.setInt(3, car.getCarYear());
            ps.setLong(4, car.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(DELETE)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean exists(Long id) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(EXISTS + id)) {
            ResultSet rs = ps.executeQuery();
            rs.next();
            long count = rs.getLong("count_of_cars");
            return count == 1;
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return false;
    }

    @Override
    public Collection<Car> findAll() {
        Collection<Car> cars = new ArrayList<>();
        try (PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cars.add(generate(rs));
            }
            return cars;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Collection<Car> findMany(Long[] ids) {
        StringBuilder sb = new StringBuilder(FIND_MANY);
        for (int i = 0; i < ids.length; i++) {
            sb.append("?");
            if (i < ids.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        Collection<Car> cars = new ArrayList<>();
        try (PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(sb.toString())) {
            for (int i = 0; i < ids.length; i++) {
                ps.setLong(i + 1, ids[i]);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cars.add(generate(rs));
            }
            return cars;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Car generate(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setId(rs.getLong("id"));
        car.setCarBrand(rs.getString("brand"));
        car.setCarModel(rs.getString("model"));
        car.setCarYear(rs.getInt("age"));
        return car;
    }
}