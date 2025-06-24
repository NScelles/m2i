package org.example.catalogexercise.models;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.catalogexercise.dtos.film.FilmResponseDto;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String releaseDate;
    private String description;
    private int duration;
    private String genre;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_producer")
    private Producer producer;


    public Film set(Film Film){
        this.name = Film.getName();
        this.releaseDate = Film.getReleaseDate();
        this.description = Film.getDescription();
        this.duration = Film.getDuration();
        this.genre = Film.getGenre();
        this.producer = Film.getProducer();
        return this;
    }

    public FilmResponseDto toDto() {
        return FilmResponseDto.builder()
                .id(getId())
                .name(getName())
                .releaseDate(getReleaseDate())
                .description(getDescription())
                .duration(getDuration())
                .genre(getGenre())
                .idProducer(getProducer().getId())
                .build();
    }


}
