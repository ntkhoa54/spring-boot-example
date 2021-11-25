package com.example.demo.controller.exceptionhandler;

import com.example.demo.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ApiError handleStudentNotFoundException(StudentNotFoundException ex) {
        return handleApiError(ex, HttpStatus.NOT_FOUND);
    }

    protected ApiError handleApiError(Exception ex, HttpStatus status) {
        ApiError apiError = new ApiError();
        apiError.setTimestamp(Instant.now().toString());
        apiError.setStatus(status.value());
        apiError.setError(status.getReasonPhrase());
        apiError.setMessage(ex.getMessage());
        return apiError;
    }
}
