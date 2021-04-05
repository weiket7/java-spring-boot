package com.example.todo;

import com.example.todo.exceptions.TodoException;
import com.example.todo.models.CreateTodoRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateTodoRequestTest {

    @Test
    public void CreateTodoRequest_Validate_ThrowsException() {
        CreateTodoRequest request = new CreateTodoRequest();
        TodoException ex = Assertions.assertThrows(TodoException.class, () -> {
            request.validate();
        });
    }

    @Test
    public void CreateTodoRequest_Validate_DoesNotThrowException() {
        CreateTodoRequest request = new CreateTodoRequest();
        request.setName("Tim");
        Assertions.assertDoesNotThrow(() -> {
            request.validate();
        });
    }
}
