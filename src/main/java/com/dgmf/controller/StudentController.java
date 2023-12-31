package com.dgmf.controller;

import com.dgmf.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("/student") // http://localhost:8080/student
    public StudentDTO getStudent() {
        StudentDTO studentDTO = StudentDTO.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .build();

        return studentDTO;
    }

    @GetMapping("/students") // http://localhost:8080/students
    public List<StudentDTO> getStudents() {
        List<StudentDTO> studentDTOS = new ArrayList<>();

        studentDTOS.add(new StudentDTO(1L, "John", "Doe"));
        studentDTOS.add(new StudentDTO(2L, "Alex", "Fonzy"));
        studentDTOS.add(new StudentDTO(3L, "Laure", "Esteban"));
        studentDTOS.add(new StudentDTO(4L, "Ynolla", "Orson"));

        return studentDTOS;
    }

    @GetMapping("/students/{id}/{first-name}/{last-name}")
    // "id", "fn" and "ln" ==> URI Template variables
    // http://localhost:8080/students/1/John/Doe
    public StudentDTO studentPathVariable(
            @PathVariable("id") Long studentId,
            @PathVariable("first-name") String studentFirstName,
            @PathVariable("last-name") String studentLastName
            ) {
        StudentDTO studentDTO = StudentDTO.builder()
                .id(studentId)
                .firstName(studentFirstName)
                .lastName(studentLastName)
                .build();

        return studentDTO;
    }

    @GetMapping("/students/query") // REST API Endpoint should be unique
    // "id", "firstname" and "lastname" ==> Query Parameters (Query Strings)
    // http://localhost:8080/students/query?id=1&firstname=John&lastname=Doe
    public StudentDTO studentRequestVariable(
            @RequestParam("id") Long studentId,
            @RequestParam("firstname") String studentFirstName,
            @RequestParam("lastname") String studentLastName
    ) {
        StudentDTO studentDTO = StudentDTO.builder()
                .id(studentId)
                .firstName(studentFirstName)
                .lastName(studentLastName)
                .build();

        return studentDTO;
    }

    // Rest API that handles HTTP Post Request - Creating new resource
    // @PostMapping and @RequestBody
    @PostMapping("/students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO student = StudentDTO.builder()
                .id(studentDTO.getId())
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .build();

        return student;
    }

    // Rest API that handles HTTP Post Request - Updating existing resource
    // @PostMapping and @RequestBody
    // HTTP Status ==> 200 OK for PUT Request by default
    @PutMapping("/students/{id}/update")
    public StudentDTO updateStudent(
            @RequestBody StudentDTO studentDTO,
            @PathVariable("id") Long studentId
    ) {
        StudentDTO student = StudentDTO.builder()
                .id(studentId)
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .build();

        return student;
    }
}
