package com.visa.rental.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name="bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // AUTO_INCREMENT

    @ManyToOne
    @JoinColumn(name = "customer_fk")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "vehicle_fk")
    private Vehicle vehicle;

    @Column(name="date_from")
    @FutureOrPresent(message = "Date ${validatedValue} has to preset or future date")
    private LocalDateTime dateFrom;


    @Column(name="date_to")
    private LocalDateTime dateTo;

    private double amount;
}
