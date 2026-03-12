package com.visa.rental.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtil {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public LocalDateTime getDate(String str) {
        return LocalDateTime.parse(str, formatter);
    }

    public String toString(LocalDateTime dateTime) {
        return dateTime.format(formatter);
    }
}
