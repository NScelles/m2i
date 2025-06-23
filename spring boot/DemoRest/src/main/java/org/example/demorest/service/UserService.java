package org.example.demorest.service;

import org.example.demorest.models.User;
import org.example.demorest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService extends BaseService<User> {

    @Autowired
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }

}
