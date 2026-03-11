package com.visa.ecomapp.repo;

import com.visa.ecomapp.dto.ProductDTO;
import com.visa.ecomapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findByPriceBetween(double low, double high);

//    @Query(value="select * from products where price >= :l and price <= :h", nativeQuery = true)
    @Query("from Product where price >= :l and price <= :h")
    List<Product> findByRange(@Param("l") double low, @Param("h") double high);

//    @Query("select name, price from Product ")
    //@Query(value = "select name, price from products", nativeQuery = true)
//    List<Object[]> getData();

    @Query("select new com.visa.ecomapp.dto.ProductDTO(name, price) from Product ")
    List<ProductDTO> getProductData();

    @Modifying
    @Query("update Product set price = :pr where id =:id")
    void updateProduct(@Param("id") int id, @Param("pr") double price);
}
