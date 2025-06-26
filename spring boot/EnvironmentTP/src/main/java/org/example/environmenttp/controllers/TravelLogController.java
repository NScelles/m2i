package org.example.environmenttp.controllers;

import jakarta.validation.Valid;
import org.example.environmenttp.dtos.travellog.TravelLogReceiveDto;
import org.example.environmenttp.dtos.travellog.TravelLogResponseDto;
import org.example.environmenttp.services.TravelLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/travel-log")
public class TravelLogController {

    private TravelLogService service;

    public TravelLogController(TravelLogService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Map<String,Object>> getAll (){
        Map <String,Object> result = new HashMap<>();
        var travelLogs = service.findAll();
        result.put("travelLogs", travelLogs);
        double totalEmissions = travelLogs.stream().map(TravelLogResponseDto::getEstimatedCo2Kg).reduce(0.0, Double::sum);
        result.put("totalEmissionKg", totalEmissions);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelLogResponseDto> get (@PathVariable UUID id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TravelLogResponseDto> create (@Valid @RequestBody TravelLogReceiveDto TravelLogReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(TravelLogReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TravelLogResponseDto> update (@PathVariable UUID id , @RequestBody TravelLogReceiveDto TravelLogReceiveDto){
        return ResponseEntity.ok(service.update(id,TravelLogReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.ok(String.format("Travel Log at id : %s is deleted",id));
    }

    @GetMapping("/stats/{idObservation}")
    public ResponseEntity<Map<String,Object>> getStats (@PathVariable UUID idObservation){
        return ResponseEntity.ok(service.getStatsObservation(idObservation));
    }
}
