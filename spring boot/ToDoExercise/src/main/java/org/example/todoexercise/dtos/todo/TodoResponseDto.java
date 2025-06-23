package org.example.todoexercise.dtos.todo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TodoResponseDto {
    private UUID id;
    private String title;
    private String description;
    //@DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private boolean isValidate;
}
