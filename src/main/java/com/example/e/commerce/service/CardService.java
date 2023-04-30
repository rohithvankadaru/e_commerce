package com.example.e.commerce.service;


import com.example.e.commerce.dto.RequestDto.CardRequest;
import com.example.e.commerce.dto.ResponseDto.CardResponse;
import com.example.e.commerce.exception.InvalidMobileNoException;
import com.example.e.commerce.exception.RepeatedCardNumberException;

import java.util.List;

public interface CardService {
    public CardResponse add(CardRequest cardRequest) throws InvalidMobileNoException, RepeatedCardNumberException;

    public List<CardResponse> getViaCardType(String cardType) throws Exception;

    public String getCardTypeOfHighestUsers();

    public String lowestUsedCardType();
}
