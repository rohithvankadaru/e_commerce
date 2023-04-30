package com.example.e.commerce.controller;

import com.example.e.commerce.dto.RequestDto.CardRequest;
import com.example.e.commerce.dto.ResponseDto.CardResponse;
import com.example.e.commerce.exception.InvalidMobileNoException;
import com.example.e.commerce.exception.RepeatedCardNumberException;
import com.example.e.commerce.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody CardRequest cardRequest){
        try {
            CardResponse cardResponse = cardService.add(cardRequest);
            return new ResponseEntity(cardResponse, HttpStatus.CREATED);
        }
        catch (InvalidMobileNoException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (RepeatedCardNumberException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getViaCardType")
    public ResponseEntity getViaCardType(@RequestParam String cardType){
        try {
            List<CardResponse> cardResponses = cardService.getViaCardType(cardType);
            return new ResponseEntity<>(cardResponses, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/highestUsedCard")
    public ResponseEntity highestUsedCard(){
        return new ResponseEntity<>(cardService.getCardTypeOfHighestUsers(), HttpStatus.CREATED);
    }

    @GetMapping("/lowestUsedCardType")
    public ResponseEntity lowestUsedCard(){
        return new ResponseEntity(cardService.lowestUsedCardType(),HttpStatus.CREATED);
    }
}









