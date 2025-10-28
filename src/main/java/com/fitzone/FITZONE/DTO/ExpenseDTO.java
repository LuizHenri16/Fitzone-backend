package com.fitzone.FITZONE.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ExpenseDTO {
    private String description;
    private Double value;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    public ExpenseDTO() {
    }

    public ExpenseDTO(String description, Double value, LocalDate date) {
        this.description = description;
        this.value = value;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public Double getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }
}
