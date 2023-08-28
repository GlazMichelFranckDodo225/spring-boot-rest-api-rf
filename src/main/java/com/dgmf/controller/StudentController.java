package com.dgmf.controller;

import com.dgmf.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/students") // http://localhost:8080/students
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1L, "John", "Doe"));
        students.add(new Student(2L, "Alex", "Fonzy"));
        students.add(new Student(3L, "Laure", "Esteban"));
        students.add(new Student(4L, "Ynolla", "Orson"));

        return students;
    }
}
