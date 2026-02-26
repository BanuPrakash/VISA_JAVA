package com.visa.prj.client;

import com.visa.prj.entity.Mobile;
import com.visa.prj.repo.MobileRepo;
import com.visa.prj.repo.MobileRepoFactory;

public class MobileClient {
    public static void main(String[] args) {
        Mobile mobile = new Mobile(52, "iPhone 17", 98000.00, "5G");
//        MobileRepo mobileRepo = new MobileRepoMongoImpl();
//        MobileRepo mobileRepo = new MongoRepoSqlImpl();

        MobileRepo mobileRepo = MobileRepoFactory.getMobileRepo();
        mobileRepo.addMobile(mobile);
    }
}
