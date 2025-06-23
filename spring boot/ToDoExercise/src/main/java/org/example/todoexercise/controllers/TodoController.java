package org.example.todoexercise.controllers;

import org.example.todoexercise.dtos.todo.TodoReceiveDto;
import org.example.todoexercise.dtos.todo.TodoResponseDto;
import org.example.todoexercise.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("api/todo")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> getAll (){
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> get (@PathVariable UUID id){
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<TodoResponseDto> create (@RequestBody TodoReceiveDto userReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(userReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDto> update (@PathVariable UUID id , @RequestBody TodoReceiveDto userReceiveDto){
        return ResponseEntity.ok(service.update(id,userReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.ok(String.format("User at id : %s is deleted",id));
    }

    @GetMapping("/validate")
    public ResponseEntity<List<TodoResponseDto>> getValidate (@RequestParam(required = false) boolean isValid){
        return ResponseEntity.ok(service.getByValidate(isValid));
    }
}
