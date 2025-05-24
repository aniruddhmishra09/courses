package com.course.docker.cart.service.impl;

import com.course.docker.cart.model.Product;
import com.course.docker.cart.response.CartDetails;
import com.course.docker.cart.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Override
    public CartDetails getCartDetails(String orderId) {
        CartDetails cart = new CartDetails();
        cart.setProducts(List.of(new Product("P1001", 5L)));
        cart.setOrderId("OR101");
        return cart;
    }
}
