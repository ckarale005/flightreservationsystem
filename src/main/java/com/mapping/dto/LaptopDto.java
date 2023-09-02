package com.mapping.dto;

import com.mapping.entities.Student;
import lombok.Data;

import javax.persistence.OneToOne;

@Data
public class LaptopDto {
    private long id;
    private String brand;
    private String  modelNo;

    private Student student;
}
