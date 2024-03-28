package org.example.restfullsimplejpa.mapper;

import org.example.restfullsimplejpa.dto.ProductRequest;
import org.example.restfullsimplejpa.dto.ProductResponse;
import org.example.restfullsimplejpa.model.Product;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse mapToProductResponse(Product product);

    Product mapRequestToProduct(ProductRequest request);
@AfterMapping
    default void setId(@MappingTarget Product product) {
        product.setId(0L);
    }
}
