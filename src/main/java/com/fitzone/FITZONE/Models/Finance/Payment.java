package com.fitzone.FITZONE.Models.Finance;

import com.fitzone.FITZONE.Models.Customer.Customer;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @ManyToOne
    @JoinColumn(name = "licenseId")
    private License license;

    private LocalDate lastPayment;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    public Payment() {
    }

    public Payment(License license, LocalDate lastPayment, Customer customer) {
        this.license = license;
        this.lastPayment = lastPayment;
        this.customer = customer;
    }

    public LocalDate getLastPayment() {
        return lastPayment;
    }
}
