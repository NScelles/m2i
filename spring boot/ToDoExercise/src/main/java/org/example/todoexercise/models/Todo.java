package org.example.todoexercise.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.todoexercise.dtos.todo.TodoResponseDto;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String description;

    //@DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    private boolean isValidate;

    public Todo set(Todo todo){

        this.setTitle(todo.getTitle());
        this.setDescription(todo.getDescription());
        this.setDate(todo.getDate());
        this.setValidate(todo.isValidate());
        return this;
    }

    public TodoResponseDto toDto() {
        return TodoResponseDto.builder()
                .id(getId())
                .title(getTitle())
                .description(getDescription())
                .date(getDate())
                .isValidate(isValidate())
                .build();
    }


}
