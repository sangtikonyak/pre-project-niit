package com.example.ProductApp.controller;

import com.example.ProductApp.entity.Product;
import com.example.ProductApp.entity.UserProduct;
import com.example.ProductApp.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/product")
public class UserProductController {

    @Autowired
    private UserProductService userProductService;

    @PostMapping("/save-user")
    public ResponseEntity<?> saveUser(@RequestBody UserProduct userProduct){
        return new ResponseEntity<>(userProductService.saveUser(userProduct),HttpStatus.CREATED);
    }
    @PostMapping("/v1/add-product")
    public ResponseEntity<?> addProduct(@RequestBody Product product, HttpServletRequest request){
      //  String email= (String) request.getAttribute("user_emailid");
        String email= (String) request.getAttribute("email");
        String role= (String) request.getAttribute("user_role");
        System.out.println("email from email1"+ email);
        System.out.println("role from request"+ role);
        return new ResponseEntity<>(userProductService.addProduct(product,email), HttpStatus.OK);
    }
    @GetMapping("/v1/cart-product")
    public ResponseEntity<?> getProductsFromCart(HttpServletRequest request){
        String email= (String) request.getAttribute("email");
        return new ResponseEntity<>(userProductService.getAllProductFromCart(email),HttpStatus.OK);
    }
}
