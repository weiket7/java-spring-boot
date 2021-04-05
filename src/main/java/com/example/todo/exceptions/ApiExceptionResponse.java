package com.example.todo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ApiExceptionResponse {

    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime timestamp;
}
