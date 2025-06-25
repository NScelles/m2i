package org.example.catalogexercise.services;

import org.example.catalogexercise.dtos.film.FilmReceiveDto;
import org.example.catalogexercise.dtos.film.FilmResponseDto;
import org.example.catalogexercise.exeptions.NotFoundException;
import org.example.catalogexercise.models.Film;
import org.example.catalogexercise.models.Producer;
import org.example.catalogexercise.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FilmService {


    private final FilmRepository repository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.repository = filmRepository;
    }

    public FilmResponseDto create (FilmReceiveDto filmReceiveDto){
        filmReceiveDto.setProducer(getProducer(filmReceiveDto.getIdProducer()));
        return repository.save(filmReceiveDto.dtoToEntity()).toDto();
    }

    public FilmResponseDto get(UUID id){
        return repository.findById(id).orElseThrow(NotFoundException::new).toDto();
    }

    public List<FilmResponseDto> get(){
        return repository.findAll().stream().map(Film::toDto).toList();
    }

    public FilmResponseDto update(UUID id, FilmReceiveDto filmReceiveDto){
        Film userFound = repository.findById(id).orElseThrow(NotFoundException::new);
        userFound.set(filmReceiveDto.dtoToEntity());
        return repository.save(userFound).toDto();
    }

    public void delete (UUID id){
        repository.deleteById(id);
    }

    public Producer getProducer(UUID idProducer){
        return repository.findProducerById(idProducer);
    }

    public List<FilmResponseDto> getFilmByProducer(UUID idProducer){
        return repository.findFilmByProducer(idProducer).stream().map(Film::toDto).toList();
    }

}