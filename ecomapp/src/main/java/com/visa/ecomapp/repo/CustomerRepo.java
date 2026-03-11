package com.visa.ecomapp.repo;

import com.visa.ecomapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, String> {
    List<Customer> findByLastName(String name);
}
