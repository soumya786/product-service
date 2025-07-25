// Product.java - Model class for Product entity stored in MongoDB
package com.soumya.mircroservies.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;

@Document(value = "product") // Maps this class to the 'product' collection in MongoDB
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Lombok annotation to generate no-args constructor
@AllArgsConstructor // Lombok annotation to generate all-args constructor
@Builder // Lombok annotation to implement builder pattern
public class Product {
    @Id // Marks this field as the primary key in MongoDB
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
