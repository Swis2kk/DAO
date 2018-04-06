package com.endava.dao;

import com.endava.dataHolder.User;

import java.sql.SQLException;
import java.util.Collection;

public class JdbcUserDao implements Dao<User, Integer> {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(User u) {
        String q = "INSERT INTO users (userID, lastName, firstName) VALUES (?, ?, ?);";
        jdbcTemplate.update(q, u.getId(), u.getNameFirst(), u.getNameLast());
    }

    public User getById(Integer id) {
        String q = "SELECT userId, lastName, firstName FROM users where userId = ?";

        return jdbcTemplate.query(q, resultSet -> {
                    try {
                        resultSet.next();
                        return new User.Builder(resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3))
                                .build();
                    } catch (SQLException e) {
                        throw new DataAccessException("Unreadable to read result set", e);
                    }
                }
                , id);
    }

    public void delete(User u) {
        String q = "DELETE FROM users WHERE userID=(?)";
        jdbcTemplate.update(q, u.getId());
    }

    public boolean update(User u) {
        return false;
    }

    public Collection<User> getAll() {
        return null;
    }
}
