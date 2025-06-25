package org.example.sessionexercise.controllers;

import jakarta.servlet.http.HttpSession;
import org.example.sessionexercise.dtos.product.ProductResponseDto;
import org.example.sessionexercise.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/product/session")
public class ProductSessionController {

    private ProductService service;
    private HttpSession session;

    public ProductSessionController(ProductService productService, HttpSession session) {
        this.service = productService;
        this.session = session;
    }

    @GetMapping("/cart/add/{id}")
    public ResponseEntity<String> addToCart (@PathVariable UUID id){
        List<UUID> cart = (List<UUID>) session.getAttribute("cart");
        if(cart == null)
            cart = new ArrayList<>();
        cart.add(service.get(id).getId());
        session.setAttribute("cart",cart);
        return ResponseEntity.ok("Product added to cart");
    }

    @GetMapping("/cart/remove/{id}")
    public ResponseEntity<String> removeToCart (@PathVariable UUID id){
        List<UUID> cart = (List<UUID>) session.getAttribute("cart");
        if(cart == null)
            cart = new ArrayList<>();
        cart.remove(service.get(id).getId());
        session.setAttribute("cart",cart);
        return ResponseEntity.ok("Product removed to cart");
    }

    @GetMapping("/cart")
    public ResponseEntity<List<ProductResponseDto>> getCart (){
    List<UUID> cart = (List<UUID>) session.getAttribute("cart");
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        if(cart != null)
            for (UUID id : cart)
                productResponseDtos.add(service.get(id));
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ArrayList<>());
        return ResponseEntity.ok(productResponseDtos);
    }

    @GetMapping("/cart/buy")
    public ResponseEntity<String> buyCart (){
        List<UUID> cart = (List<UUID>) session.getAttribute("cart");
        double totalPrice = 0;
        if(cart != null)
            for (UUID id : cart)
                totalPrice += service.get(id).getPrice();
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No cart available");
        return ResponseEntity.ok("Vous avez payé " + totalPrice +  " €");
    }
}
