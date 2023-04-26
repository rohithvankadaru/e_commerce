package com.example.e.commerce.dto.ResponseDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductAddResponse {

    String productName;

    int quantity;

    String message;

    String seller;
}
