package org.example.environmenttp.services;

import org.example.environmenttp.dtos.travellog.TravelLogReceiveDto;
import org.example.environmenttp.dtos.travellog.TravelLogResponseDto;
import org.example.environmenttp.exeptions.NotFoundException;
import org.example.environmenttp.models.TravelLog;
import org.example.environmenttp.models.TravelMode;
import org.example.environmenttp.repositories.ObservationRepository;
import org.example.environmenttp.repositories.TravelLogRepository;
import org.example.environmenttp.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TravelLogService {

    private final TravelLogRepository repository;
    private final ObservationRepository observationRepository ;

    @Autowired
    public TravelLogService(TravelLogRepository repository, ObservationRepository observationRepository) {
        this.repository = repository;
        this.observationRepository = observationRepository;
    }

    public TravelLogResponseDto save(TravelLogReceiveDto receiveDto) {
        return repository.save(toEntity(receiveDto)).toDto();
    }


    public TravelLogResponseDto update(UUID id,TravelLogReceiveDto receiveDto) {
        TravelLog found = repository.findById(id).orElseThrow(NotFoundException::new);
        found.set(toEntity(receiveDto));
        return repository.save(found).toDto();
    }


    public void delete(UUID id) {
        repository.deleteById(id);
    }


    public TravelLogResponseDto findById(UUID id) {
        return repository.findById(id).orElseThrow(NotFoundException::new).toDto();
    }


    public List<TravelLogResponseDto> findAll() {
        return repository.findAll().stream().map(TravelLog::toDto).toList();
    }

    public Map<String,Object> getStatsObservation(UUID observationId) {
        Map<String,Object> result = new HashMap<>();
        System.out.println(repository.findTravelLogsByObservation(observationId).stream().map(TravelLog::toDto).toList());
        var travelLog = repository.findTravelLogsByObservation(observationId);
        result.put("totalDistanceKm",travelLog.stream().map(TravelLog::getDistanceKm).reduce(0.0, Double::sum));
        result.put("totalEmissionsKg",travelLog.stream().map(TravelLog::getEstimatedCo2Kg).reduce(0.0, Double::sum));
        Map<TravelMode,Double> byMode = travelLog.stream().collect(Collectors.groupingBy(
                TravelLog::getMode,
                Collectors.summingDouble(TravelLog::getEstimatedCo2Kg)
        ));
        result.put("byMode",byMode);
        return result;
    }


    private TravelLog toEntity(TravelLogReceiveDto receiveDto) {
        return TravelLog.builder()
                .observation(observationRepository.findById(receiveDto.getObservationId()).orElse(null))
                .distanceKm(receiveDto.getDistanceKm())
                .mode(TravelMode.valueOf(receiveDto.getMode()))
                .estimatedCo2Kg(Utils.getEstimatedCo2Kg(receiveDto.getDistanceKm(), TravelMode.valueOf(receiveDto.getMode())))
                .build();
    }

}
