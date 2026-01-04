package com.example.demo.exception;

public class UniversityNotFoundException extends RuntimeException {

    public UniversityNotFoundException(String message) {
        super(message);
    }
}

