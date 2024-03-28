package org.example.restfullsimplejpa.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.example.restfullsimplejpa.dto.ProductRequest;
import org.example.restfullsimplejpa.dto.ProductResponse;
import org.example.restfullsimplejpa.mapper.ProductMapper;
import org.example.restfullsimplejpa.model.Product;
import org.example.restfullsimplejpa.repository.ProductRepository;
import org.example.restfullsimplejpa.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    public Product findId(Long id)
    {
        return  productRepository.findById(id).orElseThrow(()->new RuntimeException("id not found"));
    }

@Override
    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::mapToProductResponse).toList();
    }

    @Override
    public ProductResponse createProduct(ProductRequest request) {
//        var product = productMapper.mapRequestToProduct(productRequest);
//        System.out.println(product);
        return productMapper.mapToProductResponse(productRepository.save(productMapper.mapRequestToProduct(request)));
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest request) {
//     var newProduct=findId(id);
//     return productMapper.mapToProductResponse(productRepository.save(newProduct));
        Product product=productRepository.findById(id).orElse(null);
        if(product==null){
            throw new IllegalArgumentException("Product not found with id: " + id);
        }
        product=productMapper.mapRequestToProduct(request);
        product.setId(id);
        return productMapper.mapToProductResponse(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Long id) {
        var newProduct = findId(id);
        productRepository.delete(newProduct);
    }
}
