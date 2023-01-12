package com.example.todo_api.service;

import com.example.todo_api.ecxeptions.NoPersonAddedException;
import com.example.todo_api.model.Person;
import com.example.todo_api.model.Todo;
import com.example.todo_api.repository.personRepo;
import com.example.todo_api.repository.todoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class todoService {
    private final todoRepo todoRepo;

    public Todo findById(Long id){
        return todoRepo.findById(id).get();
    }
    public List<Todo> findAll(){
        return todoRepo.findAll();
    }
    public void insert(Todo todo){
        if(todo.getPerson()!=null&&todo.getPerson().getId()!=null){
            todo.setCreationTime(new Date());
            todoRepo.save(todo);
        }else{
            throw new NoPersonAddedException("please add a Person to the todo");
        }

    }
    public Todo update(Todo todo){
        if(todo.isDone()){
           todo.setFinishedTime(new Date());
        }

        return todoRepo.save(todo);
    }
    public void delete(Long id){
        todoRepo.delete(findById(id));
    }
}
