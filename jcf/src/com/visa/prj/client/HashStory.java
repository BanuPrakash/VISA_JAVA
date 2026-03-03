package com.visa.prj.client;

public class HashStory {
    public static void main(String[] args) {
        String a = "Hello"; // String pool
        String b = "Hello";
        String c = "Hello";

        String str1 = new String("Hello");
        String str2 = new String("Hello");

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

        String str3 = new String("Aa");
        String str4 = new String("BB");

        System.out.println(str3.hashCode());
        System.out.println(str4.hashCode());
    }
}
