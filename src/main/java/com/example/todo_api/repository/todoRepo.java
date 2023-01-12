package com.example.todo_api.repository;

import com.example.todo_api.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface todoRepo extends JpaRepository<Todo,Long> {
}
