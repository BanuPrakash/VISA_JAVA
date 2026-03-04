package com.visa.prj.client;

import com.visa.prj.dao.FetchException;
import com.visa.prj.dao.ProductRepo;
import com.visa.prj.dao.ProductRepoSqlImpl;
import com.visa.prj.entity.Product;

import java.util.List;

public class ProductListClient {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepoSqlImpl();

        try {
            List<Product> products = productRepo.getProducts();
            for(Product p : products) {
                System.out.println(p);
            }
        } catch (FetchException e) {
            e.printStackTrace();
        }

    }
}
