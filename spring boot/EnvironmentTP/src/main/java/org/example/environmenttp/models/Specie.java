package org.example.environmenttp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.environmenttp.dtos.specie.SpecieResponseDto;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Specie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String commonName;
    private String scientificName;
    private Category category;

    public void set(Specie specie) {
        this.commonName = specie.getCommonName();
        this.scientificName = specie.getScientificName();
        this.category = specie.getCategory();
    }

    public SpecieResponseDto toDto() {
        return SpecieResponseDto.builder()
                .id(getId())
                .commonName(getCommonName())
                .scientificName(getScientificName())
                .category(getCategory())
                .build();
    }

}
