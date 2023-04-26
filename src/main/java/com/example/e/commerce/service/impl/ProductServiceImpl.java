package com.example.e.commerce.service.impl;

import com.example.e.commerce.dao.ProductRepository;
import com.example.e.commerce.dao.SellerRepository;
import com.example.e.commerce.dto.RequestDto.ProductAddRequeat;
import com.example.e.commerce.dto.ResponseDto.ProductAddResponse;
import com.example.e.commerce.entity.Product;
import com.example.e.commerce.entity.Seller;
import com.example.e.commerce.exception.InvalidSellerException;
import com.example.e.commerce.service.ProductService;
import com.example.e.commerce.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public ProductAddResponse add(ProductAddRequeat productAddRequeat) throws Exception {
        Seller seller;
        try {
            seller = sellerRepository.findById(productAddRequeat.getSellerId()).get();
        }
        catch (Exception e){
            throw new InvalidSellerException("Invalid seller..!!");
        }
        Product product = ProductTransformer.productAddRequestToProduct(productAddRequeat);
        product.setSeller(seller);
        seller.getProducts().add(product);
        sellerRepository.save(seller);

        return ProductTransformer.productToProductResponse(product);
    }
}
