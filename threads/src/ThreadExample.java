public class ThreadExample {
    public static void main(String[] args) {
        NumberThread t1 = new NumberThread(1,50);
        t1.setPriority(10);
        NumberThread t2 = new NumberThread(500, 800);
        t2.setDaemon(true); // Daemon thread, JVM won't check its state before terminate
        CharThread ch = new CharThread();
        // only main thread is running
        t1.start(); // main and t1 are ready
        t2.start(); // main, t1 and t2 are ready
//        ch.run(); // run will execute on Main Thread
//        Thread t = new Thread();
//        t.start();
        Thread t3 = new Thread(ch);
        t3.start(); // main t1, t2 and t3 are ready

        System.out.println("Main Dies!!!");
    }
}
