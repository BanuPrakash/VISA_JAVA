package com.visa.prj.client;

import com.visa.prj.entity.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductSet {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>(16, 0.7f);
        products.add( new Product(42, "LG AC", 45000.00, "ELEC"));
        products.add( new Product(89, "Sony Bravia", 245000.00, "TV"));
        products.add(new Product(7, "Samsung Fold", 175000.00, "MOBILE"));
        products.add(new Product(2, "IPhone", 95000.00, "MOBILE"));
        products.add(new Product(42, "LG JOY", 98000.00, "TV"));
        products.add(new Product(42, "TATA PLAY", 5100.00, "ELEC"));
        products.add( new Product(89, "Sony Bravia", 245000.00, "TV"));
        products.add(new Product(2, "IPhone", 95000.00, "MOBILE"));

        for(Product p : products) {
            System.out.println(p);
        }

    }
}
