package java5;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) throws  Exception{
        // Thread pool
        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<Integer> f1 = service.submit(new FibonacciGenerator(34));
        Future<Integer> f2 = service.submit(new FibonacciGenerator(40));

            System.out.println(f1.get()); // blocking

            System.out.println(f2.get()); // blocking
        service.shutdown();
    }
}
