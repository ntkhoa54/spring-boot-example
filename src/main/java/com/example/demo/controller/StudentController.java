package com.example.demo.controller;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.request.StudentCreateRequest;
import com.example.demo.request.StudentEditRequest;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping(value = "/students", produces = "application/json")
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudent();
    }

    @PostMapping(value = "/students", produces = "application/json", consumes = "application/json")
    public StudentResponse createStudent(@RequestBody @Valid StudentCreateRequest studentCreateRequest) {
        return studentService.createStudent(studentCreateRequest);
    }

    @PutMapping(value = "/students", produces = "application/json", consumes = "application/json")
    public StudentResponse updateStudent(@RequestBody @Valid StudentEditRequest studentEditRequest) throws StudentNotFoundException {
        return studentService.editStudent(studentEditRequest);
    }

    @DeleteMapping(value = "/students/{id}")
    public void deleteStudent(@PathVariable(name = "id") Integer studentId) throws StudentNotFoundException {
        studentService.deleteStudent(studentId);
    }
}
