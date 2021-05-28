package com.example.todo.services;

import com.example.todo.entities.TodoEntity;
import com.example.todo.exceptions.ApiException;
import com.example.todo.models.CreateTodoRequest;
import com.example.todo.models.DeleteTodoRequest;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class TodoService implements ITodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoEntity> list() {
        return todoRepository.findAll();
    }

    public void create(CreateTodoRequest request) {
        request.validate();
        TodoEntity todo = new TodoEntity(request.getName());
        todoRepository.save(todo);
    }



    public Optional<TodoEntity> get(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void delete(DeleteTodoRequest request) {
        Optional<TodoEntity> todo = this.get(request.getId());
        if(todo.isPresent() == false) {
            throw new ApiException("");
        }

        todoRepository.delete(todo.get());
    }
}
