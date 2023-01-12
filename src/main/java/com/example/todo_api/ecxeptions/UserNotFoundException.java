package com.example.todo_api.ecxeptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
