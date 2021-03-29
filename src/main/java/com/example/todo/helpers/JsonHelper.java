package com.example.todo.helpers;

import com.example.todo.exceptions.TodoException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class JsonHelper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public <T> T Serialize(String json, Class<T> target) {
        if(json == null) {
            throw new TodoException("JsonHelper::Serialize - Json is null");
        }

        try {
            return objectMapper.readValue(json, target);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new TodoException("JsonHelper::Serialize - Could not serialize into " + target.getName() + ", json = " + json);
        }
    }
}
