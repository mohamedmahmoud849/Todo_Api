package com.example.todo_api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "person")
    @JsonManagedReference
    private List<Todo> todos;
    @Enumerated(EnumType.STRING)
    private Role role;
}
