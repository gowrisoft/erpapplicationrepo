package com.gentech.erp.hr.exception;

public class EmptyUsernameException extends RuntimeException {
    public EmptyUsernameException(String message) {
        super(message);
    }
}