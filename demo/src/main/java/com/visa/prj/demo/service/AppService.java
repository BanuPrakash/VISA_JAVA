package com.visa.prj.demo.service;

import com.visa.prj.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("app")
public class AppService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public  void insert() {
        employeeRepo.addEmployee();
    }
}
