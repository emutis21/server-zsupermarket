package com.zsupermarket.api.product;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "products")
@Entity(name = "Product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String product_name;
  private String product_description;
  private Double price;
  private Integer stock_quantity;
  private String bar_code;
  private String image_url;

  private Boolean active;

  @Enumerated(EnumType.STRING)
  private Category category;

  public Product(ProductRegistrationData ProductRegistrationData) {
    this.active = true;
    this.product_name = ProductRegistrationData.product_name();
    this.product_description = ProductRegistrationData.product_description();
    this.stock_quantity = ProductRegistrationData.stock_quantity();
    this.bar_code = ProductRegistrationData.bar_code();
    this.price = ProductRegistrationData.price();
    this.category = ProductRegistrationData.category();
    this.image_url = ProductRegistrationData.image_url();
  }

  public void updateData(ProductUpdateData productUpdateData) {
    if (productUpdateData.product_name() != null) {
      this.product_name = productUpdateData.product_name();
    }
    if (productUpdateData.stock_quantity() != null) {
      this.stock_quantity = productUpdateData.stock_quantity();
    }
  }

  public void isProductDisabled() {
    this.active = false;
  }

  public void isProductActive() {
    this.active = true;
  }
}
