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

    public void deposit(String name, double amt) {
        System.out.println(name + " trying to deposit : " + amt);
        double bal = getBalance();
        System.out.println(name + " got balance : " + bal);
        bal += amt;
        System.out.println(name + " setting balance : " + bal);
        setBalance(bal);
    }

    public void withdraw(String name, double amt) {
        System.out.println(name + " trying to withdraw : " + amt);
        double bal = getBalance();
        System.out.println(name + " got balance : " + bal);
        bal -= amt;
        System.out.println(name + " setting balance : " + bal);
        setBalance(bal);
    }
}
