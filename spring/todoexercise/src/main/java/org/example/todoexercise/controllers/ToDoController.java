package org.example.todoexercise.controllers;

import org.example.todoexercise.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToDoController {

    private ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("toDos",toDoService.getToDoList());
        return "todo/list";
    }

    @RequestMapping("/todo/{id}")
    public String show(@PathVariable int id,Model model) {
        System.out.println("c'est la le probleme");
        model.addAttribute("toDo",toDoService.getToDo(id));
        return "todo/details";
    }


}
