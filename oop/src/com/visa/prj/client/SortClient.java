package com.visa.prj.client;

import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Product;
import com.visa.prj.entity.Tv;
import com.visa.prj.util.Utility;

public class SortClient {
    public static void main(String[] args) {
        String[] names = {"George", "Scarlett", "Meryl", "Angelina", "Jennifer"};
        Utility.sort(names);

        for(String name : names) {
            System.out.println(name);
        }

        Product[] products = new Product[5]; // Array of Pointers / references
        // upcasting
        products[0] = new Mobile(42, "Samsung Fold", 145000.00, "5G");
        // upcasting
        products[1] = new Tv(71, "Onida Thunder", 4500.00, "CRT");
        products[2] = new Mobile(61, "MotoG", 12000, "5G");
        products[3] = new Tv(90, "Sony Bravia", 2_10_000.00, "OLED");
        products[4] = new Mobile(31, "Redmi", 3500.00, "4G");

        Utility.sort(products);

        for(Product p : products) {
            System.out.println(p); // toString
        }
    }
}
