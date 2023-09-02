package com.mapping.dto;

import com.mapping.entities.Laptop;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

@Data
public class StudentDto {

    private long id;
    private String name;
    private String course;
    private String city;

    private Laptop laptop;
}
