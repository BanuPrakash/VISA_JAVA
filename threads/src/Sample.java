public class Sample {
    public static void main(String[] args) {
        doTask();
    }

    private static void doTask() {
        Thread t = Thread.currentThread();
        System.out.println(t);
        // Priority 5
        // main thread
        // main group
    }
}
