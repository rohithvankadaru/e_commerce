package com.example.e.commerce.dto.ResponseDto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellerResponse {

    int id;

    String name;

    String emailId;

    Integer age;

    String mobNo;
}
