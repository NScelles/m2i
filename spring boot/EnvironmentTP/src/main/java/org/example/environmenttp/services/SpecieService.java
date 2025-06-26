package org.example.environmenttp.services;

import org.example.environmenttp.dtos.specie.SpecieReceiveDto;
import org.example.environmenttp.dtos.specie.SpecieResponseDto;
import org.example.environmenttp.exeptions.NotFoundException;
import org.example.environmenttp.models.Category;
import org.example.environmenttp.models.Specie;
import org.example.environmenttp.repositories.SpecieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SpecieService {

    private final SpecieRepository repository;

    public SpecieService(SpecieRepository repository) {
        this.repository = repository;
    }

    public SpecieResponseDto save(SpecieReceiveDto receiveDto) {
        return repository.save(toEntity(receiveDto)).toDto();
    }


    public SpecieResponseDto update(UUID id, SpecieReceiveDto receiveDto) {
        Specie found = repository.findById(id).orElseThrow(NotFoundException::new);
        found.set(toEntity(receiveDto));
        return repository.save(found).toDto();
    }


    public void delete(UUID id) {
        repository.deleteById(id);
    }


    public SpecieResponseDto findById(UUID id) {
        return repository.findById(id).orElseThrow(NotFoundException::new).toDto();
    }


    public List<SpecieResponseDto> findAll() {
        return repository.findAll().stream().map(Specie::toDto).toList();
    }

    private Specie toEntity(SpecieReceiveDto receiveDto) {
        return Specie.builder()
                .commonName(receiveDto.getCommonName())
                .scientificName(receiveDto.getScientificName())
                .category(Category.getCategory(receiveDto.getCategory()))
                .build();
    }

}
