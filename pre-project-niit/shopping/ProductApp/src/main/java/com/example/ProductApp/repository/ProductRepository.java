package com.example.ProductApp.repository;

import com.example.ProductApp.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {

    @Query("{productName: ?0}")
    List<Product> findByProductName(String productName);
}
