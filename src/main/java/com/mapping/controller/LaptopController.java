package com.mapping.controller;

import com.mapping.dto.LaptopDto;
import com.mapping.service.LaptopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/laptop")
public class LaptopController {

    private LaptopService service;

    public LaptopController(LaptopService service) {
        this.service = service;
    }

//    localhost:8080/api/laptop/save
    @PostMapping("/save")
    public ResponseEntity saveLaptop(@RequestBody LaptopDto laptopDto){

        System.out.println(laptopDto);
        LaptopDto laptop = service.saveLapto(laptopDto);
        return new ResponseEntity(laptop, HttpStatus.CREATED);
    }
}
