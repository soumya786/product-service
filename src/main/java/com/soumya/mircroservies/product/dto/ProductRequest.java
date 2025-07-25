package com.soumya.mircroservies.product.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


public record ProductRequest(String id, String name, String description, BigDecimal price) { }

