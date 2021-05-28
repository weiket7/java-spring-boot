package com.example.todo.controllers;

import com.example.todo.entities.TodoEntity;
import com.example.todo.exceptions.ApiException;
import com.example.todo.models.CreateTodoRequest;
import com.example.todo.models.DeleteTodoRequest;
import com.example.todo.services.ITodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/todo")
@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {
    @Autowired
    private ITodoService todoService;

    @GetMapping("list")
    public List<TodoEntity> list() {
        //throw new ApiException("MY CUSTOM EXCEPTION MESSAGE");
        return todoService.list();
    }

    @PostMapping("create")
    public void create(@RequestBody CreateTodoRequest request) {
        todoService.create(request);
    }

    @PostMapping("delete")
    public void create(@RequestBody DeleteTodoRequest request) {
        todoService.delete(request);
    }

    @GetMapping("get")
    public Optional<TodoEntity> get(@ RequestParam Long id) throws ApiException {
        return todoService.get(id);
    }


}
