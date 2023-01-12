package com.example.todo_api.ecxeptions;

public class NoPersonAddedException extends RuntimeException{
    public NoPersonAddedException() {
    }

    public NoPersonAddedException(String message) {
        super(message);
    }
}
