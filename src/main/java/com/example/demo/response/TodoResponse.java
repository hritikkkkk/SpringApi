package com.example.demo.response;

import com.example.demo.model.Todo;

public class TodoResponse {
    private int  id;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    private String title;

    private int  userId;

    public int getUserId() {
        return userId;
    }

    public boolean isCompleted() {
        return completed;
    }

    private boolean completed;


    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.userId=todo.getUserId();
        this.completed=todo.getCompleted();


    }


}
