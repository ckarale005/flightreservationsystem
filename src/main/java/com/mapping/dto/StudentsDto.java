package com.mapping.dto;

import com.mapping.entities.Address;
import lombok.Data;


import java.util.List;

@Data
public class StudentsDto {
    private long id;
    private String name;
    private String email;
    private String mobile;
    private List<Address> address;
}
