package com.endava.dao;

//TODO Generic Dao
//TODO Done...

import java.io.Serializable;
import java.util.Collection;

public interface Dao<T, P extends Serializable>  {

    void insert(T u);

    T getById(P id);

    void delete(T u);

    boolean update(T u);

    Collection<T> getAll();
}
