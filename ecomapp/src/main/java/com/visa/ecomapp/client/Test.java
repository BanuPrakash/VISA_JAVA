package com.visa.ecomapp.client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        String date = "11-03-2026 10:25:00";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        System.out.println(dateTime);
    }
}
