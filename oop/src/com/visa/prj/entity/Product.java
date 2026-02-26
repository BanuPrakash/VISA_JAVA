package com.visa.prj.entity;

import com.visa.prj.annotations.Column;
import com.visa.prj.annotations.Table;

// extends Object
@Table(name="products")
public abstract class Product implements  Comparable{
    private int id;
    private String name;
    private double price;

    public Product() {
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Column(name="PID", type = "INTEGER")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="PRD_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public boolean isExpensive() {
//        return false;
//    }

    public abstract  boolean isExpensive(); // pure virtual function

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Product other = (Product) o;
//        return  (int)(this.price - other.price);
        return Double.compare(this.price, other.price);
    }
}
