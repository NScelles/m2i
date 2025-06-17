package org.example.productexercise.Controllers;

import org.example.productexercise.models.Product;
import org.example.productexercise.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(Model model) {
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "product/list";
    }

    @GetMapping("/product/{id}")
    public String show(@PathVariable UUID id, Model model) {
        model.addAttribute(productService.getProduct(id));
        return "product/details";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "category",required = false) String category,
                         @RequestParam(value = "priceMax",required = false) String priceMax, Model model) {
        List<Product> productsList = productService.getProducts();
        productsList = productService.getProductsByCategory(productsList, category);
        productsList = productService.getProductsByPriceMax(productsList, priceMax);
        model.addAttribute("products", productsList);
        return "product/list";
    }
}
