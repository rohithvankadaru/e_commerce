package com.example.e.commerce.dao;

import com.example.e.commerce.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    @Query(value = "select * from card where card_type = :cardType", nativeQuery = true)
    List<Card> getViaCardType(String cardType);

    @Query(value = "select card_type from card group by card_type order by count(*) desc limit 1",nativeQuery = true)
    String getCardTypeOfHighestUsers();

    @Query(value = "select card_type from card group by card_type order by count(*) limit 1", nativeQuery = true)
    String LowestUsedCardType();

    @Query(value = "select distinct customer_id from card where card_type = :cardType", nativeQuery = true)
    List<Integer> customerIdOfSpecificCard(String cardType);
}
