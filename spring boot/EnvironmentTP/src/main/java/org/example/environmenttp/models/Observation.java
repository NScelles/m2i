package org.example.environmenttp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.environmenttp.dtos.observation.ObservationResponseDto;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Observation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "specie_id")
    private Specie specie;

    private String observerName;
    private String location;
    private Double latitude;
    private Double longitude;
    private LocalDate observationDate;
    private String comment;

    public void set(Observation observation) {
        this.observerName = observation.getObserverName();
        this.location = observation.getLocation();
        this.latitude = observation.getLatitude();
        this.longitude = observation.getLongitude();
        this.observationDate = observation.getObservationDate();
        this.comment = observation.getComment();
    }

    public ObservationResponseDto toDto() {
        ObservationResponseDto dto = ObservationResponseDto.builder()
                .id(getId())
                .specieId(getSpecie().getId())
                .observerName(getObserverName())
                .location(getLocation())
                .latitude(getLatitude())
                .longitude(getLongitude())
                .observationDate(getObservationDate())
                .comment(getComment())
                .build();
        return dto;
    }
}

