package com.example.e.commerce.dto.RequestDto;

import com.example.e.commerce.enums.ProductCategory;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductAddRequeat {

    String name;

    int price;

    int quantity;

    ProductCategory productCategory;

    int sellerId;
}
