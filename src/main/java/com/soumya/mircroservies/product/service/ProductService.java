package com.soumya.mircroservies.product.service;

import com.soumya.mircroservies.product.dto.ProductRequest;
import com.soumya.mircroservies.product.dto.ProductResponse;
import com.soumya.mircroservies.product.model.Product;
import com.soumya.mircroservies.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .id(productRequest.id())
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product created: {}", product);
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice());
    }


    public List<ProductResponse> getAllProducts() {
    return productRepository.findAll()
            .stream()
            .map(product -> new ProductResponse(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getPrice()))
            .toList();
    }
}

