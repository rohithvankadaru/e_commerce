package com.example.e.commerce.controller;

import com.example.e.commerce.dto.RequestDto.ProductAddRequeat;
import com.example.e.commerce.dto.ResponseDto.ProductDeleteResponse;
import com.example.e.commerce.exception.InvalidIdExecption;
import com.example.e.commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    //TODO getAllProductsOfSellerViaEmailOrId

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody ProductAddRequeat productAddRequeat){
        try {
            return new ResponseEntity(productService.add(productAddRequeat), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

   // @GetMapping("/getViaIdOrEmail")



    @GetMapping("/get/category/{productCategory}")
    public ResponseEntity getViaCategory(@PathVariable("productCategory")String productCategory){
        return new ResponseEntity<>(productService.getViaCategory(productCategory), HttpStatus.CREATED);
    }
    @DeleteMapping("delete")
    public ResponseEntity delete(@RequestParam("id") Integer id){
        try {
            ProductDeleteResponse productDeleteResponse = productService.delete(id);
            return new ResponseEntity(productDeleteResponse, HttpStatus.CREATED);
        }
        catch (InvalidIdExecption e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}




























