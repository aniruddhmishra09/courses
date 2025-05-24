package com.course.docker.cart.service;

import com.course.docker.cart.response.CartDetails;

public interface CartService {
    CartDetails getCartDetails(String orderId);
}
