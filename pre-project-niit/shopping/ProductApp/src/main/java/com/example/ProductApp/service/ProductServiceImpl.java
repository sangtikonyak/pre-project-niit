package com.example.ProductApp.service;

import com.example.ProductApp.entity.Product;
import com.example.ProductApp.exceptions.NoProductFoundException;
import com.example.ProductApp.exceptions.ProductNotAddedException;
import com.example.ProductApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductByName(String productName) throws NoProductFoundException {
       if (productRepository.findByProductName(productName)==null)
       {
           throw new NoProductFoundException();
       }
       return productRepository.findByProductName(productName);
    }

    @Override
    public List<Product> deleteProduct(String productId) throws NoProductFoundException {
        boolean flag=false;
        if (productRepository.findById(productId).isEmpty()){
            throw new NoProductFoundException();
        }
        productRepository.deleteById(productId);
       return productRepository.findAll();
    }

    @Override
    public List<Product> updateProduct(Product product)  {
        Product productFromDb=productRepository.findById(product.getProductId()).get();
        if (product.getProductName()!=null){
            productFromDb.setProductName(product.getProductName());
        }
        if (product.getProductDesc()!=null)
        {
         productFromDb.setProductDesc(product.getProductDesc());
        }
      productRepository.save(productFromDb);
        return productRepository.findAll();
    }

    @Override
    public List<Product> addProduct(Product product) throws ProductNotAddedException {
        if (product.getProductId()==null)
        {
            throw new ProductNotAddedException();
        }
        else {
            productRepository.save(product);
        }
        return productRepository.findAll();
    }
}
