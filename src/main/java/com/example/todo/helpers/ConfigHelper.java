package com.example.todo.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class ConfigHelper {
    @Autowired
    private Environment env;

    public String getConfig(String key){
        return env.getProperty(key);
    }
}
