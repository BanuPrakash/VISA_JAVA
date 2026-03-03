package java5;

import java.util.concurrent.Callable;

public class FibonacciGenerator implements Callable<Integer> {
    int number;

    public FibonacciGenerator(int number) {
        this.number = number;
    }

    private int fibonacci(int no) {
        if(no == 0 || no == 1) {
            return  no;
        } else {
            return  fibonacci(no - 1) + fibonacci(no -2);
        }
    }
    @Override
    public Integer call() throws Exception {
        return fibonacci(number);
    }
}
