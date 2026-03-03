package java5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private double balance;
    private Lock balanceLock = new ReentrantLock();
    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        try {
            Thread.sleep((long)(Math.random() * 2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return balance;
    }

    private void setBalance(double balance) {
        try {
            Thread.sleep((long)(Math.random() * 2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.balance = balance;
    }

    // critical sections
    public  void deposit(String name, double amt) {
        try {
            balanceLock.lock();
            System.out.println(name + " trying to deposit : " + amt);
            double bal = getBalance();
            System.out.println(name + " got balance : " + bal);
            bal += amt;
            System.out.println(name + " setting balance : " + bal);
            setBalance(bal);
        } finally {
            balanceLock.unlock();
        }
    }


    // critical sections
    public  void withdraw(String name, double amt) {
        try {
            balanceLock.lock();
        int count = 0;
        System.out.println(name + " trying to withdraw : " + amt);

        double bal = getBalance();
        System.out.println(name + " got balance : " + bal);
        bal -= amt;
        System.out.println(name + " setting balance : " + bal);
        setBalance(bal);
        } finally {
            balanceLock.unlock();
        }
    }
}
