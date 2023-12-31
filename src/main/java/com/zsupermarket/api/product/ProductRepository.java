package com.zsupermarket.api.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
  Page<Product> findByActiveTrue(Pageable pagination);
  Page<Product> findByProductNameContainingAndActiveTrue(
    String productName,
    Pageable pagination
  );
}
