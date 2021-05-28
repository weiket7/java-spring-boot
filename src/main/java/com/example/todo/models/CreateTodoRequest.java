package com.example.todo.models;

import com.example.todo.exceptions.ApiException;
import com.example.todo.exceptions.TodoException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.util.ObjectUtils;

@Getter
@Setter
@NoArgsConstructor
public class CreateTodoRequest {
    private String name;

    @SneakyThrows
    public void validate() {
        if(ObjectUtils.isEmpty(name)) {
            throw new ApiException("CreateTodoRequest.Validate - Name is empty");
        }
    }
}
