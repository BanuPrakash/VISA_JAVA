package com.visa.ecomapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;

    @Column(name="order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate = new Date();

    @ManyToOne
    @JoinColumn(name = "customer_fk")
    private Customer customer; // order is by customer

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_fk")
    private List<LineItem> items = new ArrayList<>(); // order has many items

    private double total;
}
