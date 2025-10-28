package com.fitzone.FITZONE.DTO;

public class PaymentDTO {
    private String lastPayment;
    private String customerName;
    private Double licensePrice;
    private String customerEmail;

    public PaymentDTO(String lastPayment, String customerName, Double licensePrice, String customerEmail) {
        this.lastPayment = lastPayment;
        this.customerName = customerName;
        this.licensePrice = licensePrice;
        this.customerEmail = customerEmail;
    }

    public PaymentDTO() {
    }

    public String getLastPayment() {
        return lastPayment;
    }

    public void setLastPayment(String lastPayment) {
        this.lastPayment = lastPayment;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getLicensePrice() {
        return licensePrice;
    }

    public void setLicensePrice(Double licensePrice) {
        this.licensePrice = licensePrice;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
