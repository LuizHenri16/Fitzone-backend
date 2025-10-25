package com.fitzone.FITZONE.DTO;

import java.time.LocalDate;

public class UpdateCustomerDTO {
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
    private String status;

    public UpdateCustomerDTO(String customerName, String customerCPF, LocalDate customerBirthDay, String email, String license, String telephoneNumber, String emergencyTelephoneNumber, String address, Double weight, Double height, String healthHistory, String status) {
        this.customerName = customerName;
        this.customerCPF = customerCPF;
        this.customerBirthDay = customerBirthDay;
        this.email = email;
        this.license = license;
        this.telephoneNumber = telephoneNumber;
        EmergencyTelephoneNumber = emergencyTelephoneNumber;
        this.address = address;
        this.weight = weight;
        this.height = height;
        this.healthHistory = healthHistory;
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCPF() {
        return customerCPF;
    }

    public void setCustomerCPF(String customerCPF) {
        this.customerCPF = customerCPF;
    }

    public LocalDate getCustomerBirthDay() {
        return customerBirthDay;
    }

    public void setCustomerBirthDay(LocalDate customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmergencyTelephoneNumber() {
        return EmergencyTelephoneNumber;
    }

    public void setEmergencyTelephoneNumber(String emergencyTelephoneNumber) {
        EmergencyTelephoneNumber = emergencyTelephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getHealthHistory() {
        return healthHistory;
    }

    public void setHealthHistory(String healthHistory) {
        this.healthHistory = healthHistory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
