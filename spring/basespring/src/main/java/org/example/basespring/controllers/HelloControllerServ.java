package org.example.basespring.controllers;

import lombok.AllArgsConstructor;
import org.example.basespring.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloControllerServ {

    private GreetingService greetingService;

    @Autowired
    public HelloControllerServ(@Qualifier("greeting") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @RequestMapping("/hello-set")
    private String sayHello(){
        System.out.println(greetingService.greet());
        return "hello";
    }


}
