package com.visa.prj.entity;

public class Test {
    public static void main(String[] args) {
        Product p = new Product(42, "A", 634, 11);

        Product p1 = Product.builder().name("A").price(56674).build();
    }
}
