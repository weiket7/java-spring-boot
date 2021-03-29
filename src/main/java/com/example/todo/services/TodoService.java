package com.example.todo.services;

import com.example.todo.entities.TodoEntity;
import com.example.todo.models.CreateTodoRequest;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class TodoService implements ITodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<TodoEntity> list() {
        return todoRepository.findAll();
    }

    public void create(CreateTodoRequest request) {
        TodoEntity todo = new TodoEntity(request.getName());
        todoRepository.save(todo);
    }

    public Optional<TodoEntity> get(Long id) {
        return todoRepository.findById(id);
    }
}
