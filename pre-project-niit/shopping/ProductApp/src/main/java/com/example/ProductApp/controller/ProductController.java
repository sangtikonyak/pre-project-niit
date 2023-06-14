package com.example.ProductApp.controller;

import com.example.ProductApp.entity.Product;
import com.example.ProductApp.exceptions.NoProductFoundException;
import com.example.ProductApp.exceptions.ProductNotAddedException;
import com.example.ProductApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAll-products")
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/v1/get-product/{productName}")
    public ResponseEntity<?> getProductByName(@PathVariable("productName") String productName) throws NoProductFoundException {
        return new ResponseEntity<>(productService.getProductByName(productName),HttpStatus.OK);
    }
    @PostMapping("/v1/admin/add-product")
    public ResponseEntity<?> addProductToAdminDb(@RequestBody Product product) throws ProductNotAddedException {
        return new ResponseEntity<>(productService.addProduct(product),HttpStatus.CREATED);
    }
    @DeleteMapping("/v1/admin/delete/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") String productId) throws NoProductFoundException {
        return new ResponseEntity<>(productService.deleteProduct(productId),HttpStatus.OK);
    }
    @PutMapping("/v1/admin/update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(product),HttpStatus.OK);
    }
}
