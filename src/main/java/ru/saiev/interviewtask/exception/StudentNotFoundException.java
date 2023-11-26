package ru.saiev.interviewtask.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message) {
        super(message);
    }
}
