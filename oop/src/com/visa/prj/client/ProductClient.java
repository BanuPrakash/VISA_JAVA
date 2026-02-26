package com.visa.prj.client;

import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Product;
import com.visa.prj.entity.Tv;

import java.lang.reflect.Method;

public class ProductClient {
    public static void main(String[] args) {
        Product[] products = new Product[5]; // Array of Pointers / references

        // upcasting
        products[0] = new Mobile(42, "Samsung Fold", 145000.00, "5G");

        // upcasting
        products[1] = new Tv(71, "Onida Thunder", 4500.00, "CRT");

        products[2] = new Mobile(61, "MotoG", 12000, "5G");

        products[3] = new Tv(90, "Sony Bravia", 2_10_000.00, "OLED");

        products[4] = new Mobile(31, "Redmi", 3500.00, "4G");

        printExpensive(products);

       // printDetails(products);

        printOcpDetails(products);
    }

    private static void printOcpDetails(Product[] products) {
        for(Product product : products) {
            Method[] methods = product.getClass().getMethods();
            for(Method method : methods) {
                if(method.getName().startsWith("get")) {
                    try {
                        Object ret = method.invoke(product);
                        System.out.println(method.getName().substring(3).toUpperCase() + ": " + ret
                        );
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    // Not OCP
    private static void printDetails(Product[] products) {
//        for(int i = 0; i < products.length; i++) {
//            System.out.println(products[i]);
//        }

        for(int i = 0; i < products.length; i++) {
            System.out.println(products[i].getName() +", " + products[i].getPrice());
            if(products[i] instanceof  Mobile) {
                Mobile m = (Mobile) products[i];
                System.out.println(m.getConnectivity());
            }
            // exact checking
            if(products[i].getClass() == Tv.class) {
                Tv tv = (Tv) products[i];
                System.out.println(tv.getScreenType());
            }
        }
    }

    // OCP
    private static void printExpensive(Product[] products) {
        for(Product product : products) {
            if(product.isExpensive()) { // dynamic binding, polymorphism
                System.out.println(product.getName() + " is expensive");
            } else {
                System.out.println(product.getName() + " is not expensive");
            }
        }
    }
}
