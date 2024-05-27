package com.carrefour.kata.repositories;

import com.carrefour.kata.data.CustomerDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDeliveryRepository extends JpaRepository<CustomerDelivery, Long> {
}
