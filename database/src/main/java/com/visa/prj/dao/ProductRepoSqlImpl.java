package com.visa.prj.dao;

import com.visa.prj.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepoSqlImpl implements ProductRepo {
//    private static String URL = "jdbc:mysql://localhost:3306/VISA_JAVA";
//    private  static String USER = "root";
//    private static  String PWD = "Welcome123";
//    private static  String DRIVER = "com.mysql.cj.jdbc.Driver";
private static String URL = "jdbc:h2:~/testing";
    private  static String USER = "sa";
    private static  String PWD = "";
    private static  String DRIVER = "org.h2.Driver";

    static  {
        // read from config files

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void addProduct(Product product) throws PeristenceException {
        String SQL = "INSERT INTO products (id, name,price, qty) VALUES (2, ?, ?, ?)";
//        Connection con = null;
        try(Connection con = DriverManager.getConnection(URL, USER, PWD)) {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQty());

            ps.executeUpdate(); // int
        } catch (SQLException e) {
            // don't forget to wrap original exception
//            if(e.getErrorCode())
            //https://github.com/spring-projects/spring-framework/blob/main/spring-jdbc/src/main/resources/org/springframework/jdbc/support/sql-error-codes.xml
           throw  new PeristenceException("unable to add Product ", e);
        }


    }

    @Override
    public List<Product> getProducts() throws FetchException {
        List<Product> products = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(URL, USER, PWD)) {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, name, price, qty FROM products");
            while (rs.next()) {
                products.add(
                        Product.builder().
                                id(rs.getInt("id")).
                                name(rs.getString("name")).
                                price(rs.getDouble("price"))
                                .qty(rs.getInt("qty")).build()
                );
            }
        } catch (SQLException e) {
            // don't forget to wrap original exception
            throw  new FetchException("unable to get Products ", e);
        }
        return products;
    }
}
