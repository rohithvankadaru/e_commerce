package com.example.e.commerce.service.impl;

import com.example.e.commerce.dao.SellerRepository;
import com.example.e.commerce.dto.RequestDto.SellerRequest;
import com.example.e.commerce.dto.RequestDto.SellerUpdateRequest;
import com.example.e.commerce.dto.ResponseDto.SellerAddResponse;
import com.example.e.commerce.dto.ResponseDto.SellerResponse;
import com.example.e.commerce.dto.ResponseDto.SellerUpdateResponse;
import com.example.e.commerce.entity.Seller;
import com.example.e.commerce.exception.EmailAlreadyExistsException;
import com.example.e.commerce.exception.InvalidSellerException;
import com.example.e.commerce.service.SellerService;
import com.example.e.commerce.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public SellerAddResponse add(SellerRequest sellerRequest) throws EmailAlreadyExistsException {

        Seller seller = SellerTransformer.sellerRequestToSeller(sellerRequest);

        Seller savedSeller;
        try {
            savedSeller = sellerRepository.save(seller);
        } catch (Exception e) {
            throw new EmailAlreadyExistsException("Email already Exists..!!");
        }

        SellerAddResponse sellerAddResponse = SellerTransformer.sellerToSellerAddResponse(savedSeller);
        return sellerAddResponse;
    }

    @Override
    public SellerResponse getSellerDetails(String emailOrMobileNo) throws InvalidSellerException {

        Seller seller;

        seller = sellerRepository.findByMobNo(emailOrMobileNo);

        if(seller == null)seller = sellerRepository.findByEmailId(emailOrMobileNo);

        if(seller == null){
            throw new InvalidSellerException("Invalid email or MobileNo..!!");
        }


        return SellerTransformer.sellerToSellerResponse(seller);

    }

    @Override
    public SellerResponse getSellerDetails(Integer id) throws InvalidSellerException {

        Seller seller;

        try {
            seller = sellerRepository.findById(id).get();
        }
        catch (Exception e){
            throw new InvalidSellerException("Invalid Id");
        }

        return SellerTransformer.sellerToSellerResponse(seller);
    }

    @Override
    public List<SellerResponse> getAll() {
        List<Seller> sellers= sellerRepository.findAll();

        List<SellerResponse> sellerResponses = new ArrayList<>();
        for(Seller seller : sellers){
            sellerResponses.add(SellerTransformer.sellerToSellerResponse(seller));
        }
        return sellerResponses;
    }

    @Override
    public SellerUpdateResponse update(SellerUpdateRequest sellerUpdateRequest) throws InvalidSellerException {

        Seller seller = sellerRepository.findByEmailId(sellerUpdateRequest.getEmailOrMobileNo());

        if(seller == null) seller = sellerRepository.findByMobNo(sellerUpdateRequest.getEmailOrMobileNo());

        if(seller == null){
            throw new InvalidSellerException("Invalid email or mobile number..!!");
        }

        Seller updatedSeller = SellerTransformer.SellerUpdateRequestToSeller(sellerUpdateRequest, seller);

        sellerRepository.save(updatedSeller);

        return SellerTransformer.SellerToSellerUpdateResponse(seller);
    }

    @Override
    public String delete(String emailOrSellerId) throws InvalidSellerException {
        Integer id;
        Seller seller;
        try {
            id = Integer.parseInt(emailOrSellerId);
            seller = sellerRepository.findById(id).get();
        }
        catch (Exception e){
            seller = sellerRepository.findByEmailId(emailOrSellerId);
            id = seller.getId();
        }
        if(seller == null){
            throw new InvalidSellerException("Invalid emailId or SellerId");
        }
        String name = seller.getName();
        sellerRepository.deleteById(id);
        return "Seller "+name+" deleted successfully";
    }
}











