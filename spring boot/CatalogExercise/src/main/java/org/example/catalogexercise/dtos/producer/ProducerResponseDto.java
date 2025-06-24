package org.example.catalogexercise.dtos.producer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProducerResponseDto {
    private UUID id;
    private String firstName;
    private String lastName;

    private String birthDate;
    private String nationality;
}
