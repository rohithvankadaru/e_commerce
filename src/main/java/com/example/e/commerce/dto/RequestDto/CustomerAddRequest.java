package com.example.e.commerce.dto.RequestDto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class CustomerAddRequest {

    String name;

    String emailId;

    Integer age;

    String mobNo;

    String address;
}
