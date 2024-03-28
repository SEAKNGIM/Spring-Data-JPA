package org.example.restfullsimplejpa.service;

import org.example.restfullsimplejpa.dto.ProductRequest;
import org.example.restfullsimplejpa.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProduct();
    ProductResponse createProduct(ProductRequest productRequest);
    ProductResponse updateProduct(Long id, ProductRequest request);
    void deleteProduct(Long id);

}
