package com.example.demo.request;

import com.example.demo.entity.Student;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class StudentEditRequest {
    @NotNull
    private Integer id;
    @NotBlank
    @Size(min = 1, max = 255)
    private String firstName;
    @NotBlank
    @Size(min = 1, max = 255)
    private String lastName;
    @NotNull
    private LocalDate dateOfBirth;
    @NotNull
    private Student.Gender gender;
}
