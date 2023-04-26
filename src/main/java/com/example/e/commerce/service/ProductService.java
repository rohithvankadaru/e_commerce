package com.example.e.commerce.service;

import com.example.e.commerce.dto.RequestDto.ProductAddRequeat;
import com.example.e.commerce.dto.ResponseDto.ProductAddResponse;

public interface ProductService {

    public ProductAddResponse add(ProductAddRequeat productAddRequeat) throws Exception;
}
