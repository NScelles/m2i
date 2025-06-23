package org.example.demorest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demorest.models.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto extends BaseDto<User> {
    private UUID id;
    private String username;


    @Override
    public User dtoToEntity() {
        return User.builder().username(getUsername()).build();
    }
}
