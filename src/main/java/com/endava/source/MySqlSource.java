package com.endava.source;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MySqlSource {

    public static MysqlDataSource getDataSource() {
        MysqlDataSource mysqlDataSource = null;
        Properties properties = new Properties();
        FileInputStream file;

        try {
            file = new FileInputStream("src/resources/db.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(properties.getProperty("MYSQL_DB_URL"));
        mysqlDataSource.setUser(properties.getProperty("MYSQL_DB_USERNAME"));
        mysqlDataSource.setPassword(properties.getProperty("MYSQL_DB_PASSWORD"));

        return mysqlDataSource;
    }

}
