package org.example.catalogexercise.controllers;


import jakarta.validation.Valid;
import org.example.catalogexercise.dtos.film.FilmReceiveDto;
import org.example.catalogexercise.dtos.film.FilmResponseDto;
import org.example.catalogexercise.services.FilmService;
import org.example.catalogexercise.services.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/film")
public class FilmController {

    private FilmService service;

    public FilmController(FilmService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<FilmResponseDto>> getAll (){
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmResponseDto> get (@PathVariable UUID id){
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<FilmResponseDto> create (@Valid @RequestBody FilmReceiveDto filmReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(filmReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmResponseDto> update (@PathVariable UUID id , @RequestBody FilmReceiveDto filmReceiveDto){
        return ResponseEntity.ok(service.update(id,filmReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.ok(String.format("User at id : %s is deleted",id));
    }

    @GetMapping("/producer/{idProducer}")
    public ResponseEntity<List<FilmResponseDto>> getProducer(@PathVariable UUID idProducer){
        return ResponseEntity.ok(service.getFilmByProducer(idProducer));
    }

}
