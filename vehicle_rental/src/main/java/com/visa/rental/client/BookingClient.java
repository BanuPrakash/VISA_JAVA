package com.visa.rental.client;


import com.visa.rental.entity.Booking;
import com.visa.rental.entity.Customer;
import com.visa.rental.entity.Vehicle;
import com.visa.rental.service.RentalService;
import com.visa.rental.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingClient implements CommandLineRunner {
    private  final RentalService service;
    private final DateUtil dateUtil;

    @Override
    public void run(String... args) throws Exception {
           bookVehicle();
//        returnVehicle();
    }

    private void returnVehicle() {
        System.out.println(service.returnBookedVehicle(1, dateUtil.getDate("11-03-2026 9:10:15")));
    }

    private void bookVehicle() {
//        Booking booking = Booking.builder().
//                customer(Customer.builder().email("anne@cisco.com").build())
//                        .vehicle(Vehicle.builder().registrationNumber("KA-05-AB-1234").build())
//                        .dateFrom(dateUtil.fromString("19-08-2025")).
//                build();
        Booking booking = Booking.builder().
                customer(Customer.builder().email("roger@visa.com").build())
                .vehicle(Vehicle.builder().registrationNumber("DH-10-AA-0434").build())
                .dateFrom(dateUtil.getDate("10-03-2026 4:50:11")).
                build();
        System.out.println(service.doBooking(booking));
    }
}
