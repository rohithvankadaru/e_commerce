package com.example.e.commerce.dao;

import com.example.e.commerce.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
    Seller findByEmailId(String email);

    Seller findByMobNo(String mobNo);
}
