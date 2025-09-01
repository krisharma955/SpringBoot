package com.SpringBoot.RestAPIs.service.impl;

import com.SpringBoot.RestAPIs.dto.StudentDto;
import com.SpringBoot.RestAPIs.entity.Student;
import com.SpringBoot.RestAPIs.repository.StudentRepository;
import com.SpringBoot.RestAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        //using streams (lambda fxn)

        //or using for loop
//        List<StudentDto> studentDtoList = new ArrayList<>();
//        for(Student student : students) {
//            StudentDto studentDto = new StudentDto(student.getId(), student.getName(), student.getEmail());
//            studentDtoList.add(studentDto);
//        }
        return students
                .stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail()))
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student  = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with Id: " +id));
    }

}
