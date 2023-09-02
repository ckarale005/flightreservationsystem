package com.mapping.service.Impl;

import com.mapping.dto.StudentDto;
import com.mapping.entities.Laptop;
import com.mapping.entities.Student;
import com.mapping.repository.StudentRepository;
import com.mapping.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository repository;
    private ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        Laptop laptop=new Laptop();
        Student student1 = new Student();
        Student student = mapToDto(studentDto);
        laptop.setStudent(student.getLaptop().getStudent());
        student1.setLaptop(student.getLaptop());
        Student save = repository.save(student);
        return mapToEntity(save);

    }

    Student mapToDto(StudentDto studentDto){
       return modelMapper.map(studentDto,Student.class);
    }

    StudentDto mapToEntity(Student student){
        return modelMapper.map(student,StudentDto.class);
    }
}
