package com.fitzone.FITZONE.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class UpdateCustomerDTO {
    private String name;
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDay;

    private String email;
    private String license;
    private String telephoneNumber;
    private String emergencyTelephoneNumber;
    private String address;
    private Double weight;
    private Double height;
    private String healthHistory;
    private String status;

    public UpdateCustomerDTO(String name, String cpf, LocalDate birthday, String email, String license, String telephoneNumber, String emergencyTelephoneNumber, String address, Double weight, Double height, String healthHistory, String status) {
        this.name = name;
        this.cpf = cpf;
        this.birthDay = birthday;
        this.email = email;
        this.license = license;
        this.telephoneNumber = telephoneNumber;
        this.emergencyTelephoneNumber = emergencyTelephoneNumber;
        this.address = address;
        this.weight = weight;
        this.height = height;
        this.healthHistory = healthHistory;
        this.status = status;
    }

    public UpdateCustomerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
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
        return emergencyTelephoneNumber;
    }

    public void setEmergencyTelephoneNumber(String emergencyTelephoneNumber) {
        this.emergencyTelephoneNumber = emergencyTelephoneNumber;
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
