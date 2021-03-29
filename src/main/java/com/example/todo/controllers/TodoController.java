package com.example.todo.controllers;

import com.example.todo.models.CreateTodoRequest;
import com.example.todo.models.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/todo")
@RestController
public class TodoController {
    private static List<Todo> todos;

    public TodoController() {
        todos = new ArrayList<>();
        todos.add(new Todo("Buy eggs"));
    }

    @GetMapping("list")
    public List<Todo> list() {
        return todos;
    }

    @PostMapping("create")
    public void create(@RequestBody CreateTodoRequest request) {
        todos.add(new Todo(request.getName()));
    }
}
