package com.endava.dao;

import com.endava.dataHolder.User;

import java.sql.SQLException;
import java.util.Collection;

public class JdbcUserDao implements Dao<User, Integer> {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(User user) {
        String queryString = "INSERT INTO users (userID, lastName, firstName) VALUES (?, ?, ?);";
        //TODO jdbcTemplate.update(queryString, user, lambda gets preparedStatement consumer);
        jdbcTemplate.update(queryString, user.getId(), user.getNameFirst(), user.getNameLast());
    }

    //TODO querylist, add optional
    public User getById(Integer id) {
        String queryString = "SELECT userId, lastName, firstName FROM users where userId = ?";

        return jdbcTemplate.query(queryString, resultSet -> {
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
