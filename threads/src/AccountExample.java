public class AccountExample {
    public static void main(String[] args) {
        Account account = new Account(5000);
        TransactionThread t1 = new TransactionThread(account, "Danny", 2500, TransactionType.CREDIT);
        TransactionThread t2 = new TransactionThread(account, "\tSwetha", 2000, TransactionType.CREDIT);
        TransactionThread t3 = new TransactionThread(account, "\t\tHaritha", 3000, TransactionType.DEBIT);

        t1.start();
        t2.start();
        t3.start();
        // Barrier
        // main thread waits for t1, t2 and t3 to finish execution
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Balance : " + account.getBalance());
    }
}
