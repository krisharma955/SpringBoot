package com.SpringBoot.RestAPIs.service;

import com.SpringBoot.RestAPIs.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);
}
