package org.example.environmenttp.dtos.travellog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.environmenttp.models.Observation;
import org.example.environmenttp.models.TravelMode;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelLogResponseDto{
    private UUID id;
    private UUID observationID;
    private Double distanceKm;
    private TravelMode mode;
    private Double estimatedCo2Kg;
}
