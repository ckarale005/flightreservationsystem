package com.mapping.dto;

import com.mapping.entities.Students;
import lombok.Data;



@Data
public class AddressDto {
    private long id;
    private String street;
    private String city;
    private String country;
    private Students students;
}
