package com.fitzone.FITZONE.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class CustomerDTO {
    private String name;
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthday;

    private String email;
    private String license;
    private String telephoneNumber;
    private String EmergencyTelephoneNumber;
    private String address;
    private Double weight;
    private Double height;
    private String healthHistory;

    public CustomerDTO(String customerName, String customerCPF, LocalDate customerBirthDay, String email, String license, String telephoneNumber, String EmergencyTelephoneNumber, String address, Double weight, Double height, String healthHistory) {
        this.name = customerName;
        this.cpf = customerCPF;
        this.birthday = customerBirthDay;
        this.email = email;
        this.license = license;
        this.telephoneNumber = telephoneNumber;
        this.EmergencyTelephoneNumber = EmergencyTelephoneNumber;
        this.address = address;
        this.weight = weight;
        this.height = height;
        this.healthHistory = healthHistory;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthday() {
        return birthday;
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
