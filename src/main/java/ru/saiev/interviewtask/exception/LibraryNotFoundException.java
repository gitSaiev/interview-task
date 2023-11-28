package ru.saiev.interviewtask.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LibraryNotFoundException extends RuntimeException{
    public LibraryNotFoundException(String message) {
        super(message);
    }
}
