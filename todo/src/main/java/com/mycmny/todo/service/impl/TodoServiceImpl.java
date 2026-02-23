package com.mycmny.todo.service.impl;

import com.mycmny.todo.dto.request.CreateTodoRequest;
import com.mycmny.todo.dto.request.UpdateTodoRequest;
import com.mycmny.todo.dto.response.TodoResponse;
import com.mycmny.todo.entity.Todo;
import com.mycmny.todo.repository.TodoRepository;
import com.mycmny.todo.service.TodoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    private TodoResponse mapToResponse(Todo todo) {
        return new TodoResponse(
                todo.getId(),
                todo.getText(),
                todo.getCompleted()
        );
    }

    @Override
    public TodoResponse createTodo(CreateTodoRequest request) {
           Todo todo = new Todo();
           todo.setText(request.getText());
           todo.setCompleted(false);
           todo.setCreatedAt(LocalDateTime.now());
           todo.setUpdatedAt(LocalDateTime.now());
           Todo saved = this.todoRepository.save(todo);
           return new TodoResponse(saved.getId(), saved.getText(),saved.getCompleted());
    }

    @Override
    public List<TodoResponse> getAllTodos() {
        List<Todo> todos = this.todoRepository.findAll();
        List<TodoResponse> allTodosResponse = new ArrayList<>();
        // we can not directly written becasue entity and TodoResponse is totally different
        for(Todo todo:todos){
            allTodosResponse.add(this.mapToResponse(todo));
        }

        return allTodosResponse;
    }

    @Override
    public TodoResponse getTodoById(Long id) {
        return this.todoRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));
    }

    @Override
    public void deleteTodo(Long id) {
        Todo todo = this.todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        this.todoRepository.delete(todo);
    }

    @Override
    public TodoResponse updateTodo(Long id, UpdateTodoRequest updateTodoRequest){
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));

        todo.setCompleted(updateTodoRequest.getCompleted());
        todo.setText(updateTodoRequest.getText());
        todo.setUpdatedAt(LocalDateTime.now());

        Todo savedTodo = this.todoRepository.save(todo);
        return this.mapToResponse(savedTodo);
    }
}
