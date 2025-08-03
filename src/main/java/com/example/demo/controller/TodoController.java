package com.example.demo.controller;

import com.example.demo.DTO.TodoUpdateRequest;
import com.example.demo.api.TodoService;
import com.example.demo.error.ErrorResponse;
import com.example.demo.model.Todo;
import com.example.demo.response.TodoResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/todos")
public class TodoController {
    List<Todo> todoList;


    private TodoService service1;


    private TodoService service2;


    public TodoController(@Qualifier("fakeTodoService") TodoService service1,
                          @Qualifier("AnotherTodoService") TodoService service2
    ) {
        this.service1 = service1;
        this.service2 = service2;

        todoList = new ArrayList<>();
        todoList.add(new Todo(1, false, "todo1", 1));
        todoList.add(new Todo(2, true, "todo2", 2));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getAllTodos() {
        System.out.println("Incoming query params: " + this.service2.doSomething() + " " + this.service1.doSomething());
        return todoList;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@RequestBody Todo newTodo) {
        todoList.add(newTodo);
        return newTodo;

    }

    @GetMapping("/{todoId}")
    public ResponseEntity<?> getTodo(@PathVariable Long todoId) {
        for (Todo todo : todoList) {
            if (todo.getId() == todoId) {
                return ResponseEntity.ok(todo);
            }
        }
        ErrorResponse error = new ErrorResponse("Todo with ID " + todoId + " not found");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long todoId) {
        for (Todo todo : todoList) {
            if (todo.getId() == todoId) {
                todoList.remove(todo);
                ErrorResponse success = new ErrorResponse("Todo with ID " + todoId + " deleted successfully");
                return ResponseEntity.status(HttpStatus.OK).body(success);
            }
        }
        ErrorResponse error = new ErrorResponse("Todo with ID " + todoId + " not found");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @PatchMapping("/{todoId}")
    public ResponseEntity<?> updateTodo(@PathVariable Long todoId, @RequestBody TodoUpdateRequest request) {
        for (Todo todo : todoList) {
            if (todo.getId() == todoId) {
                request.applyUpdates(todo);
                return ResponseEntity.status(HttpStatus.OK).body(new TodoResponse(todo));
            }
        }
        ErrorResponse error = new ErrorResponse("Todo with ID " + todoId + " not found");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


}
