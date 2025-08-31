package com.SpringBoot.RestAPIs.controller;

import com.SpringBoot.RestAPIs.dto.StudentDto;
import com.SpringBoot.RestAPIs.entity.Student;
import com.SpringBoot.RestAPIs.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student_list")
    public List<Student> getStudetList() {
        return studentRepository.findAll();
    }

    @GetMapping("/student")
    public StudentDto getStudent() {
        return new StudentDto(4L, "Lando", "lando@gmail.com");
    }

}
