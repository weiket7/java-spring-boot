package com.example.todo.exceptions;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }

}
