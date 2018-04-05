package com.endava.dao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTemplate {

    private DataSource source;

    public JdbcTemplate(DataSource source) {
        this.source = source;
    }

    public <T> void send(String query, T... ts) {

        try (Connection connection = source.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}