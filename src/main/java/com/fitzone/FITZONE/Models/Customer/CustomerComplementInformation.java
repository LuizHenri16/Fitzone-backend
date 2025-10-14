package com.fitzone.FITZONE.Models.Customer;

import jakarta.persistence.*;

@Entity
public class CustomerComplementInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Double weight;
    private Double height;
    private String healthHistory;

    @OneToOne()
    @JoinColumn(name = "customerId")
    private Customer customer;

    public CustomerComplementInformation() {
    }

    public CustomerComplementInformation(Double weight, Double height, String healthHistory) {
        if(weight == null || weight < 1) {
            throw new IllegalArgumentException("Peso inválido!");
        }
        this.weight = weight;

        if(height == null || height < 1) {
            throw new IllegalArgumentException("Altura inválida!");
        }
        this.height = height;

        if(healthHistory == null || healthHistory.trim().isEmpty()) {
            throw new IllegalArgumentException("Peso inválido!");
        }
        this.healthHistory = healthHistory;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWeight() {
        return weight;
    }

    public String getHealthHistory() {
        return healthHistory;
    }
}
