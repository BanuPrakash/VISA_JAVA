package com.visa.prj.demo.repo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;



@Repository
public class EmployeeRepoMySqlImpl implements  EmployeeRepo {
    @Override
    public void addEmployee() {
        System.out.println("Stored in MySQL!!!");
    }
}
