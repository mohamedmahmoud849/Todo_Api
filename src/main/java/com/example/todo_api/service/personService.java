package com.example.todo_api.service;

import com.example.todo_api.ecxeptions.UserNotFoundException;
import com.example.todo_api.model.Person;
import com.example.todo_api.model.Role;
import com.example.todo_api.model.Todo;
import com.example.todo_api.repository.personRepo;
import com.example.todo_api.repository.todoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class personService {
    private final personRepo personRepo;
    private final todoRepo todoRepo;
    private final PasswordEncoder passwordEncoder;

    public Person findById(Long id){
        if(personRepo.findById(id).isPresent()){
            return personRepo.findById(id).get();
        }else {
            throw new UserNotFoundException("This user with id : " + id.toString() + " Not found");

        }
    }
    public List<Person> findAll(){
        return personRepo.findAll();
    }

    public List<Todo> findAllPersonTodos(Long id){
        return personRepo.findById(id).get().getTodos();
    }
    public void insert(Person person){
        personRepo.save(
        Person.builder()
                .name(person.getName())
                .username(person.getUsername())
                .password(passwordEncoder.encode(person.getPassword()))
                .todos(person.getTodos())
                .role(Role.USER)
                .build());
    }
    public void update(Person person){

        personRepo.saveAndFlush(
                Person.builder()
                        .name(person.getName())
                        .username(person.getUsername())
                        .password(passwordEncoder.encode(person.getPassword()))
                        .todos(person.getTodos())
                        .role(Role.USER)
                        .build());
    }

    public void delete(Long id){
        personRepo.delete(findById(id));
    }




}
