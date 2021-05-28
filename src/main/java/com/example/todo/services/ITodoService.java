package com.example.todo.services;

import com.example.todo.entities.TodoEntity;
import com.example.todo.models.CreateTodoRequest;
import com.example.todo.models.DeleteTodoRequest;

import java.util.List;
import java.util.Optional;

public interface ITodoService {
    List<TodoEntity> list();

    void create(CreateTodoRequest request);

    Optional<TodoEntity> get(Long id);

    void delete(DeleteTodoRequest request);
}
