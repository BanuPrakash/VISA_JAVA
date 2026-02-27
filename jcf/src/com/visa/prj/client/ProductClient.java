package com.visa.prj.client;

import com.visa.prj.entity.Product;

import java.util.Arrays;
import java.util.Comparator;

public class ProductClient {
    public static void main(String[] args) {
        Product[] products = new Product[6];
        products[0] = new Product(42, "LG AC", 45000.00, "ELEC");
        products[1] = new Product(89, "Sony Bravia", 245000.00, "TV");
        products[2] = new Product(7, "Samsung Fold", 175000.00, "MOBILE");
        products[3] = new Product(2, "IPhone", 95000.00, "MOBILE");
        products[4] = new Product(42, "LG JOY", 98000.00, "TV");
        products[5] = new Product(42, "TATA PLAY", 5100.00, "ELEC");

        Arrays.sort(products); // Comparable

        for(Product p : products) {
            System.out.println(p); //toString
        }

        Arrays.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });

        System.out.println("By Price");
        for(Product p : products) {
            System.out.println(p); //toString
        }

        System.out.println("By Name:");
        // lambda expression
//        Arrays.sort(products, (Product o1, Product o2) -> {
//            return Double.compare(o1.getPrice(), o2.getPrice());
//        });
        // Type infer
//        Arrays.sort(products, ( o1,  o2) -> {
//            return Double.compare(o1.getPrice(), o2.getPrice());
//        });

        Arrays.sort(products, ( o1,  o2) -> Double.compare(o1.getPrice(), o2.getPrice()));


    }
}
