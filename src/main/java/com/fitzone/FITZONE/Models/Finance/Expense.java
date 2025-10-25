package com.fitzone.FITZONE.Models.Finance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String description;
    private Double value;
    private LocalDate expenseDate;

    public Expense() {
    }

    public Expense(String description, Double value, LocalDate expenseDate) {
        this.description = description;
        this.value = value;
        this.expenseDate = expenseDate;
    }
}
