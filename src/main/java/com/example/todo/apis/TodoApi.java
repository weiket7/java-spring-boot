package com.example.todo.apis;

import com.example.todo.exceptions.ApiException;
import com.example.todo.helpers.HttpClient;
import com.example.todo.helpers.JsonHelper;
import com.example.todo.models.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Slf4j
public class TodoApi {

    @Autowired
    private JsonHelper jsonHelper;

    @Autowired
    private HttpClient httpClient;

    public Todo get(Long id) throws ApiException {
        return httpClient.get("https://jsonplaceholder.typicode.com/todos/" + id, Todo.class);
    }

}
