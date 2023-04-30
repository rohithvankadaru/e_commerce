package com.example.e.commerce.controller;

import com.example.e.commerce.dto.RequestDto.CustomerAddRequest;
import com.example.e.commerce.dto.ResponseDto.CustomerCRUDResponse;
import com.example.e.commerce.exception.InvalidEmailOrMobileNoExecption;
import com.example.e.commerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/createAccount")
    public ResponseEntity createAccount(@RequestBody CustomerAddRequest customerAddRequest){
        CustomerCRUDResponse customerCRUDResponse;
        try {
            customerCRUDResponse = customerService.createAccount(customerAddRequest);
            return new ResponseEntity(customerCRUDResponse, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/details")
    public ResponseEntity customerDetails(@RequestParam("emailOrMobileNo") String emailOrMobileNo){
        try {
            return new ResponseEntity<>(customerService.details(emailOrMobileNo), HttpStatus.CREATED);
        } catch (InvalidEmailOrMobileNoExecption e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity all(){
        return new ResponseEntity<>(customerService.all(), HttpStatus.CREATED);
    }

    @GetMapping("/SpecificCardType")
    public ResponseEntity customerOfSpecificCardType(@RequestParam("cardType") String cardType){
        return new ResponseEntity<>(customerService.customerOfSpecificCardType(cardType), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam("emailOrMobileNo") String emailOrMobileNo){
        try {
            return new ResponseEntity<>(customerService.delete(emailOrMobileNo),HttpStatus.CREATED);
        }
        catch (InvalidEmailOrMobileNoExecption e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    //TODO get a customer by email/mob

    //TODO get all customers whose age is greater than 25

    //TODO update a customer info by email

}
