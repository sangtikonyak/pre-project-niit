package com.example.ProductApp.service;

import com.example.ProductApp.entity.Product;
import com.example.ProductApp.exceptions.NoProductFoundException;
import com.example.ProductApp.exceptions.ProductNotAddedException;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    List<Product> getProductByName(String productName) throws NoProductFoundException;

    List<Product> deleteProduct(String productId) throws NoProductFoundException;

    List<Product> updateProduct(Product product);

    List<Product> addProduct(Product product) throws ProductNotAddedException;

}
