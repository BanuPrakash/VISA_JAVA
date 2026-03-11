package com.visa.ecomapp.repo;

import com.visa.ecomapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, String> {
}
