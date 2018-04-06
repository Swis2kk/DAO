package com.endava.source;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataSourceFactory {

    private DataSourceFactory (){}

    //TODO parameters with type of db
    public static MysqlDataSource createMySqlDataSource() {
        Properties properties = new Properties();
        FileInputStream fis;
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        try {
            fis = new FileInputStream("src/main/resources/db.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mysqlDataSource.setURL(properties.getProperty("MYSQL_DB_URL"));
        mysqlDataSource.setUser(properties.getProperty("MYSQL_DB_USERNAME"));
        mysqlDataSource.setPassword(properties.getProperty("MYSQL_DB_PASSWORD"));
        return mysqlDataSource;
    }
}
