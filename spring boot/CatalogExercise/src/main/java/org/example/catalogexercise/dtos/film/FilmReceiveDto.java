package org.example.catalogexercise.dtos.film;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.catalogexercise.models.Film;
import org.example.catalogexercise.models.Producer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmReceiveDto {

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 2, max = 50)
    private String name;
    @Pattern(regexp = "[0-9]{2}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{4}" , message = "La date dois etre au format dd-MM-yyyy")
    @NotNull
    private String releaseDate;
    @NotNull
    @NotBlank
    private String description;
    @Min(20)
    @NotNull
    private int duration;
    @NotNull
    private String genre;
    @NotNull
    private UUID idProducer;
    private Producer producer;


    public Film dtoToEntity (){
        return Film.builder()
                .name(getName())
                .releaseDate(getReleaseDate())
                .description(getDescription())
                .duration(getDuration())
                .genre(getGenre())
                .producer(getProducer())
                .build();
    }
}
