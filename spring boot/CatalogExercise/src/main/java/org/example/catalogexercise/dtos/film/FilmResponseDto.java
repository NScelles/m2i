package org.example.catalogexercise.dtos.film;

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
public class FilmResponseDto {
    private UUID id;
    private String name;
    private String releaseDate;

    private String description;
    private int duration;
    private String genre;
    private UUID idProducer;
}
