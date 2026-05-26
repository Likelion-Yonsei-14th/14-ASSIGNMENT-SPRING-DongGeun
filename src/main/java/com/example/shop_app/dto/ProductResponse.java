package com.example.shop_app.dto;

import com.example.shop_app.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ProductResponse {
    
    private Long id;
    private Long sellerId;
    private String sellerNickname;
    private String name;
    private String description;
    private int price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getMember().getId(),
                product.getMember().getNickname(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }
}
