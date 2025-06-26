package org.example.environmenttp.controllers;

import jakarta.validation.Valid;
import org.example.environmenttp.dtos.specie.SpecieReceiveDto;
import org.example.environmenttp.dtos.specie.SpecieResponseDto;
import org.example.environmenttp.services.SpecieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/specie")
public class SpecieController {
    private SpecieService service;

    public SpecieController(SpecieService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SpecieResponseDto>> getAll (){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecieResponseDto> get (@PathVariable UUID id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<SpecieResponseDto> create (@Valid @RequestBody SpecieReceiveDto SpecieReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(SpecieReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecieResponseDto> update (@PathVariable UUID id , @RequestBody SpecieReceiveDto SpecieReceiveDto){
        return ResponseEntity.ok(service.update(id,SpecieReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.ok(String.format("Specie at id : %s is deleted",id));
    }
}
