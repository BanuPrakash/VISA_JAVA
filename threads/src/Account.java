public class Account {
    private double balance;

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
    public synchronized void deposit(String name, double amt) {
        System.out.println(name + " trying to deposit : " + amt);
        double bal = getBalance();
        System.out.println(name + " got balance : " + bal);
        bal += amt;
        System.out.println(name + " setting balance : " + bal);
        setBalance(bal);
        notifyAll();
    }

    // critical sections
    public synchronized void withdraw(String name, double amt) {
        int count = 0;
        System.out.println(name + " trying to withdraw : " + amt);
        while(getBalance() < amt) {
            System.out.println("Insufficient balance, going to wait list...");
            count++;
            if( count >= 3) {
                return;
            }
            try {
                wait(25000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        double bal = getBalance();
        System.out.println(name + " got balance : " + bal);
        bal -= amt;
        System.out.println(name + " setting balance : " + bal);
        setBalance(bal);
    }
}
