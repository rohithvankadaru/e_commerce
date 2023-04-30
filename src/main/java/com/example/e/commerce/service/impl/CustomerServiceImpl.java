package com.example.e.commerce.service.impl;

import com.example.e.commerce.dao.CardRepository;
import com.example.e.commerce.dao.CustomerRepository;
import com.example.e.commerce.dto.RequestDto.CustomerAddRequest;
import com.example.e.commerce.dto.ResponseDto.CustomerResponse;
import com.example.e.commerce.entity.Cart;
import com.example.e.commerce.entity.Customer;
import com.example.e.commerce.dto.ResponseDto.CustomerCRUDResponse;
import com.example.e.commerce.exception.InvalidEmailOrMobileNoExecption;
import com.example.e.commerce.service.CustomerService;
import com.example.e.commerce.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CardRepository cardRepository;

    @Override
    public CustomerCRUDResponse createAccount(CustomerAddRequest customerAddRequest){
        Customer customer = CustomerTransformer.customerAddRequestToCustomer(customerAddRequest);

        Cart cart = Cart.builder()
                .cartValue(0)
                .numberOfItems(0)
                .customer(customer)
                .build();
        customer.setCart(cart);
        Customer savedCustomer;

        savedCustomer = customerRepository.save(customer);


        return CustomerTransformer.customerToCustomerAddResponse(customer);
    }

    @Override
    public CustomerResponse details(String emailOrMobileNo) throws InvalidEmailOrMobileNoExecption {
        Customer customer = customerRepository.findByEmailId(emailOrMobileNo);

        if (customer == null) customer = customerRepository.findByMobileNo(emailOrMobileNo);

        if (customer == null){
            throw new InvalidEmailOrMobileNoExecption("invalid mobile number or email..!!");
        }

        return CustomerTransformer.customerToCustomerResponse(customer);
    }

    @Override
    public List<CustomerResponse> all() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer : customers) {
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }

    @Override
    public List<CustomerResponse> customerOfSpecificCardType(String cardType) {
       List<Integer> customerIds = cardRepository.customerIdOfSpecificCard(cardType);
       List<CustomerResponse> customersResponses = new ArrayList<>();
        for (Integer customerId : customerIds) {
            customersResponses.add(CustomerTransformer.customerToCustomerResponse(customerRepository.findById(customerId).get()));
        }
        return customersResponses;
    }

    @Override
    public CustomerCRUDResponse delete(String emailOrMobileNo) throws InvalidEmailOrMobileNoExecption {
        Customer customer = customerRepository.findByMobileNo(emailOrMobileNo);

        if(customer == null)customer =  customerRepository.findByEmailId(emailOrMobileNo);

        if(customer == null) {
            throw new InvalidEmailOrMobileNoExecption("Invalid email or Mobile number..!!");
        }
        customerRepository.delete(customer);

        CustomerCRUDResponse customerCRUDResponse = CustomerCRUDResponse.builder()
                .message("Customer deleted..!!")
                .name(customer.getName())
                .build();
        return customerCRUDResponse;
    }
}
