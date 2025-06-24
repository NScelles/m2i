package org.example.catalogexercise.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.catalogexercise.dtos.film.FilmResponseDto;
import org.example.catalogexercise.dtos.producer.ProducerResponseDto;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;
    private String lastName;
    private String birthDate;
    private String nationality;

    @OneToMany(mappedBy = "producer")
    private List<Film> films;

    public Producer set(Producer producer){
        this.firstName = producer.getFirstName();
        this.lastName = producer.getLastName();
        this.birthDate = producer.getBirthDate();
        this.nationality = producer.getNationality();
        return this;
    }

    public ProducerResponseDto toDto() {
        return ProducerResponseDto.builder()
                .id(getId())
                .firstName(getFirstName())
                .lastName(getLastName())
                .birthDate(getBirthDate())
                .nationality(getNationality())
                .build();
    }
}
