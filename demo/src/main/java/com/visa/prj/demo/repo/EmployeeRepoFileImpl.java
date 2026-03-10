package com.visa.prj.demo.repo;


import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;


@ConditionalOnMissingBean(name="employeeRepoMySqlImpl")
@Repository
public class EmployeeRepoFileImpl implements  EmployeeRepo{
    @Override
    public void addEmployee() {
        System.out.println("Stored in File System!!!");
    }
}
