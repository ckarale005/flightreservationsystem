package com.mapping.service.Impl;

import com.mapping.dto.StudentsDto;
import com.mapping.entities.Address;
import com.mapping.entities.Students;
import com.mapping.repository.StudentsRepository;
import com.mapping.service.StudentsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;



@Service
public class StudentsServiceImpl implements StudentsService {

    private StudentsRepository studentsRepository;
    private ModelMapper modelMapper;

    public StudentsServiceImpl(StudentsRepository studentsRepository, ModelMapper modelMapper) {
        this.studentsRepository = studentsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentsDto saveStudents(StudentsDto studentsDto) {
        Students students =new Students();
        Students students1 = mapToDto(studentsDto);
        Address address=new Address();
        Students save = studentsRepository.save(students1);
        return  mapToEntity(save);

    }

    Students mapToDto(StudentsDto studentsDto){
       return modelMapper.map(studentsDto,Students.class);
    }
    StudentsDto mapToEntity(Students students){
        return modelMapper.map(students,StudentsDto.class);
    }
}
