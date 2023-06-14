package com.example.ProductApp.repository;

import com.example.ProductApp.entity.UserProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProductRepository extends MongoRepository<UserProduct,String> {

    UserProduct findByEmail(String email);
}
