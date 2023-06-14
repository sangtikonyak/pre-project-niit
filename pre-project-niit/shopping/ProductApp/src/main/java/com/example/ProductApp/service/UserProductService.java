package com.example.ProductApp.service;

import com.example.ProductApp.entity.Product;
import com.example.ProductApp.entity.UserProduct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserProductService {

    UserProduct addProduct(Product product,String email);

    UserProduct saveUser(UserProduct userProduct);

    List<Product> getAllProductFromCart(String email);
}
