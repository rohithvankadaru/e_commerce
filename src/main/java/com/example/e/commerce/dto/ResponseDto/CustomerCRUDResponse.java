package com.example.e.commerce.dto.ResponseDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data

public class CustomerCRUDResponse {

    String name;

    String message;
}
