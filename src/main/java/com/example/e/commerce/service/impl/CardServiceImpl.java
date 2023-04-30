package com.example.e.commerce.service.impl;

import com.example.e.commerce.dao.CardRepository;
import com.example.e.commerce.dao.CustomerRepository;
import com.example.e.commerce.dto.RequestDto.CardRequest;
import com.example.e.commerce.dto.ResponseDto.CardResponse;
import com.example.e.commerce.entity.Card;
import com.example.e.commerce.entity.Customer;
import com.example.e.commerce.exception.InvalidMobileNoException;
import com.example.e.commerce.exception.RepeatedCardNumberException;
import com.example.e.commerce.service.CardService;
import com.example.e.commerce.transformer.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public CardResponse add(CardRequest cardRequest) throws InvalidMobileNoException, RepeatedCardNumberException {

        Customer customer = customerRepository.findByMobileNo(cardRequest.getCustomerMobileNo());
        if(customer == null){
            throw new InvalidMobileNoException("Invalid Mobile number..!!");
        }
        Card card = CardTransformer.cardRequestToCard(cardRequest);
        card.setCustomer(customer);
        customer.getCards().add(card);
        Customer savedCustomer;
        try {
            savedCustomer = customerRepository.save(customer);
        }
        catch (Exception e){
            throw new RepeatedCardNumberException("Card number already exists");
        }

        return new CardResponse(card.getCardNo(), savedCustomer.getName());
    }

    @Override
    public List<CardResponse> getViaCardType(String cardType) throws Exception {
        List<Card> cards;
        try {
            cards = cardRepository.getViaCardType(cardType);
        }
        catch (Exception e){
            throw new Exception("No such Category");
        }
        List<CardResponse> cardResponses = new ArrayList<>();
        for(Card card : cards){
            cardResponses.add(CardTransformer.CardToCardResponse(card));
        }
        return cardResponses;
    }
    public String getCardTypeOfHighestUsers(){
        return cardRepository.getCardTypeOfHighestUsers();
    }

    @Override
    public String lowestUsedCardType() {
        return cardRepository.LowestUsedCardType();
    }
}
