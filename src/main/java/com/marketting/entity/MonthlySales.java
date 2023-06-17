package com.marketting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "monthly_sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlySales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String product;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private double[] sales;


}
