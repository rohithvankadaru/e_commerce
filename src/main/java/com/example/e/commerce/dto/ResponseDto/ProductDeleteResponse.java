package com.example.e.commerce.dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDeleteResponse {

    String productName;

    String message;
}
