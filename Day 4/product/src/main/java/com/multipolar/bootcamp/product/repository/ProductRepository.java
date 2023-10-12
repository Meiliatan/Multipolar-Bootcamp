package com.multipolar.bootcamp.product.repository;

import com.multipolar.bootcamp.product.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
//    Optional<Product> findByID(String id);
//
//    Optional<Product> findByProductName(String productName);
//
//    @Query("{ 'productName' : { $regex: ?0, $options: 'i' } }")
//    List<Product> findByProductNameInsensitive(String productName);
}
