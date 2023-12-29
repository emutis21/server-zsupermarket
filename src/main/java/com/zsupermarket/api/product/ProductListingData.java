package com.zsupermarket.api.product;

public record ProductListingData(
  Long id,
  String productName,
  String category,
  Double price,
  String productDescription,
  Integer stockQuantity,
  String barCode,
  String imageUrl
) {
  public ProductListingData(Product product) {
    this(
      product.getId(),
      product.getProductName(),
      product.getCategory().toString(),
      product.getPrice(),
      product.getProductDescription(),
      product.getStockQuantity(),
      product.getBarCode(),
      product.getImageUrl()
    );
  }
}
