package com.example.todo_api.controller;

import com.example.todo_api.model.Person;
import com.example.todo_api.model.Todo;
import com.example.todo_api.service.todoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class todoController {
    private final todoService todoService;
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(todoService.findById(id));
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(todoService.findAll());
    }
    @PostMapping
    public void insert(@RequestBody Todo todo){
        todoService.insert(todo);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        todoService.delete(id);
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Todo todo){
        return ResponseEntity.ok(todoService.update(todo));
    }

}
