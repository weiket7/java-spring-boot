package com.example.todo.repository;

import com.example.todo.entities.TodoEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Primary
public interface TodoRepository extends CrudRepository<TodoEntity, Long> {
    TodoEntity findById(long id);
    List<TodoEntity> findAll();
}
