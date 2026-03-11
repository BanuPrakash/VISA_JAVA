package com.visa.ecomapp.repo;

import com.visa.ecomapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
