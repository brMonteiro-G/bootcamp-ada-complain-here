package com.project.poc.complainhere.Enterprise;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    private ModelMapper modelMapper;
    private final EnterpriseRepository repository;


    public EnterpriseService(EnterpriseRepository repository) {
        this.repository = repository;
    }

    public List<Enterprise> getAll(){
        return this.repository.findAll();
    }

    public Enterprise create(EnterpriseRequestDTO enterpriseRequestDTO) throws JsonProcessingException {

        Enterprise teste =  modelMapper.map(enterpriseRequestDTO, Enterprise.class);

        return this.repository.save(teste);
    }



}
