package org.example.dao.imp;

import org.example.dao.ParkGarage;
import org.example.entity.Park;
import org.example.factory.JdbcFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ParkGarageImp implements ParkGarage {

    private final JdbcFactory jdbcFactory = JdbcFactory.getInstance();

    private static final String CREATE = "insert into parks values (default, ?)";
    private static final String UPDATE = "update parks set name = ? where id = ?";
    private static final String DELETE = "delete from parks where id = ?";
    private static final String EXISTS = "select count(id) as count_of_parks from parks where id = ";
    private static final String FIND_ALL = "select * from parks";
    private static final String FIND_MANY = "select * from parks where id in (";

    @Override
    public void create(Park park) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(CREATE)) {
            ps.setString(1, park.getParkName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Park park) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(UPDATE)) {
            ps.setString(1, park.getParkName());
            ps.setLong(4, park.getId());
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
            long count = rs.getLong("count_of_parks");
            return count == 1;
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return false;
    }

    @Override
    public Collection<Park> findAll() {
        Collection<Park> parks = new ArrayList<>();
        try (PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                parks.add(generate(rs));
            }
            return parks;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Collection<Park> findMany(Long[] ids) {
        StringBuilder sb = new StringBuilder(FIND_MANY);
        for (int i = 0; i < ids.length; i++) {
            sb.append("?");
            if (i < ids.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        Collection<Park> parks = new ArrayList<>();
        try (PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(sb.toString())) {
            for (int i = 0; i < ids.length; i++) {
                ps.setLong(i + 1, ids[i]);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                parks.add(generate(rs));
            }
            return parks;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Park generate(ResultSet rs) throws SQLException {
        Park park = new Park();
        park.setId(rs.getLong("id"));
        park.setParkName(rs.getString("name"));
        return park;
    }
}