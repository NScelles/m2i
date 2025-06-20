package org.example.furnitureexercise.controllers;

import org.example.furnitureexercise.models.CardItem;
import org.example.furnitureexercise.models.Furniture;
import org.example.furnitureexercise.services.furniture.BaseFurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/furniture")
public class FurnitureController {

    private BaseFurnitureService service;

    @Autowired
    public FurnitureController(BaseFurnitureService furnitureService) {
        this.service = furnitureService;
    }


    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("furnitures",service.get());
        model.addAttribute("cardItem", new CardItem());
        model.addAttribute("mode","list");
        return "furniture/list";
    }



    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("isExist",false);
        model.addAttribute("furniture", new Furniture());
        return "furniture/form";
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable UUID id, Model model) {
        model.addAttribute("isExist", true);
        model.addAttribute("furniture", service.get(id));
        return "furniture/form";
    }



    @PostMapping("/add")
    public String addElement(@ModelAttribute("furniture") Furniture element) {
        service.addOrUpdate(element);
        return "redirect:/furniture/list";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id, @RequestParam(value = "from",required = false) String destination, Model model) {
        service.delete(id);
        if(destination != null && !destination.isEmpty())
            return "redirect:"+destination;
        return "redirect:/furniture/list";
    }


    @GetMapping("/search")
    public String search(@RequestParam(value = "name",required = false) String name, Model model) {
        model.addAttribute("mode","search");
        List<Furniture> furnitureList = service.get();
        if(name != null && !name.isEmpty())
            furnitureList = service.findByName(name);
        model.addAttribute("furnitures",furnitureList);
        return "/furniture/list";
    }
}
