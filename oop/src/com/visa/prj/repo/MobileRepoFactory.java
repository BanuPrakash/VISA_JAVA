package com.visa.prj.repo;

import java.util.ResourceBundle;

public class MobileRepoFactory {
    private  static String DAO_CLASS = "";

    static  {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
        DAO_CLASS = resourceBundle.getString("MOBILE_DAO").trim();

        // DAO_CLASS = "com.visa.prj.repo.MobileRepoMongoImpl"
    }
//    public  static  MobileRepo getMobileRepo() {
//        return new MobileRepoSqlImpl();
//    }
    public  static  MobileRepo getMobileRepo() {
        try {
           return (MobileRepo) Class.forName(DAO_CLASS).getConstructor().newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return  null;
    }
}
