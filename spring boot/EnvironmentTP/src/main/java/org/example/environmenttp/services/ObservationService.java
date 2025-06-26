package org.example.environmenttp.services;

import org.example.environmenttp.dtos.observation.ObservationReceiveDto;
import org.example.environmenttp.dtos.observation.ObservationResponseDto;
import org.example.environmenttp.exeptions.NotFoundException;
import org.example.environmenttp.models.Observation;
import org.example.environmenttp.repositories.ObservationRepository;
import org.example.environmenttp.repositories.SpecieRepository;
import org.geojson.FeatureCollection;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ObservationService {

    private ObservationRepository repository;
    private SpecieRepository specieRepository;

    public ObservationService(ObservationRepository repository, SpecieRepository specieRepository) {
        this.repository = repository;
        this.specieRepository = specieRepository;
    }

    public ObservationResponseDto save(ObservationReceiveDto receiveDto) {

        return repository.save(toEntity(receiveDto)).toDto();
    }


    public ObservationResponseDto update(UUID id, ObservationReceiveDto receiveDto) {
        Observation found = repository.findById(id).orElseThrow(NotFoundException::new);
        found.set(toEntity(receiveDto));
        return repository.save(found).toDto();
    }


    public void delete(UUID id) {
        repository.deleteById(id);
    }


    public ObservationResponseDto findById(UUID id) {
        return repository.findById(id).orElseThrow(NotFoundException::new).toDto();
    }


    public List<ObservationResponseDto> findAll() {
        return repository.findAll().stream().map(Observation::toDto).toList();
    }


    public List<ObservationResponseDto> findByLocation(String location) {
        return repository.findObservationsByLocation(location).stream().map(Observation::toDto).toList();
    }

    public List<ObservationResponseDto> findBySpecie(UUID id) {
        return repository.findObservationsBySpecie(id).stream().map(Observation::toDto).toList();
    }

    public FeatureCollection getGeoJson() {
        var featureCollection = new FeatureCollection();
        var observations = repository.findAll();
        observations.stream().map(Observation::toFeature).forEach(featureCollection::add);
        return featureCollection;
    }

    private Observation toEntity(ObservationReceiveDto receiveDto) {
        return Observation.builder()
                .specie(specieRepository.findById(receiveDto.getSpecieId()).orElse(null))
                .observerName(receiveDto.getObserverName())
                .location(receiveDto.getLocation())
                .latitude(receiveDto.getLatitude())
                .longitude(receiveDto.getLongitude())
                .observationDate(receiveDto.getObservationDate())
                .comment(receiveDto.getComment())
                .build();
    }
}
