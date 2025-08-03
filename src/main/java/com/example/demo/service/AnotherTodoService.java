package com.example.demo.service;

import com.example.demo.api.TodoService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("AnotherTodoService")
public class AnotherTodoService implements TodoService {
    @Override
    public String doSomething() {
       return "something from another todo service";
    }
}
