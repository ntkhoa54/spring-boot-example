package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentNotFoundException extends Exception {
    private final Integer id;

    public StudentNotFoundException(Integer id) {
        super("Could not found the student by id: " + id);
        this.id = id;
    }
}
