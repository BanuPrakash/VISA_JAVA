package com.visa.ecomapp.client;

import com.visa.ecomapp.entity.Customer;
import com.visa.ecomapp.entity.LineItem;
import com.visa.ecomapp.entity.Order;
import com.visa.ecomapp.entity.Product;
import com.visa.ecomapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderClient  implements CommandLineRunner {
    private final OrderService service;

    // gets called as soon as the Spring Container is created and initialized
    @Override
    public void run(String... args) throws Exception {
        newOrder();
    }

    private void newOrder() {
        Customer customer = Customer.builder().email("reena@visa.com").build();
        LineItem item1 = LineItem.builder().product(Product.builder().id(3).build())
                        .qty(2).
                build();

        LineItem item2 = LineItem.builder().product(Product.builder().id(4).build())
                .qty(1).
                build();

        Order order = new Order();
        order.getItems().add(item1);
        order.getItems().add(item2);
        order.setCustomer(customer);

        service.placeOrder(order);
    }
}
