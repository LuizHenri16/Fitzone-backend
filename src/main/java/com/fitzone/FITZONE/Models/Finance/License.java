package com.fitzone.FITZONE.Models.Finance;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private List<Payment> payments;

    public long getId() {
        return Id;
    }

    public String getLicense() {
        return license;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}


