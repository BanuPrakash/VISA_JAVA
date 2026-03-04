package com.visa.prj.dao;

import com.visa.prj.entity.Product;

import java.util.List;

public interface ProductRepo {
    void addProduct(Product product) throws PeristenceException;
    List<Product> getProducts() throws  FetchException;
}
