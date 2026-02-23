package com.mycmny.todo.dto.response;

public class TodoResponse {
    private final Long id;
    private final String text;
    private final Boolean completed;

    public Long getId() {
        return id;
    }

    public TodoResponse(Long id, String text, Boolean completed) {
        this.id = id;
        this.text = text;
        this.completed = completed;
    }

    public String getText() {
        return text;
    }

    public Boolean getCompleted() {
        return completed;
    }
}

