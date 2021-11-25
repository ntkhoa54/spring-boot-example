package com.example.demo.controller.exceptionhandler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {
    private String timestamp;
    private int status;
    private String error;
    private String message;
}
