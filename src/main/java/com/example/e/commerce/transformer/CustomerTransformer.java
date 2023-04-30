package com.example.e.commerce.transformer;

import com.example.e.commerce.dto.RequestDto.CustomerAddRequest;
import com.example.e.commerce.dto.ResponseDto.CustomerCRUDResponse;
import com.example.e.commerce.dto.ResponseDto.CustomerResponse;
import com.example.e.commerce.entity.Customer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerTransformer {

    public static Customer customerAddRequestToCustomer(CustomerAddRequest customerAddRequest){
        return Customer.builder()
                .age(customerAddRequest.getAge())
                .mobileNo(customerAddRequest.getMobNo())
                .name(customerAddRequest.getName())
                .emailId(customerAddRequest.getEmailId())
                .address(customerAddRequest.getAddress())
                .build();
    }

    public static CustomerCRUDResponse customerToCustomerAddResponse(Customer customer){
        return CustomerCRUDResponse.builder()
                .message("Welcome")
                .name(customer.getName())
                .build();
    }
    public static CustomerResponse customerToCustomerResponse(Customer customer){
        return CustomerResponse.builder()
                .address(customer.getAddress())
                .age(customer.getAge())
                .name(customer.getName())
                .emailId(customer.getEmailId())
                .mobileNo(customer.getMobileNo())
                .build();
    }
}
