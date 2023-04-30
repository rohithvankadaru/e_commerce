package com.example.e.commerce.dao;

import com.example.e.commerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product p where p.product_category = :productCategory", nativeQuery = true)
    List<Product> productsViaCategory(String productCategory);
}
