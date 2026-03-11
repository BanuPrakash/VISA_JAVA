package com.visa.ecomapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="items")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemid;

    @ManyToOne
    @JoinColumn(name="product_fk")
    private Product product; // references a product

    private int qty;

    private double amount;
}
