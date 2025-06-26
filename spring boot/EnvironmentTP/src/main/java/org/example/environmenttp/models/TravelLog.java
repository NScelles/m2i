package org.example.environmenttp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.environmenttp.dtos.travellog.TravelLogResponseDto;
import org.example.environmenttp.utils.Utils;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @ManyToOne
    @JoinColumn(name = "observation_id")
    private Observation observation;

    private Double distanceKm;
    private TravelMode mode;
    private Double estimatedCo2Kg;

    public void set(TravelLog travelLog){
        this.observation = travelLog.getObservation();
        this.distanceKm = travelLog.getDistanceKm();
        this.mode = travelLog.getMode();
        this.estimatedCo2Kg = Utils.getEstimatedCo2Kg(distanceKm, mode);
    }

    public TravelLogResponseDto toDto() {
        return TravelLogResponseDto.builder()
                .id(getId())
                .observationID(getObservation().getId())
                .distanceKm(getDistanceKm())
                .mode(getMode())
                .estimatedCo2Kg(getEstimatedCo2Kg())
                .build();
    }

}
