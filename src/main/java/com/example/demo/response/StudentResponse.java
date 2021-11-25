package com.example.demo.response;

import com.example.demo.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Student.Gender gender;
    private String address;
}
