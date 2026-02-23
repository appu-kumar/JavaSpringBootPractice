package com.mycmny.todo.controller;

import com.mycmny.todo.dto.request.CreateTodoRequest;
import com.mycmny.todo.dto.request.UpdateTodoRequest;
import com.mycmny.todo.dto.response.TodoResponse;
import com.mycmny.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // Create a todo → returns 201 Created
    @PostMapping
    public ResponseEntity<TodoResponse> createTodo(@RequestBody CreateTodoRequest todoRequest) {
        TodoResponse createdTodo = todoService.createTodo(todoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
    }

    // Get all todos → returns 200 OK
    @GetMapping
    public ResponseEntity<List<TodoResponse>> getAllTodos() {
        List<TodoResponse> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    // Get todo by ID → returns 200 OK, 404 if not found
    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> getTodoById(@PathVariable Long id) {
        TodoResponse todo = todoService.getTodoById(id);
        return ResponseEntity.ok(todo);
    }

    // Delete todo → returns 204 No Content, 404 if not found
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build(); // 204
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable Long id, @RequestBody UpdateTodoRequest updateTodoRequest){
        TodoResponse updatedTodo = this.todoService.updateTodo(id,updateTodoRequest);
        return ResponseEntity.ok(updatedTodo);
    }
}