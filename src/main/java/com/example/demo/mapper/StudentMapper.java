package com.example.demo.mapper;

import com.example.demo.entity.Student;
import com.example.demo.request.StudentCreateRequest;
import com.example.demo.request.StudentEditRequest;
import com.example.demo.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudent(StudentCreateRequest studentCreateRequest);

    void updateStudent(@MappingTarget Student student, StudentEditRequest studentCreateRequest);

    StudentResponse toStudentResponse(Student student);
}
