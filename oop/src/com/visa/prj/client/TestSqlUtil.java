package com.visa.prj.client;

import com.visa.prj.entity.Book;
import com.visa.prj.entity.Product;
import com.visa.prj.util.SqlUtil;

public class TestSqlUtil {
    public static void main(String[] args) {
        String SQL = SqlUtil.createSQL(Book.class);
        System.out.println(SQL);

        SQL = SqlUtil.createSQL(Product.class);
        System.out.println(SQL);

        Book book = new Book();
        book.setId(25);
        book.setTitle("Java Ref");
        book.setPrice(450.00);

        SQL = SqlUtil.insertSQL(book);
        // insert into books values(25, 'Java Ref', 450.00);
        
    }
}
