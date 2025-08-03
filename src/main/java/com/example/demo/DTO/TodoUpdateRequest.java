package com.example.demo.DTO;

import com.example.demo.model.Todo;

public class TodoUpdateRequest {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    private String title;
    private Boolean completed;
    private Integer userId;

    public void applyUpdates(Todo todo) {
        if (title != null) todo.setTitle(title);
        if (completed != null) todo.setCompleted(completed);
        if (userId != null) todo.setUserId(userId);
    }


}
