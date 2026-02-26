package com.visa.prj.repo;

import com.visa.prj.entity.Mobile;

// Realization
public class MobileRepoSqlImpl implements  MobileRepo{
    @Override
    public void addMobile(Mobile m) {
        // insert into
        System.out.println(m.getName() + " stored in MySQL!!!");
    }

    @Override
    public Mobile getMobile(int id) {
        return null;
    }
}
