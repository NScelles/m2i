package org.example.environmenttp.dtos.travellog;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class TravelLogReceiveDto {
    @NotNull
    private UUID observationId;
    @NotNull
    @Min(1)
    private Double distanceKm;
    @NotNull
    private String mode;

}
