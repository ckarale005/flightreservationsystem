package com.mapping.service.Impl;

import com.mapping.dto.LaptopDto;
import com.mapping.entities.Laptop;
import com.mapping.entities.Student;
import com.mapping.repository.LaptopRepository;
import com.mapping.repository.StudentRepository;
import com.mapping.service.LaptopService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class LaptopServiceImpl implements LaptopService {
    private LaptopRepository repository;
    private ModelMapper modelMapper;
    private StudentRepository studentRepository;

    public LaptopServiceImpl(LaptopRepository repository, ModelMapper modelMapper, StudentRepository studentRepository) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.studentRepository = studentRepository;
    }

    @Override
    public LaptopDto saveLapto(LaptopDto laptopDto) {
       Laptop laptop=new Laptop();
       Student student=new Student();
        Laptop laptop1 = mapToDto(laptopDto);
        laptop.setStudent(laptop1.getStudent());
        student.setLaptop(laptop1.getStudent().getLaptop());
        Laptop save = repository.save(laptop1);
        return mapToEntity(save);
//
    }

   Laptop mapToDto(LaptopDto laptopDto){
       return modelMapper.map(laptopDto,Laptop.class);
   }
   LaptopDto mapToEntity(Laptop laptop){
      return modelMapper.map(laptop,LaptopDto.class);
   }
}
