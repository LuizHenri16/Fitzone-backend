package com.fitzone.FITZONE.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PaymentResponse {
    private Long id;
    private String customerName;
    private BigDecimal value;
    private LocalDateTime date;

    public PaymentResponse(Long id, String customerName, BigDecimal value, LocalDate date) {
        this.id = id;
        this.customerName = customerName;
        this.value = value;
        this.date = date.atStartOfDay();
    }

    public PaymentResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
