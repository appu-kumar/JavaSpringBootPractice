package com.mycmny.todo.dto.request;

public class UpdateTodoRequest {
    private String text;
    private Boolean completed;

    // getters and setters
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Boolean getCompleted() {
        return completed;
    }
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
