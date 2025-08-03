package com.example.demo.service;

import com.example.demo.api.TodoService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("fakeTodoService")
public class FakeTodoService implements TodoService {

    @Override
    public String doSomething() {
      return "something from fake todo service";
    }
}
