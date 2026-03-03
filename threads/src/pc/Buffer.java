package pc;

// ArrayBlockingQueue or LinkedListBlockingQueue
public class Buffer {
    private int value;
    private volatile boolean flag = false;

    // Producer
    public synchronized void setData(int data) {
        while(flag == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        value = data;
        flag = true;
        notify();
    }

    public synchronized int getData() {
        while(flag == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        flag = false;
        notify();
        return  value;
    }
}
