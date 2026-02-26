package com.visa.prj.entity;

import com.visa.prj.annotations.Column;
import com.visa.prj.annotations.Table;

@Table(name="books")
public class Book {
    int id;
    String title;
    double price;

    @Column(name="BID", type="NUMERIC(10)")
    public int getId() {
        return id;
    }

    @Column(name="BOOK_TITLE")
    public String getTitle() {
        return title;
    }
    @Column(name="AMT", type = "NUMERIC(12,2)")
    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
