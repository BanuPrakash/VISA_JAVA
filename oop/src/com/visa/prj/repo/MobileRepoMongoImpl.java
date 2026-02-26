package com.visa.prj.repo;

import com.visa.prj.entity.Mobile;

public class MobileRepoMongoImpl implements MobileRepo {
    @Override
    public void addMobile(Mobile m) {
        // db.mobiles.insert(...)
        System.out.println(m.getName() + " stored in MongoDB!!");
    }

    @Override
    public Mobile getMobile(int id) {
        return null;
    }
}
