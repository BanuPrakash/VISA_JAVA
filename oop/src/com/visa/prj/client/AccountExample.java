package com.visa.prj.client;

import com.visa.prj.entity.Account;

public class AccountExample {
    public static void main(String[] args) {
        System.out.println(Account.getCount()); // 0
        Account rahulAcc = new Account(2000);
        Account swethaAcc = new Account();
        rahulAcc.deposit(45000);
        swethaAcc.deposit(8900);

        System.out.println("Rahul's Data:");
        System.out.println("Balance : " + rahulAcc.getBalance());

        System.out.println("Swetha's Data:");
        System.out.println("Balance : " + swethaAcc.getBalance());


        System.out.println("Count: " + Account.getCount()); // 2
    }
}
