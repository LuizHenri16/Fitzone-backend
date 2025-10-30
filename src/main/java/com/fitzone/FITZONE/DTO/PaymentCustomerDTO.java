package com.fitzone.FITZONE.DTO;

import com.fitzone.FITZONE.Models.Finance.License;

public class PaymentCustomerDTO {
    private Long id;
    private String name;
    private License license;

    public PaymentCustomerDTO() {
    }

    public PaymentCustomerDTO(Long id, String name, License license) {
        this.license = license;
        this.id = id;
        this.name = name;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
