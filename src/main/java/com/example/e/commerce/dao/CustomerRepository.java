package com.example.e.commerce.dao;

import com.example.e.commerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findByMobileNo(String mobileNo);

    Customer findByEmailId(String emailId);
}
