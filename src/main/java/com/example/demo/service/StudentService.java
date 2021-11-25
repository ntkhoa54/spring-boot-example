package com.example.demo.service;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.request.StudentCreateRequest;
import com.example.demo.request.StudentEditRequest;
import com.example.demo.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse createStudent(StudentCreateRequest studentCreateRequest);

    StudentResponse editStudent(StudentEditRequest studentEditRequest) throws StudentNotFoundException;

    void deleteStudent(Integer studentId) throws StudentNotFoundException;

    List<StudentResponse> getAllStudent();
}
