package com.visa.rental.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;


// will generate constructor, getters, hashCode, equals
// Note there are no setters
// immutable object
public record RentalVehicleDTO(
        String registrationNumber,
        String fuelType,
        double dailyHireRate,
        LocalDateTime dateFrom,
        LocalDateTime dateTo,
        String firstName,
        String lastName) {
}
