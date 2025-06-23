package org.example.furnitureexercise.controllers;

import org.example.furnitureexercise.models.CardItem;
import org.example.furnitureexercise.services.carditem.BaseCardItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/card")
public class CardItemController {

    private BaseCardItemService service;

    @Autowired
    public CardItemController(BaseCardItemService baseCardItemService) {
        service = baseCardItemService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("mode", "list");
        model.addAttribute("cardItems", service.get());
        return "card/list";
    }

    @PostMapping("/add/{id}")
    public String addElement(@PathVariable UUID id, @ModelAttribute("cardItem") CardItem element) {
        CardItem cardItem = CardItem.builder().furniture(service.findFurnitureById(id)).quantity(element.getQuantity()).build();
        //cardItem.getFurniture().setStock(element.getFurniture().getStock() - element.getQuantity());
        System.out.println(element);
        //service.updateFurniture(cardItem.getFurniture());
        service.addOrUpdate(element);
        return "redirect:/card/list";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id,  @RequestParam(value = "from",required = false) String destination, Model model) {
        service.delete(id);
        if(destination != null && !destination.isEmpty())
            return "redirect:"+destination;
        return "redirect:/card/list";
    }

    @GetMapping("/clear")
    public String clear(){
        service.deleteAll();
        return "redirect:/card/list";
    }



}
