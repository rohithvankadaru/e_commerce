package com.example.e.commerce.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cart")
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int cartValue;

    int numberOfItems;

    @OneToOne
    @JoinColumn
    Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();

}
