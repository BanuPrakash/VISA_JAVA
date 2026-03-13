package com.visa.ecomapp.api;

import com.visa.ecomapp.dto.ReportDTO;
import com.visa.ecomapp.entity.Order;
import com.visa.ecomapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    // POST http://localhost:8080/api/orders
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody Order order) {
        service.placeOrder(order);
        return "Order placed!!!";
    }

    // GET http://localhost:8080/api/orders
    @GetMapping()
    public List<Order> getOrders() {
        return  service.getOrders();
    }

    // GET http://localhost:8080/api/orders/report
    @GetMapping("/report")
    public List<ReportDTO> getReport() {
        return service.getReport();
    }
}
