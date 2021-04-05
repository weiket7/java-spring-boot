package com.example.todo;

import com.example.todo.models.CreateTodoRequest;
import com.example.todo.repository.TodoRepository;
import com.example.todo.services.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class TodoServiceTest {

    @Test
    public void Test() {
        TodoRepository todoRepository = mock(TodoRepository.class);
        TodoService todoService = new TodoService(todoRepository);
        CreateTodoRequest request = new CreateTodoRequest();
        request.setName("Buy eggs");
        todoService.create(request);
    }
}
