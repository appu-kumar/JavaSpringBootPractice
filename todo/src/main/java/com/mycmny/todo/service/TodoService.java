package com.mycmny.todo.service;

import com.mycmny.todo.dto.request.CreateTodoRequest;
import com.mycmny.todo.dto.request.UpdateTodoRequest;
import com.mycmny.todo.dto.response.TodoResponse;

import java.util.List;

public interface TodoService {
    TodoResponse createTodo(CreateTodoRequest request);
    List<TodoResponse> getAllTodos();
    TodoResponse getTodoById(Long id);
    void deleteTodo(Long id);
    TodoResponse updateTodo(Long id, UpdateTodoRequest updateTodoRequest);
}
