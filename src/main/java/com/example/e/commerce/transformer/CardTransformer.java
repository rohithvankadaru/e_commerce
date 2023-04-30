package com.example.e.commerce.transformer;

import com.example.e.commerce.dto.RequestDto.CardRequest;
import com.example.e.commerce.dto.ResponseDto.CardResponse;
import com.example.e.commerce.entity.Card;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CardTransformer {

    public static Card cardRequestToCard(CardRequest cardRequest){
        return Card.builder()
                .cardNo(cardRequest.getCardNo())
                .cardType(cardRequest.getCardType())
                .cvv(cardRequest.getCvv())
                .expairyDate(cardRequest.getExpiryDate())
                .build();
    }
    public static CardResponse CardToCardResponse(Card card){
        return CardResponse.builder()
                .cardNo(card.getCardNo())
                .customerName(card.getCustomer().getName())
                .build();
    }
}
