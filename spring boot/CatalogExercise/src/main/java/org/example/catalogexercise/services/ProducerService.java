package org.example.catalogexercise.services;

import org.example.catalogexercise.dtos.producer.ProducerReceiveDto;
import org.example.catalogexercise.dtos.producer.ProducerResponseDto;
import org.example.catalogexercise.exeptions.NotFoundException;
import org.example.catalogexercise.models.Producer;
import org.example.catalogexercise.repositories.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProducerService {


    private final ProducerRepository repository;

    @Autowired
    public ProducerService(ProducerRepository ProducerRepository) {
        this.repository = ProducerRepository;
    }

    public ProducerResponseDto create (ProducerReceiveDto ProducerReceiveDto){
        return repository.save(ProducerReceiveDto.dtoToEntity()).toDto();
    }

    public ProducerResponseDto get(UUID id){
        return repository.findById(id).orElseThrow(NotFoundException::new).toDto();
    }

    public List<ProducerResponseDto> get(){
        return repository.findAll().stream().map(Producer::toDto).toList();
    }

    public ProducerResponseDto update(UUID id, ProducerReceiveDto ProducerReceiveDto){
        Producer userFound = repository.findById(id).orElseThrow(NotFoundException::new);
        Producer userGet = ProducerReceiveDto.dtoToEntity();
        userFound.set(userGet);
        return repository.save(userFound).toDto();
    }

    public void delete (UUID id){
        repository.deleteById(id);
    }



}