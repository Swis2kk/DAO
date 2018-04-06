package com.endava.dao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTemplate <T>{

    private final DataSource ds;

    public JdbcTemplate(DataSource ds) {
        this.ds = ds;
    }

    public void send(String query, T... ts) {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            int index = 1;
            for (T e : ts) {
                ps.setObject(index, e);
                index++;
            }

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}