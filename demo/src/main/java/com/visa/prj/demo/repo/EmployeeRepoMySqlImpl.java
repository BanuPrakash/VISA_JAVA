package com.visa.prj.demo.repo;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepoMySqlImpl implements  EmployeeRepo {
    @Override
    public void addEmployee() {
        System.out.println("Stored in MySQL!!!");
    }
}
