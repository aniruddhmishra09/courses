package com.course.docker.cart.controller;

import com.course.docker.cart.model.Product;
import com.course.docker.cart.response.CartDetails;
import com.course.docker.cart.service.CartService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class CartRestController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart/{orderId}")
    public ResponseEntity<CartDetails> getCartDetails(@PathVariable("orderId") String orderId){

        log.info("Request Received to fetch Order-ID - {}",orderId);
        CartDetails cart = cartService.getCartDetails(orderId);
        return new ResponseEntity<>(cart, HttpStatus.FOUND);
    }
}
