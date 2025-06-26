package org.example.environmenttp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BonusController {

    @GetMapping("/")
    public String swaggerUI(Model model) {
        return "redirect:/swagger-ui.html";
    }
}
