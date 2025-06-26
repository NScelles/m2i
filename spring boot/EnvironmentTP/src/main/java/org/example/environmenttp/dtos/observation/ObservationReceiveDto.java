package org.example.environmenttp.dtos.observation;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObservationReceiveDto {
    @NotNull
    private UUID specieId;
    @NotNull
    @Size(min = 1, max = 50)
    private String observerName;
    @NotNull
    @Size(min = 1, max = 50)
    private String location;
    @NotNull
    @Min(-90)
    @Max(90)
    private Double latitude;
    @NotNull
    @Min(-180)
    @Max(180)
    private Double longitude;
    @NotNull
    @PastOrPresent
    private LocalDate observationDate;
    private String comment;
}
