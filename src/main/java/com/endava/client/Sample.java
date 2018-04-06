package com.endava.client;

import com.endava.dao.Dao;
import com.endava.dao.JdbcDaoUser;
import com.endava.dao.JdbcTemplate;
import com.endava.dataHolder.User;
import com.endava.source.ConnectionMySql;

public class Sample {

    public static void main(String[] args){

        Dao<User> userDao = new JdbcDaoUser(new JdbcTemplate(new ConnectionMySql().getDataSource()));

        User user = new User.Builder(12, "Dima", "Ned").build();

        //userDao.insert(user);

        userDao.delete(user);


    }
}
