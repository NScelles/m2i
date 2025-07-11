package org.example.kitchenexercise.controllers;

import org.example.kitchenexercise.models.Category;
import org.example.kitchenexercise.services.category.BaseCategoryService;
import org.example.kitchenexercise.services.category.MySqlCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController<Category> {

    private final BaseCategoryService service;

    @Autowired
    public CategoryController(MySqlCategoryService recipeService) {
        this.service = recipeService;
    }

    @Override
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("categories",service.get());
        model.addAttribute("mode","list");
        return "category/list";
    }

    @Override
    @GetMapping("/{id}")
    public String show(@PathVariable UUID id, Model model){
        model.addAttribute("category", service.get(id));
        return "category/details";
    }

    @Override
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("isExist",false);
        model.addAttribute("category", new Category());
        return "category/form";
    }

    @Override
    @GetMapping("/update/{id}")
    public String update(@PathVariable UUID id, Model model) {
        model.addAttribute("isExist", true);
        model.addAttribute("category", service.get(id));
        return "category/form";
    }


    @Override
    @PostMapping("/add")
    public String addElement(@ModelAttribute Category element) {
        service.addOrUpdate(element);
        return "redirect:/category/list";
    }

    @Override
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id, @RequestParam(value = "from",required = false) String destination, Model model) {
        service.delete(id);
        if(destination != null && !destination.isEmpty())
            return "redirect:"+destination;
        return "redirect:/category/list";
    }

    @Override
    @GetMapping("/search")
    public String search(@RequestParam(value = "name",required = false) String name, Model model) {
        model.addAttribute("mode","search");
        List<Category> categoryList = service.get();
        if(name != null && !name.isEmpty())
            categoryList = service.findByName(name);
        model.addAttribute("categories",categoryList);

        return "/category/list";
    }
}
