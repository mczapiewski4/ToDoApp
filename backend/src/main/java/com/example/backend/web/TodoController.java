package com.example.backend.web;

import com.example.backend.domain.TodoItem;
import com.example.backend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/api/todoItems")
    public ResponseEntity<?> fetchAllTodoItems() {
        List<TodoItem> todoItems = todoService.fetchAllTodoItems();

        return  ResponseEntity.ok(todoItems);
    }

    @PostMapping("/api/todoItems")
    public ResponseEntity<?> createNewTodoItem() {
        TodoItem todoItem = todoService.createTodoItem();

        return  ResponseEntity.ok(todoItem);
    }

    @PutMapping("/api/todoItems/{id}")
    public ResponseEntity<?> updateTodoItem(@PathVariable Integer id, @RequestBody TodoItem todoItem) {
        TodoItem updatedTodoItem = todoService.updateTodoItem(id, todoItem);

        return ResponseEntity.ok(updatedTodoItem);
    }

    @DeleteMapping("/api/todoItems/{id}")
    public ResponseEntity<?> deleteTodoItem(@PathVariable Integer id) {
        todoService.deleteTodoItem(id);

        return ResponseEntity.ok("ok");
    }
}
