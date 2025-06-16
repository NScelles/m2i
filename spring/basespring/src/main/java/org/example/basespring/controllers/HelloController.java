package org.example.basespring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String sayHello() {
        System.out.println("Je passe dans sayHello()");
        return "hello";
    }

    @RequestMapping("/coucou")
    @ResponseBody
    public List<String> getPersons() {
        System.out.println("Je passe dans getPersons()");
        return List.of("Toto","Tata","Titi");
    }

    @RequestMapping("/home/person")
    public String homePerson(Model model) {
        System.out.println("Je passe dans getPersons()");
        model.addAttribute("firstName", "Toto");
        model.addAttribute("lastName", "Titi");
        model.addAttribute("persons", List.of("Toto", "Tata", "Titi") );
        return "person/details";
    }
}
