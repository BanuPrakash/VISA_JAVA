package com.visa.ecomapp.client;

import com.visa.ecomapp.dto.ProductDTO;
import com.visa.ecomapp.entity.Product;
import com.visa.ecomapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
//@Order(244)
public class ProductClient implements CommandLineRunner {
    private final OrderService service;

    // gets called as soon as the Spring Container is created and initialized
    @Override
    public void run(String... args) throws Exception {
//        printProducts();
//        printScalar();
//        changePrice();
    }

    private void changePrice() {
       Product p = service.modifyProduct(3, 4790);
        System.out.println(p);
    }

    private void printScalar() {
        List<ProductDTO> productDTOS = service.getScalar();
        for(ProductDTO dto: productDTOS) {
            System.out.println(dto);
        }
    }


    private void printProducts() {
        List<Product> products = service.getProducts();
        for(Product p : products) {
            System.out.println(p);
        }
    }
}
