package com.fitzone.FITZONE.Models.Finance;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String license;
    private BigDecimal price;

    @OneToMany(mappedBy = "license", cascade = CascadeType.ALL)
    private List<Payment> payments;
}
