package org.example.catalogexercise.dtos.producer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.catalogexercise.models.Producer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProducerReceiveDto {
    @NotBlank
    @NotNull
    private String firstName;
    @NotBlank
    @NotNull
    private String lastName;
    @Pattern(regexp = "[0-9]{2}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{4}" , message = "La date dois etre au format dd-MM-yyyy")
    private String birthDate;
    @NotNull
    @NotBlank
    private String nationality;


    public Producer dtoToEntity (){
        return Producer.builder()
                .firstName(getFirstName())
                .lastName(getLastName())
                .birthDate(getBirthDate())
                .nationality(getNationality())
                .build();
    }
}
