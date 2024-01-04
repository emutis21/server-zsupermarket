package com.zsupermarket.api.controller;

import com.zsupermarket.api.product.Product;
import com.zsupermarket.api.product.ProductListingData;
import com.zsupermarket.api.product.ProductRegistrationData;
import com.zsupermarket.api.product.ProductRepository;
import com.zsupermarket.api.product.ProductUpdateData;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @PostMapping
  public void registrarProduct(
    @RequestBody @Valid ProductRegistrationData productRegistrationData
  ) {
    productRepository.save(new Product(productRegistrationData));
  }

  @GetMapping
  public Page<ProductListingData> ProductList(
    @RequestParam(defaultValue = "1") int page,
    @RequestParam(required = false) String query,
    @PageableDefault(size = 6) Pageable pagination
  ) {
    int adjustedPage = page - 1;
    Pageable ajustedPagination = PageRequest.of(
      adjustedPage,
      pagination.getPageSize(),
      pagination.getSort()
    );

    if (query != null && !query.isEmpty()) {
      return productRepository
        .findByProductNameContainingAndActiveTrue(query, ajustedPagination)
        .map(ProductListingData::new);
    } else {
      return productRepository
        .findByActiveTrue(ajustedPagination)
        .map(ProductListingData::new);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductListingData> getProductById(
    @PathVariable Long id
  ) {
    Product product = productRepository.findById(id).orElse(null);
    if (product != null && product.getActive()) {
      return ResponseEntity.ok(new ProductListingData(product));
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping
  @Transactional
  public void updateProduct(
    @RequestBody @Valid ProductUpdateData productUpdateData
  ) {
    Product product = productRepository.getReferenceById(
      productUpdateData.id()
    );
    product.updateData(productUpdateData);
  }

  // DELETE LOGICO
  @DeleteMapping("/{id}")
  @Transactional
  // public void deleteProduct(@PathVariable Long id) {
  //   Product product = productRepository.getReferenceById(id);
  //   product.desactivarProduct();
  // }
  //    DELETE EN BASE DE DATOD
  public void deleteProduct(@PathVariable Long id) {
    Product product = productRepository.getReferenceById(id);
    productRepository.delete(product);
  }
}
