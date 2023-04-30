package com.example.e.commerce.service;

import com.example.e.commerce.dto.RequestDto.CustomerAddRequest;
import com.example.e.commerce.dto.ResponseDto.CustomerCRUDResponse;
import com.example.e.commerce.dto.ResponseDto.CustomerResponse;
import com.example.e.commerce.exception.InvalidEmailOrMobileNoExecption;

import java.util.List;

public interface CustomerService {

    public CustomerCRUDResponse createAccount(CustomerAddRequest customerAddRequest) throws Exception;

    public CustomerResponse details(String emailOrMobileNo) throws InvalidEmailOrMobileNoExecption;

    public List<CustomerResponse> all();

    public List<CustomerResponse> customerOfSpecificCardType(String cardType);

    public CustomerCRUDResponse delete(String emailOrMobileNo) throws InvalidEmailOrMobileNoExecption;
}
