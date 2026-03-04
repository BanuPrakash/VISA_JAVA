package com.visa.prj.dao;

public class PeristenceException extends Exception{
    public PeristenceException() {
    }

    public PeristenceException(String message) {
        super(message);
    }

    public PeristenceException(Throwable cause) {
        super(cause);
    }

    public PeristenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
