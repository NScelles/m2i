package org.example.todoexercise.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToDo {
    private int id;
    private String name;
    private String description;
    private Boolean isDone;


}
