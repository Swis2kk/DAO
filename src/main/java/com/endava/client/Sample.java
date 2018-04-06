package com.endava.client;

import com.endava.dao.Dao;
import com.endava.dao.JdbcUserDao;
import com.endava.dao.JdbcTemplate;
import com.endava.dataHolder.User;
import com.endava.source.ConnectionMySql;

public class Sample {

    public static void main(String[] args){

        Dao<User, Integer> userDao = new JdbcUserDao(new JdbcTemplate(new ConnectionMySql().getDataSource()));

        User user = new User.Builder(12, "Dima", "Ned").build();

        //userDao.insert(user);

        //userDao.delete(user);

        System.out.println(userDao.getById(10));
    }
}
