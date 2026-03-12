package com.visa.ecomapp.client;

import com.visa.ecomapp.dto.ReportDTO;
import com.visa.ecomapp.entity.Customer;
import com.visa.ecomapp.entity.LineItem;
import com.visa.ecomapp.entity.Order;
import com.visa.ecomapp.entity.Product;
import com.visa.ecomapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderClient  implements CommandLineRunner {
    private final OrderService service;

    // gets called as soon as the Spring Container is created and initialized
    @Override
    public void run(String... args) throws Exception {
//        newOrder();
        printOrders();
    }

    private void printOrders() {
//        List<Order> orders = service.getOrders();
        List<Order> orders = service.orderWithItems();
        for(Order order : orders) {
            System.out.println(order.getCustomer().getFirstName() + ", " + order.getOrderDate() +", " + order.getTotal());
            List<LineItem> items = order.getItems();
            for(LineItem item : items) {
                System.out.println(item.getProduct().getName() + ", " + item.getQty() +", " + item.getAmount());
            }
        }

        System.out.println("*****");
        List<ReportDTO> reportDTOS = service.getReport();
        for(ReportDTO reportDTO : reportDTOS) {
            System.out.println(reportDTO);
        }
    }

    private void newOrder() {
        Customer customer = Customer.builder().email("jane@visa.com").build();
        LineItem item1 = LineItem.builder().product(Product.builder().id(1).build())
                        .qty(1).
                build();

        LineItem item2 = LineItem.builder().product(Product.builder().id(4).build())
                .qty(2).
                build();

        Order order = new Order();
        order.getItems().add(item1);
        order.getItems().add(item2);
        order.setCustomer(customer);

        service.placeOrder(order);
    }
}
