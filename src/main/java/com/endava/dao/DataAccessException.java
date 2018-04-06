package com.endava.dao;

public class DataAccessException extends RuntimeException {
    public DataAccessException(String message, Throwable e) {
        super(message, e);
    }
}
