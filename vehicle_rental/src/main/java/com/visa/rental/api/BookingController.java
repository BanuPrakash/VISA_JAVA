package com.visa.rental.api;

import com.visa.rental.entity.Booking;
import com.visa.rental.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("api/booking")
@RequiredArgsConstructor
public class BookingController {
    private final RentalService service;

    @PostMapping
    public Booking rentVehicle(@RequestBody Booking booking) {
        return  service.doBooking(booking);
    }

    @GetMapping
    public String someTask(@RequestParam("date")
                               @DateTimeFormat(pattern = "dd-MM-yyyy")
                               final LocalDate date){
        System.out.println(date);
        return "Hello World";
    }
}
