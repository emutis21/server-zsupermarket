package com.zsupermarket.api.product;

import jakarta.validation.constraints.NotNull;

public record ProductUpdateData(
  @NotNull Long id,
  String product_name,
  Integer stock_quantity,
  String bar_code,
  String product_description,
  String image_url,
  Double price
) {}
