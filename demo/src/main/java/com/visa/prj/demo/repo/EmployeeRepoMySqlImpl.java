package com.visa.prj.demo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@Repository
@Scope("prototype")
public class EmployeeRepoMySqlImpl implements  EmployeeRepo {
    @Autowired
    DataSource dataSource; // pool of connection

    @Override
    public void addEmployee() {
        try {
            Connection con = dataSource.getConnection(); // pick connection from pool
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from products");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Stored in MySQL!!!");
    }
}
