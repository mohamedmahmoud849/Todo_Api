package com.example.todo_api.controller;

import com.example.todo_api.model.Person;
import com.example.todo_api.model.Todo;
import com.example.todo_api.service.personService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class personController {
    private final personService personService;
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(personService.findById(id));
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(personService.findAll());
    }
    @GetMapping("/todos/{id}")
    public ResponseEntity<?> findAllPersonTodo(@PathVariable Long id){
        return ResponseEntity.ok(personService.findAllPersonTodos(id));
    }
    @PostMapping
    public void insert(@RequestBody Person person){
        personService.insert(person);
    }

    @PutMapping
    public void update(@RequestBody Person person){
        personService.insert(person);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        personService.delete(id);
    }
}
