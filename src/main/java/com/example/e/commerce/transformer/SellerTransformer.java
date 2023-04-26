package com.example.e.commerce.transformer;

import com.example.e.commerce.dto.RequestDto.SellerRequest;
import com.example.e.commerce.dto.RequestDto.SellerUpdateRequest;
import com.example.e.commerce.dto.ResponseDto.SellerAddResponse;
import com.example.e.commerce.dto.ResponseDto.SellerResponse;
import com.example.e.commerce.dto.ResponseDto.SellerUpdateResponse;
import com.example.e.commerce.entity.Seller;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SellerTransformer {

    public static Seller sellerRequestToSeller(SellerRequest sellerRequest){
        return Seller.builder()
                .age(sellerRequest.getAge())
                .emailId(sellerRequest.getEmailId())
                .mobNo(sellerRequest.getMobNo())
                .name(sellerRequest.getName())
                .build();
    }

    public static SellerAddResponse sellerToSellerAddResponse(Seller seller){
        return SellerAddResponse.builder()
                .name(seller.getName())
                .message("Seller added successfully")
                .build();
    }

    public static SellerResponse sellerToSellerResponse(Seller seller){
        return SellerResponse.builder()
                .id(seller.getId())
                .name(seller.getName())
                .age(seller.getAge())
                .emailId(seller.getEmailId())
                .mobNo(seller.getMobNo())
                .build();
    }

    public static Seller SellerUpdateRequestToSeller(SellerUpdateRequest sellerUpdateRequest, Seller seller){
        Integer age = sellerUpdateRequest.getAge();
        String name = sellerUpdateRequest.getName();
        String emailId = sellerUpdateRequest.getEmailId();
        String mobNo = sellerUpdateRequest.getMobileNo();
        if(age != null) seller.setAge(age);
        if(name != null) seller.setName(name);
        if(emailId != null) seller.setEmailId(emailId);
        if(mobNo != null) seller.setMobNo(mobNo);
        return seller;
    }

    public static SellerUpdateResponse SellerToSellerUpdateResponse(Seller seller) {
        return SellerUpdateResponse.builder()
                .age(seller.getAge())
                .emailId(seller.getEmailId())
                .mobNo(seller.getMobNo())
                .name(seller.getName())
                .build();
    }
}
