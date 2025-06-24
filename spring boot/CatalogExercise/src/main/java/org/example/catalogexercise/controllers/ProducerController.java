package org.example.catalogexercise.controllers;

import jakarta.validation.Valid;
import org.example.catalogexercise.dtos.producer.ProducerReceiveDto;
import org.example.catalogexercise.dtos.producer.ProducerResponseDto;
import org.example.catalogexercise.services.ProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/producer")
public class ProducerController {

    private ProducerService service;

    public ProducerController(ProducerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProducerResponseDto>> getAll (){
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProducerResponseDto> get (@PathVariable UUID id){
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<ProducerResponseDto> create (@Valid @RequestBody ProducerReceiveDto userReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(userReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProducerResponseDto> update (@PathVariable UUID id , @RequestBody ProducerReceiveDto userReceiveDto){
        return ResponseEntity.ok(service.update(id,userReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.ok(String.format("User at id : %s is deleted",id));
    }


}
