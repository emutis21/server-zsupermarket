package com.zsupermarket.api.product;

import jakarta.validation.constraints.NotNull;

public record ProductUpdateData(
  @NotNull Long id,
  String productName,
  Integer stockQuantity,
  String barCode,
  String productDescription,
  String imageUrl,
  Double price
) {}
