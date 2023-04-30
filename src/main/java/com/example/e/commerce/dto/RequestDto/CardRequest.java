package com.example.e.commerce.dto.RequestDto;

import com.example.e.commerce.enums.CardType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class CardRequest {

    String cardNo;

    Integer cvv;

    Date expiryDate;

    CardType cardType;

    String customerMobileNo;
}
