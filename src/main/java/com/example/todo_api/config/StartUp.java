package com.example.todo_api.config;

import com.example.todo_api.model.Person;
import com.example.todo_api.model.Todo;
import com.example.todo_api.service.personService;
import com.example.todo_api.service.todoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StartUp implements CommandLineRunner {
    private final personService personService;
    private final todoService todoService;
    @Override
    public void run(String... args) throws Exception {
        if(personService.findAll().isEmpty()){
            personService.insert(Person.builder()
                    .name("mohamed")
                    .username("moo")
                    .password("123")
                    .build());
            personService.insert(Person.builder()
                    .name("ahmed")
                    .username("hamada")
                    .password("123")
                    .build());
            personService.insert(Person.builder()
                    .name("abdo")
                    .username("bido")
                    .password("123")
                    .build());
        }
        if(todoService.findAll().isEmpty()){
            todoService.insert(Todo.builder()
                            .title("work")
                            .body("have to go to work early tmrw")
                            .creationTime(new Date())
                            .done(false)
                            .person(personService.findById(1L))
                    .build());
            todoService.insert(Todo.builder()
                    .title("home")
                    .body("have to clean home before mama comes")
                    .creationTime(new Date())
                    .done(false)
                    .person(personService.findById(1L))
                    .build());
            todoService.insert(Todo.builder()
                    .title("football")
                    .body("there's match at 10 in la")
                    .creationTime(new Date())
                    .done(false)
                    .person(personService.findById(2L))
                    .build());
            todoService.insert(Todo.builder()
                    .title("study")
                    .body("have to study hard chapter 3 in math book cause of the exam")
                    .creationTime(new Date())
                    .done(false)
                    .person(personService.findById(2L))
                    .build());
            todoService.insert(Todo.builder()
                    .title("water")
                    .body("drink water")
                    .creationTime(new Date())
                    .done(false)
                    .person(personService.findById(3L))
                    .build());
        }

        }
        }

