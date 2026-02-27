public class SecondExample {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Boom :-( Problem in "  + t.getName() + " : " + e.getMessage());
            }
        });

        System.out.println("Start!!!");
        doTask();
        System.out.println("End");
    }

    private static void doTask() {
        int [] elems = {4,6,1,145};
        System.out.println("Result " + elems[10]);
    }
}
