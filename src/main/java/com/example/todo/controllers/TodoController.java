package com.example.todo.controllers;

import com.example.todo.entities.TodoEntity;
import com.example.todo.models.CreateTodoRequest;
import com.example.todo.services.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/todo")
@RestController
public class TodoController {
    @Autowired
    private ITodoService todoService;

    @GetMapping("list")
    public List<TodoEntity> list() {
        return todoService.list();
    }

    @PostMapping("create")
    public void create(@RequestBody CreateTodoRequest request) {
        todoService.create(request);
    }

    @GetMapping("get")
    public Optional<TodoEntity> get(@RequestParam Long id) {
        return todoService.get(id);
    }
}
