package com.example.todo.apis;

import com.example.todo.exceptions.ApiException;
import com.example.todo.helpers.ConfigHelper;
import com.example.todo.helpers.HttpClient;
import com.example.todo.models.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Primary
@Slf4j
public class TodoApi {
    @Autowired
    private ConfigHelper configHelper;

    @Autowired
    private HttpClient httpClient;

    private String baseUrl;

    @PostConstruct
    public void Init() {
        baseUrl = configHelper.getConfig("todo.baseUrl");
    }

    public Todo get(Long id) {
        String url = baseUrl + configHelper.getConfig("todo.get");
        log.info("baseUrl = " + url);
        return httpClient.get(url + id, Todo.class);
    }

}
