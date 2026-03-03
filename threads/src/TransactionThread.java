public class TransactionThread extends  Thread {
    private  Account account;
    private  String name;
    private double amt;
    private  TransactionType type;

    public TransactionThread(Account account, String name, double amt, TransactionType type) {
        this.account = account;
        this.name = name;
        this.amt = amt;
        this.type = type;
    }

    @Override
    public void run() {
        if(type == TransactionType.CREDIT) {
            account.deposit(name, amt);
        } else {
            account.withdraw(name, amt);
        }
    }
}
