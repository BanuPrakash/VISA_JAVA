package com.visa.prj.client;

import com.visa.prj.entity.Product;

import java.util.*;
import java.util.stream.Collectors;

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

//        for(Product p: products) {
//            System.out.println(p);
//        }

//        products.stream()
//                .filter(p -> p.getCategory().equals("MOBILE"))
//                .forEach(p -> System.out.println(p));

        products.parallelStream()
                .filter(p -> p.getCategory().equals("MOBILE"))
                .forEach(p -> System.out.println(p));

        double total = products.stream()
                .filter(p -> p.getCategory().equals("MOBILE"))
                .map(p -> p.getPrice())
                .reduce(0.0, (v1, v2) -> v1 + v2);

        System.out.println(total);

       List<Product> mobiles = products.parallelStream()
                .filter(p -> p.getCategory().equals("MOBILE"))
                .collect(Collectors.toList());

        Map<String, List<Product>> productCat = products.stream()
                .collect(Collectors.groupingBy( p -> p.getCategory()));

        productCat.forEach( (key, values) -> {
            System.out.println("Category " + key);
            values.forEach(p -> System.out.println(p));
        });

        List<Product> tvs = productCat.get("TV");

        DoubleSummaryStatistics stats =
                products.stream().collect(Collectors.summarizingDouble(p -> p.getPrice()));

        System.out.println("Max : " + stats.getMax());
        System.out.println("Min :" + stats.getMin());
        System.out.println("Avg : " + stats.getAverage());

    }
}
