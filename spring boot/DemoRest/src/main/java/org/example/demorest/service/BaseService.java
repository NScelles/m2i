package org.example.demorest.service;


import org.example.demorest.dtos.BaseDto;
import org.example.demorest.exeptions.NotFoundExeption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public class BaseService<T> {

    protected JpaRepository<T,UUID> repository;

    protected BaseDto<T> baseDtoResponse;
    protected BaseDto<T> baseDtoReceive;

    public BaseService(JpaRepository<T,UUID> repository, BaseDto<T> baseDtoResponse, BaseDto<T> baseDtoReceive) {
        this.repository = repository;
        this.baseDtoResponse = baseDtoResponse;
        this.baseDtoReceive = baseDtoReceive;
    }

    public List<T> get(){
        return repository.findAll();
    }
    public T get(UUID id){
        return repository.findById(id).orElseThrow(NotFoundExeption::new);
    }
    public T addOrUpdate(T element){
        return repository.save(element);
    }
    public void delete(T element){
        repository.delete(element);
    }

    public void delete(UUID id){
        repository.delete(get(id));
    }
}
