package com.mapping.controller;

import com.mapping.dto.StudentsDto;
import com.mapping.service.StudentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentsController {

    private StudentsService service;

    public StudentsController(StudentsService service) {
        this.service = service;
    }
//   localhost:8080/api/students/save
    @PostMapping("/save")
    public ResponseEntity saveStudents(@RequestBody StudentsDto studentsDto){
        service.saveStudents(studentsDto);
        return null;
    }
}
