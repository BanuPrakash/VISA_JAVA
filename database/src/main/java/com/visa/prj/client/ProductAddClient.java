package com.visa.prj.client;

import com.visa.prj.dao.PeristenceException;
import com.visa.prj.dao.ProductRepo;
import com.visa.prj.dao.ProductRepoSqlImpl;
import com.visa.prj.entity.Product;

public class ProductAddClient {
    public static void main(String[] args) {
//        Product p = Product.builder().
//                name("Reynolds").
//                price(50)
//                .qty(100).build();

        Product p = new Product(0, "Reynolds", 50, 100);

        ProductRepo productRepo = new ProductRepoSqlImpl();

        try {
            productRepo.addProduct(p);
            System.out.println("Product added!!!");
        } catch (PeristenceException e) {
           e.printStackTrace();

//            System.out.println(e.getMessage());
        }

    }
}
