package com.example.e.commerce.dto.ResponseDto;

import com.example.e.commerce.enums.ProductCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ProductResponse {

    String name;

    int price;

    int quantity;

    ProductCategory productCategory;

    String  sellerName;
}
