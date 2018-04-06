package com.endava.dao;

import com.endava.dataHolder.User;

import java.util.Collection;

public class JdbcDaoUser implements Dao<User> {

    private final JdbcTemplate jdbcTemplate;

    public JdbcDaoUser(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(User u) {
        String q = "INSERT INTO users (userID, lastName, firstName) VALUES (?, ?, ?);";
        jdbcTemplate.send(q, u.getId(), u.getNameFirst(), u.getNameLast());
    }

    public User getById(User u) {
        return null;
    }

    public void delete(User u) {
        String q = "DELETE FROM users WHERE userID=(?)";
        jdbcTemplate.send(q, u.getId());
    }

    public boolean update(User u) {
        return false;
    }

    public Collection<User> getAll() {
        return null;
    }
}
