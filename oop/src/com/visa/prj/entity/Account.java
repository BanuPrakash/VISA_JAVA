package com.visa.prj.entity;

public class Account {
    private double balance; // state, instance variable
    private static int count; // class member

    // default, no parameter constructor
    public  Account() {
        count++;
        this.balance = 0;
    }

    // parameterized constructor
    public Account(double amt) {
        count++;
        this.balance = amt;
    }


    public void deposit(double amt) {
        this.balance += amt;
    }

    public void withdraw(double amt) {
        this.balance -= amt;
    }

    public double getBalance() {
        return  this.balance;
    }


    // Class member
    public static int getCount() {
        return  count;
    }
}
