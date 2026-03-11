package com.visa.ecomapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="customers")
public class Customer {
    @Id
    private String email;

    @Column(name="FNAME", length = 100, nullable = false)
    private String firstName;

    @Column(name="LNAME", length = 100, nullable = false)
    private String lastName;
}
