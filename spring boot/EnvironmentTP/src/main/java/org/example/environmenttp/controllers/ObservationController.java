package org.example.environmenttp.controllers;

import jakarta.validation.Valid;
import org.example.environmenttp.dtos.observation.ObservationReceiveDto;
import org.example.environmenttp.dtos.observation.ObservationResponseDto;
import org.example.environmenttp.dtos.travellog.TravelLogResponseDto;
import org.example.environmenttp.services.ObservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.UUID;

@RestController
@RequestMapping("/api/observation")
public class ObservationController {

    private ObservationService service;

    public ObservationController(ObservationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ObservationResponseDto>> getAll (){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObservationResponseDto> get (@PathVariable UUID id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ObservationResponseDto> create (@Valid @RequestBody ObservationReceiveDto ObservationReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(ObservationReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObservationResponseDto> update (@PathVariable UUID id , @RequestBody ObservationReceiveDto ObservationReceiveDto){
        return ResponseEntity.ok(service.update(id,ObservationReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.ok(String.format("Observation at id : %s is deleted",id));
    }

    @GetMapping("by-location")
    public ResponseEntity<List<ObservationResponseDto>> getByLocation (@RequestParam String location){
        return ResponseEntity.ok(service.findByLocation(location));
    }

    @GetMapping("by-specie/{specieId}")
    public ResponseEntity<List<ObservationResponseDto>> getBySpecie (@PathVariable UUID specieId){
        return ResponseEntity.ok(service.findBySpecie(specieId));
    }
}
