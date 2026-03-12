package com.visa.ecomapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportDTO {
    String firstName;
    String lastName;
    Date orderDate;
    double total;
}
