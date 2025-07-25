package com.soumya.mircroservies.product.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

public record ProductResponse(String id, String name, String description, BigDecimal price) {}

