package com.fitzone.FITZONE.DTO;

import java.time.LocalDate;

public class CustomerDTO {
    private String customerName;
    private String customerCPF;
    private LocalDate customerBirthDay;
    private String email;
    private String license;
    private String telephoneNumber;
    private String EmergencyTelephoneNumber;
    private String address;
    private Double weight;
    private Double height;
    private String healthHistory;

    public CustomerDTO(String customerName, String customerCPF, LocalDate customerBirthDay, String email, String license, String telephoneNumber, String emergencyTelephoneNumber, String address, Double weight, Double height, String healthHistory) {
        this.customerName = customerName;
        this.customerCPF = customerCPF;
        this.customerBirthDay = customerBirthDay;
        this.email = email;
        this.license = license;
        this.telephoneNumber = telephoneNumber;
        this.EmergencyTelephoneNumber = emergencyTelephoneNumber;
        this.address = address;
        this.weight = weight;
        this.height = height;
        this.healthHistory = healthHistory;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerCPF() {
        return customerCPF;
    }

    public LocalDate getCustomerBirthDay() {
        return customerBirthDay;
    }

    public String getEmail() {
        return email;
    }

    public String getLicense() {
        return license;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmergencyTelephoneNumber() {
        return EmergencyTelephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getHeight() {
        return height;
    }

    public String getHealthHistory() {
        return healthHistory;
    }
}
