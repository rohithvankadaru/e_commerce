package com.example.e.commerce.service;

import com.example.e.commerce.dto.RequestDto.ProductAddRequeat;
import com.example.e.commerce.dto.ResponseDto.ProductAddResponse;
import com.example.e.commerce.dto.ResponseDto.ProductDeleteResponse;
import com.example.e.commerce.dto.ResponseDto.ProductResponse;
import com.example.e.commerce.exception.InvalidIdExecption;

import java.util.List;


public interface ProductService {

    public ProductAddResponse add(ProductAddRequeat productAddRequeat) throws Exception;

    public List<ProductResponse> getViaCategory(String productCategory);

    public ProductDeleteResponse delete(Integer id) throws InvalidIdExecption;
}
