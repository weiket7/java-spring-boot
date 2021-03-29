package com.example.todo.controllers;

import com.example.todo.apis.TodoApi;
import com.example.todo.entities.TodoEntity;
import com.example.todo.exceptions.ApiException;
import com.example.todo.models.CreateTodoRequest;
import com.example.todo.models.Todo;
import com.example.todo.services.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("api/todo")
@RestController
public class TodoController {
    @Autowired
    private ITodoService todoService;

    @Autowired
    private TodoApi todoApi;

    @GetMapping("list")
    public List<TodoEntity> list() {
        return todoService.list();
    }

    @PostMapping("create")
    public void create(@RequestBody CreateTodoRequest request) {
        todoService.create(request);
    }

    @GetMapping("get")
    public Todo get(@RequestParam Long id) throws ApiException {
        return todoApi.get(id);
    }
}
