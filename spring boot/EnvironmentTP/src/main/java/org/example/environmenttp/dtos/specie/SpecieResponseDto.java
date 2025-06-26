package org.example.environmenttp.dtos.specie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.environmenttp.models.Category;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecieResponseDto {
    private UUID id;
    private String commonName;
    private String scientificName;
    private Category category;
}
