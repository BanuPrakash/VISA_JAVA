package com.visa.prj.client;

import com.visa.prj.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductList {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add( new Product(42, "LG AC", 45000.00, "ELEC"));
        products.add( new Product(89, "Sony Bravia", 245000.00, "TV"));
        products.add(new Product(7, "Samsung Fold", 175000.00, "MOBILE"));
        products.add(new Product(2, "IPhone", 95000.00, "MOBILE"));
        products.add(new Product(42, "LG JOY", 98000.00, "TV"));
        products.add(new Product(42, "TATA PLAY", 5100.00, "ELEC"));

        Collections.sort(products); // Comparable

        Collections.sort(products,( o1,  o2) -> Double.compare(o1.getPrice(), o2.getPrice()) );

        for(Product p: products) {
            System.out.println(p);
        }


    }
}
