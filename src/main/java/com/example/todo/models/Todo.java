package com.example.todo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Todo {
    private Long id;
    private Long userId;
    private String title;
    private Boolean completed;
}
