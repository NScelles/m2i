package org.example.demorest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demorest.models.User;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReceiveDto extends BaseDto<User> {
    private String id;
    private String username;
    private String password;

    @Override
    public User dtoToEntity() {
        return User.builder().username(getUsername()).password(getPassword()).build();
    }
}
