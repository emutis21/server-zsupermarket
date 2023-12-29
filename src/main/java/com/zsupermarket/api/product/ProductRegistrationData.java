package com.zsupermarket.api.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ProductRegistrationData(
  @NotBlank String productName,
  @NotBlank String productDescription,
  @NotNull Integer stockQuantity,
  @NotNull Double price,
  @NotBlank
  @Pattern(
    regexp = "[a-zA-Z0-9]{8}-[a-zA-Z0-9]{4}-[a-zA-Z0-9]{4}-[a-zA-Z0-9]{4}-[a-zA-Z0-9]{12}"
  )
  @NotBlank
  String barCode,
  @NotNull Category category,
  @NotBlank String imageUrl
) {}
