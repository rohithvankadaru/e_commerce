package com.example.e.commerce.controller;

import com.example.e.commerce.dto.RequestDto.SellerRequest;
import com.example.e.commerce.dto.RequestDto.SellerUpdateRequest;
import com.example.e.commerce.dto.ResponseDto.SellerAddResponse;
import com.example.e.commerce.dto.ResponseDto.SellerResponse;
import com.example.e.commerce.exception.InvalidSellerException;
import com.example.e.commerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping("/createAccount")
    public ResponseEntity createAccount(@RequestBody SellerRequest sellerRequest) {
        try {
            SellerAddResponse sellerAddResponse = sellerService.add(sellerRequest);
            return new ResponseEntity(sellerAddResponse, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity get(@RequestParam("emailOrMobNo") String emailOrMobNo) throws Exception {
        try {
            SellerResponse sellerResponse = sellerService.getSellerDetails(emailOrMobNo);
            return new ResponseEntity(sellerResponse, HttpStatus.CREATED);
        }
        catch (InvalidSellerException e){
           return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        try {
            SellerResponse sellerResponse = sellerService.getSellerDetails(id);
            return new ResponseEntity<>(sellerResponse, HttpStatus.CREATED);
        } catch (InvalidSellerException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SellerResponse>> getAll(){
        return new ResponseEntity<>(sellerService.getAll(), HttpStatus.CREATED);
    }

    @PutMapping("/updatedetails")
    public ResponseEntity update(@RequestBody SellerUpdateRequest sellerUpdateRequest){
        try {
            return new ResponseEntity<>(sellerService.update(sellerUpdateRequest), HttpStatus.CREATED);
        }
        catch (InvalidSellerException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{emailOrSellerId}")
    public ResponseEntity delete(@PathVariable("emailOrSellerId") String emailOrSellerId){
       try {
           return new ResponseEntity(sellerService.delete(emailOrSellerId), HttpStatus.CREATED);
       }
       catch (InvalidSellerException e){
           return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
       }
    }
}
