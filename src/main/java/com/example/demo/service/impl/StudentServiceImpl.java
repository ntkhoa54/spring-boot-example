package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import com.example.demo.request.StudentCreateRequest;
import com.example.demo.request.StudentEditRequest;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentResponse createStudent(StudentCreateRequest studentCreateRequest) {
        Student student = studentMapper.toStudent(studentCreateRequest);
        return studentMapper.toStudentResponse(studentRepository.save(student));
    }

    @Override
    public StudentResponse editStudent(StudentEditRequest studentEditRequest) throws StudentNotFoundException {
        Student student = studentRepository.findById(studentEditRequest.getId())
                .orElseThrow(
                        () -> new StudentNotFoundException(studentEditRequest.getId()));
        studentMapper.updateStudent(student, studentEditRequest);
        return studentMapper.toStudentResponse(studentRepository.save(student));
    }

    @Override
    public void deleteStudent(Integer studentId) throws StudentNotFoundException {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(
                        () -> new StudentNotFoundException(studentId));
        studentRepository.delete(student);
    }

    @Override
    public List<StudentResponse> getAllStudent() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentResponse)
                .collect(Collectors.toList());
    }
}
