package org.example.environmenttp.dtos.specie;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecieReceiveDto {

    @NotNull
    @Size(min = 1, max = 50)
    private String commonName;
    @NotNull
    @Size(min = 1, max = 50)
    private String scientificName;
    @NotNull
    private String category;


}
