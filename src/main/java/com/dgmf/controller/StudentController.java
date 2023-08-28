package com.dgmf.controller;

import com.dgmf.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("/student") // http://localhost:8080/student
    public Student getStudent() {
        Student student = Student.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .build();

        return student;
    }
}
