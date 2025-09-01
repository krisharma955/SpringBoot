package com.SpringBoot.RestAPIs.controller;

import com.SpringBoot.RestAPIs.dto.StudentDto;
import com.SpringBoot.RestAPIs.entity.Student;
import com.SpringBoot.RestAPIs.repository.StudentRepository;
import com.SpringBoot.RestAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    //Path Variables
    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable Long id) {
        //return new StudentDto(4L, "Lando", "lando@gmail.com");
        return studentService.getStudentById(id);
    }

}
