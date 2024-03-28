package org.example.restfullsimplejpa.restcontroller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.restfullsimplejpa.dto.ProductRequest;
import org.example.restfullsimplejpa.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductService productService;


    public HashMap<String, Object> creatResponse(Object data, String message, int statusCode) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("payload", data);
        response.put("status", statusCode);
        return response;
    }

    @GetMapping("/get-all")
    public HashMap<String, Object> getAllProduct() {
        return creatResponse(productService.getAllProduct(), "Get Data Succussfully", HttpStatus.OK.value());
    }

    @PostMapping
    public HashMap<String, Object> creatProduct(@Valid @RequestBody ProductRequest request) {
        return creatResponse(productService.createProduct(request), "Successfully Create Product", HttpStatus.CREATED.value());
    }
   @PutMapping("/{id}")
    public HashMap<String, Object> updatProduct(@Valid @RequestParam Long id, @Valid @RequestBody ProductRequest request)
    {
        return creatResponse(productService.updateProduct(id, request),"Updated",HttpStatus.OK.value());
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HashMap<String, Object> deleteProduct(@RequestParam Long id)
    {
        productService.deleteProduct(id);
        return creatResponse(new ArrayList<>(),"delete Product",HttpStatus.OK.value());
    }
}
