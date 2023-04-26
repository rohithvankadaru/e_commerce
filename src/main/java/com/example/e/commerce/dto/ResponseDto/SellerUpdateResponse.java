package com.example.e.commerce.dto.ResponseDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class SellerUpdateResponse {

    String name;

    String emailId;

    Integer age;

    String mobNo;
}
