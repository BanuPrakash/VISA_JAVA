package com.visa.ecomapp.client;

import com.visa.ecomapp.entity.Customer;
import com.visa.ecomapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
//@Order(1)
public class CustomerClient implements CommandLineRunner {
    private final OrderService service;

    // gets called as soon as the Spring Container is created and initialized
    @Override
    public void run(String... args) throws Exception {
        createCustomers();
    }

    private void createCustomers() {
        if(service.getCustomerCount() == 0) {
            service.addCustomer(Customer.builder().email("jane@visa.com").firstName("Jane").lastName("Mathew").build());
            service.addCustomer(Customer.builder().email("reena@visa.com").firstName("Reena").lastName("Roy").build());
            service.addCustomer(Customer.builder().email("rekha@visa.com").firstName("Rekha").lastName("Rao").build());

        }
    }
}
