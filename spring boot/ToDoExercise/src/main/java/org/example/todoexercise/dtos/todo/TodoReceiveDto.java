package org.example.todoexercise.dtos.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.todoexercise.models.Todo;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoReceiveDto {
    private String title;
    private String description;
    //@DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private boolean isValidate;


    public Todo dtoToEntity (){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return Todo.builder().title(getTitle())
                .description(getDescription())
                .date(getDate())
                .isValidate(isValidate())
                .build();
    }
}
