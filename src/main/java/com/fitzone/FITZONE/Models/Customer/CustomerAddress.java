package com.fitzone.FITZONE.Models.Customer;

import jakarta.persistence.*;

@Entity
public class CustomerAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String address;

    @OneToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public CustomerAddress() {
    }

    public CustomerAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço vazio ou nulo!");
        }
        this.address = address;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void updateAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
