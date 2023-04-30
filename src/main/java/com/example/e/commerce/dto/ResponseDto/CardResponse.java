package com.example.e.commerce.dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CardResponse {
    String cardNo;

    String customerName;
}
