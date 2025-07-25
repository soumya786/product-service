package com.soumya.mircroservies.product.repository;

import com.soumya.mircroservies.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    // Custom query methods (if needed) can be defined here
}

