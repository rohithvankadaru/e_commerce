package com.example.e.commerce.entity;

import com.example.e.commerce.enums.ProductCategory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    int price;

    int quantity;

    @Enumerated(EnumType.STRING)
    ProductCategory productCategory;

    @ManyToOne
    @JoinColumn
    Seller seller;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    Item item;
}
