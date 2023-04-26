package com.example.e.commerce.service;

import com.example.e.commerce.dto.RequestDto.SellerRequest;
import com.example.e.commerce.dto.RequestDto.SellerUpdateRequest;
import com.example.e.commerce.dto.ResponseDto.SellerAddResponse;
import com.example.e.commerce.dto.ResponseDto.SellerResponse;
import com.example.e.commerce.dto.ResponseDto.SellerUpdateResponse;
import com.example.e.commerce.exception.InvalidSellerException;

import java.util.List;

public interface SellerService {

    public SellerAddResponse add(SellerRequest sellerRequest) throws Exception;

    public SellerResponse getSellerDetails(String emailOrMobileNo) throws InvalidSellerException;

    public SellerResponse getSellerDetails(Integer id) throws InvalidSellerException;

    public List<SellerResponse> getAll();

    public SellerUpdateResponse update(SellerUpdateRequest sellerUpdateRequest) throws InvalidSellerException;

    public String delete(String emailOrSellerId) throws InvalidSellerException;
}
