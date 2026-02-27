package com.visa.prj.client;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Sample {
    public static <T> List<T> filter(
            List<? extends T> list,
            Predicate<T> condition
    ) {
        List<T> result = new ArrayList<>();

        for (T element : list) {
            if (condition.test(element)) {
                result.add(element);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> evens = filter(numbers, n -> n % 2 == 0);

        System.out.println(evens); // [2, 4, 6]
    }
}
