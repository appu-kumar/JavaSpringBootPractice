package com.mycmny.todo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity  // spring check this annotation and create the table in db with class name
@Table(name="todos") // optional if you want to give specific name to the table
public class Todo {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String text;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;
     private Boolean completed;

    public Todo() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }
}
