package com.example.e.commerce.controller;

import com.example.e.commerce.dto.RequestDto.ProductAddRequeat;
import com.example.e.commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    //TODO add product, getAllProductsOfACategory
    //TODO deleteAProduct, getAllProductsOfSellerViaEmailOrId

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody ProductAddRequeat productAddRequeat){
        try {
            return new ResponseEntity(productService.add(productAddRequeat), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
