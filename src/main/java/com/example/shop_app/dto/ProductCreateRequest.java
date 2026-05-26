package com.example.shop_app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductCreateRequest {
    
    private Long SellerId;
    private String name;
    private String description;
    private int price;
}
