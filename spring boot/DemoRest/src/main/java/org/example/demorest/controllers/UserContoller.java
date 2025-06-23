package org.example.demorest.controllers;

import jakarta.websocket.server.PathParam;
import org.example.demorest.dtos.UserReceiveDto;
import org.example.demorest.dtos.UserResponseDto;
import org.example.demorest.models.User;
import org.example.demorest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("api/user")
public class UserContoller {

    @Autowired
    private final UserService service;

    public UserContoller(UserService userService) {
        this.service = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> get() {
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable UUID id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addOrUpdate(user));
    }

    @PutMapping("{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable UUID id){
        return ResponseEntity.ok(service.addOrUpdate(user));
    }
}
