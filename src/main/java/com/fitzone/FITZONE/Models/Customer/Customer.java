package com.fitzone.FITZONE.Models.Customer;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fitzone.FITZONE.Models.Finance.License;
import com.fitzone.FITZONE.Models.Finance.Payment;
import com.fitzone.FITZONE.Types.CPF;
import com.fitzone.FITZONE.Types.Email;
import com.fitzone.FITZONE.Types.Phone;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String name;

    @Embedded
    private CPF cpf;

    private LocalDate birthDay;

    @Embedded
    private Email email;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private CustomerContact contact;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private CustomerAddress address;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private CustomerComplementInformation complementInformation;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Payment> payment;

    @ManyToOne
    @JoinColumn(name = "license_id", nullable = false)
    @JsonManagedReference
    private License license;

    private boolean status;

    public Customer() {
    }

    public Customer(String customerName, CPF customerCPF, LocalDate customerBirthDay, Email email, License license, CustomerContact customerContact, CustomerAddress customerAddress, CustomerComplementInformation customerComplementInformation, boolean status) {

        if (customerName == null || customerName.trim().isBlank()) {
            throw new IllegalArgumentException("Nome do cliente inválido ou vazio!");
        }

        this.name = customerName;
        this.cpf = customerCPF;

        if (customerBirthDay == null || customerBirthDay.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento inválida!");
        }

        this.birthDay = customerBirthDay;
        this.email = email;
        this.license = license;
        this.contact = customerContact;
        this.address = customerAddress;
        this.complementInformation = customerComplementInformation;
        this.status = status;
    }

    public long getId() {
        return Id;
    }

    public String getEmail() {
        return email.getCustomerEmail();
    }

    public CustomerContact getCustomerContact() {
        return contact;
    }

    public CustomerAddress getCustomerAddress() {
        return address;
    }

    public CustomerComplementInformation getCustomerComplementInformation() {
        return complementInformation;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateCPF(CPF newCPF) {
        this.cpf = newCPF;
    }

    public void updateEmail(Email newEmail) {
        this.email = newEmail;
    }

    public void updateBirthDay(LocalDate newBirthDay) {
        this.birthDay = newBirthDay;
    }

    public void updateLicenses(License newLicense) {
        this.license = newLicense;
    }

    public void updateContact(Phone telephone, Phone emergencyTeleplhone) {
        this.contact.updateTelephone(telephone);
        this.contact.updateEmergencyTelephone(emergencyTeleplhone);
    }

    public void updateAddress(String customerAddress) {
        this.address.updateAddress(customerAddress);
    }

    public void updateCustomerComplementInformation(String healthHistory, Double weight, Double height) {
        this.complementInformation.updateHealthHistory(healthHistory);
        this.complementInformation.updateWeight(weight);
        this.complementInformation.updateHeight(height);
    }

    public void updateStatus(String status) {
        if (status.equals("Ativo")) {
            this.status = true;
        } else {
            this.status = false;
        }
    }

    public String getName() {
        return name;
    }

    public LocalDate getCustomerBirthDay() {
        return birthDay;
    }


    public License getLicense() {
        return license;
    }

    public String getStatus() {
        return status ? "Ativo" : "Inativo";
    }
}
