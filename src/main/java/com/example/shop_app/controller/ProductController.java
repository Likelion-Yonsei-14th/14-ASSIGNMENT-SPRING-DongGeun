package com.example.shop_app.controller;

import com.example.shop_app.dto.ProductCreateRequest;
import com.example.shop_app.dto.ProductResponse;
import com.example.shop_app.dto.ProductUpdateRequest;
import com.example.shop_app.service.ProductService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductCreateRequest request) {
        ProductResponse response = productService.createProduct(request);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response);
    }


    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> response = productService.getAllProducts();

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable("productId") Long productId,
            @RequestBody ProductUpdateRequest request
    )   {
        ProductResponse response = productService.updateProduct(productId, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);

        return ResponseEntity.ok(
                Map.of("message", "상품이 삭제되었습니다.")
        );
    }
}
