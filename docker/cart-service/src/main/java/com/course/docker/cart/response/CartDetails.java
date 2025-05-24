package com.course.docker.cart.response;

import com.course.docker.cart.model.Product;
import lombok.Data;
import java.util.List;

@Data
public class CartDetails {
    private String orderId;
    private List<Product> products;
}
