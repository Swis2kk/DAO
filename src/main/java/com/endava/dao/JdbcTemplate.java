package com.endava.dao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

public class JdbcTemplate {

    private final DataSource dataSource;

    public JdbcTemplate(DataSource ds) {
        this.dataSource = ds;
    }

    public void update(String query, Object... args) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("Unable to execute update operation", e);
        }
    }

    public <T> T query(String query, Function<ResultSet, T> mapper, Object... arguments) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {


            for (int i = 0; i < arguments.length; i++) {
                statement.setObject(i + 1, arguments[i]);
            }
            ResultSet resultSet = statement.executeQuery();
            return mapper.apply(resultSet);

        } catch (SQLException e) {
            throw new DataAccessException("Unable to execute query operation", e);
        }
    }
}