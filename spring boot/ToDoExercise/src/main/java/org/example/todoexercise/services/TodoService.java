package org.example.todoexercise.services;

import org.example.todoexercise.dtos.todo.TodoReceiveDto;
import org.example.todoexercise.dtos.todo.TodoResponseDto;
import org.example.todoexercise.models.Todo;
import org.example.todoexercise.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.todoexercise.exeptions.NotFoundException;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {


    private final TodoRepository repository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.repository = todoRepository;
    }

    public TodoResponseDto create (TodoReceiveDto todoReceiveDto){
        return repository.save(todoReceiveDto.dtoToEntity()).toDto();
    }

    public TodoResponseDto get(UUID id){
        return repository.findById(id).orElseThrow(NotFoundException::new).toDto();
    }

    public List<TodoResponseDto> get(){
        return repository.findAll().stream().map(Todo::toDto).toList();
    }

    public TodoResponseDto update(UUID id, TodoReceiveDto todoReceiveDto){
        Todo userFound = repository.findById(id).orElseThrow(NotFoundException::new);
        Todo userGet = todoReceiveDto.dtoToEntity();
        userFound.set(userGet);
        return repository.save(userFound).toDto();
    }

    public void delete (UUID id){
        repository.deleteById(id);
    }

    public List<TodoResponseDto> getByValidate(boolean validate){
        return repository.findTodoByIsValidate(validate).stream().map(Todo::toDto).toList();
        //get().stream().filter(t->t.isValidate() == validate).toList();
    }

}