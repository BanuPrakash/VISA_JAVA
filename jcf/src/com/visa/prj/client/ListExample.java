package com.visa.prj.client;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        List<Integer> intRep = new ArrayList<>();
        ints.add(52);
        ints.add(12);

        List<String> names = new LinkedList<>();
        List<String> namesRep = new LinkedList<>();
        names.add("A");
        names.add("B");

       printData(ints);
       printData(names);

       copyElements(intRep, ints);
       copyElements(namesRep, names);
    }

    // PECS -> Producer extends Consumer Super
    private static <T> void copyElements(List<? super T> dest, List<? extends  T> src) {
        for(T x : src) {
            dest.add(x);
        }
    }

    private static void printData(List<?> elems) {
//        elems.add("A");
        for(Object x : elems) {
            System.out.println(x);
        }
    }

}
