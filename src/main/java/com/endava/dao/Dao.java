package com.endava.dao;

//TODO Generic Dao
//TODO Done...

import java.util.Collection;

public interface Dao<T> {
     void create(T u);
     T getById(T id);
     boolean delete(T u);
     boolean update(T u);
     Collection<T> getAll();
}
