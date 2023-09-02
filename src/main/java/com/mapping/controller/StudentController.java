package com.mapping.controller;

import com.mapping.dto.StudentDto;
import com.mapping.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    localhost:8080/api/student/save
    @PostMapping("/save")
    public ResponseEntity saveStudent(@RequestBody StudentDto studentDto){
        StudentDto student = studentService.saveStudent(studentDto);
        return new ResponseEntity(student,HttpStatus.CREATED);
    }
}
