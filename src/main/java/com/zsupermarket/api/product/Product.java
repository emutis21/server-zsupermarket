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

  private String productName;
  private String productDescription;
  private Double price;
  private Integer stockQuantity;
  private String barCode;
  private String imageUrl;

  private Boolean active;

  @Enumerated(EnumType.STRING)
  private Category category;

  public Product(ProductRegistrationData ProductRegistrationData) {
    this.active = true;
    this.productName = ProductRegistrationData.productName();
    this.productDescription = ProductRegistrationData.productDescription();
    this.stockQuantity = ProductRegistrationData.stockQuantity();
    this.barCode = ProductRegistrationData.barCode();
    this.price = ProductRegistrationData.price();
    this.category = ProductRegistrationData.category();
    this.imageUrl = ProductRegistrationData.imageUrl();
  }

  public void updateData(ProductUpdateData productUpdateData) {
    if (productUpdateData.productName() != null) {
      this.productName = productUpdateData.productName();
    }
    if (productUpdateData.stockQuantity() != null) {
      this.stockQuantity = productUpdateData.stockQuantity();
    }
  }

  public void isProductDisabled() {
    this.active = false;
  }

  public void isProductActive() {
    this.active = true;
  }
}
