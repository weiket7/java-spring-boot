package com.example.todo.controllers;

import com.example.todo.entities.TodoEntity;
import com.example.todo.models.CreateTodoRequest;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/todo")
@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("list")
    public List<TodoEntity> list() {
        return todoRepository.findAll();
    }

    @PostMapping("create")
    public void create(@RequestBody CreateTodoRequest request) {
        TodoEntity todo = new TodoEntity(request.getName());
        todoRepository.save(todo);
    }

//    @RequestMapping("get/{id}")
//    public Optional<TodoEntity> get(@PathVariable(value="id") Long id) {

    @GetMapping("get")
    public Optional<TodoEntity> get(@RequestParam Long id) {
        return todoRepository.findById(id);
    }
}
