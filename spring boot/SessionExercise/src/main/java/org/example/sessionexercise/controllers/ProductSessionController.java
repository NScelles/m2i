package org.example.sessionexercise.controllers;

import jakarta.servlet.http.HttpSession;
import org.example.sessionexercise.dtos.cart.CartItemResponseDto;
import org.example.sessionexercise.dtos.product.ProductResponseDto;
import org.example.sessionexercise.models.CartItem;
import org.example.sessionexercise.services.CartService;
import org.example.sessionexercise.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/api/product/session")
public class ProductSessionController {

    private CartService service;
    private HttpSession session;

    public ProductSessionController(CartService cartService, HttpSession session) {
        service = cartService;
        this.session = session;
    }

    @GetMapping("/cart/add/{id}")
    public ResponseEntity<String> addToCart (@PathVariable UUID id){
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        service.setSession(cart);
        session.setAttribute("cart",service.addProduct(id));
        return ResponseEntity.ok("Product added to cart");
    }

    @GetMapping("/cart/remove/{id}")
    public ResponseEntity<String> removeToCart (@PathVariable UUID id){
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        service.setSession(cart);
        session.setAttribute("cart",service.removeProduct(id));
        return ResponseEntity.ok("Product removed to cart");
    }

    @GetMapping("/cart")
    public ResponseEntity<List<CartItemResponseDto>> getCart (){
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        service.setSession(cart);
        return ResponseEntity.ok(service.getCart());
    }

    @GetMapping("/cart/buy")
    public ResponseEntity<String> buyCart (){
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        service.setSession(cart);
        return ResponseEntity.ok("Vous avez payé " + service.buyProduct() +  " €");
    }
}
