import java.util.concurrent.atomic.AtomicInteger;

public class NumberThread extends  Thread {
    int start;
    int end;

    public NumberThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for(int i = start; i <= end; i++) {
            System.out.println(Thread.currentThread() +" : " + i);
        }
    }
}
