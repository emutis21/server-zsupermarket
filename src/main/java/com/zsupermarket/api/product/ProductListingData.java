package com.zsupermarket.api.product;

public record ProductListingData(
  Long id,
  String product_name,
  String category,
  Double price,
  String product_description,
  Integer stock_quantity,
  String bar_code,
  String image_url
) {
  public ProductListingData(Product product) {
    this(
      product.getId(),
      product.getProduct_name(),
      product.getCategory().toString(),
      product.getPrice(),
      product.getProduct_description(),
      product.getStock_quantity(),
      product.getBar_code(),
      product.getImage_url()
    );
  }
}
