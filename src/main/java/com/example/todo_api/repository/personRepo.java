package com.example.todo_api.repository;

import com.example.todo_api.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface personRepo extends JpaRepository<Person,Long> {

    Optional<Person> findByUsername(String username);
}
