package com.example.ProductApp.service;

import com.example.ProductApp.entity.Product;
import com.example.ProductApp.entity.UserProduct;
import com.example.ProductApp.repository.UserProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserProductImpl implements UserProductService{

    @Autowired
    private UserProductRepository userProductRepository;
    @Override
    public UserProduct addProduct(Product product,String email) {
        UserProduct userProduct = new UserProduct();
        if (userProductRepository.findById(email).isPresent()) {
            userProduct = userProductRepository.findByEmail(email);
        }
        if (userProduct.getProductList()==null)
        {
            userProduct.setProductList(Arrays.asList(product));
        }
        else {
            List<Product> productList=userProduct.getProductList();
            productList.add(product);
            userProduct.setProductList(productList);
        }
       return userProductRepository.save(userProduct);
    }

    @Override
    public UserProduct saveUser(UserProduct userProduct) {
        return userProductRepository.save(userProduct);
    }

    @Override
    public List<Product> getAllProductFromCart(String email) {
        List<Product> productList=new ArrayList<>();
        if (userProductRepository.findById(email).isPresent())
        {
            productList=userProductRepository.findByEmail(email).getProductList();
        }
        return productList;
    }
}
