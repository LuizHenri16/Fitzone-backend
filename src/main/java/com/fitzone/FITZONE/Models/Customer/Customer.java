package com.fitzone.FITZONE.Models.Customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fitzone.FITZONE.Models.Finance.License;
import com.fitzone.FITZONE.Models.Finance.Payment;
import com.fitzone.FITZONE.Types.CPF;
import com.fitzone.FITZONE.Types.Email;
import com.fitzone.FITZONE.Types.Phone;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "cpf", name = "UK_CPF_CUSTOMER")})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String name;

    @Embedded
    private CPF cpf;

    private LocalDate birthday;

    @Embedded
    private Email email;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private CustomerContact contact;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private CustomerAddress address;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private CustomerComplementInformation complementInformation;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, orphanRemoval = true)
    @OrderBy("lastPayment DESC")
    private Set<Payment> payments;

    @ManyToOne
    @JoinColumn(name = "license_id", nullable = false)
    @JsonManagedReference
    private License license;

    private boolean status;

    public Customer() {
    }

    public Customer(String name, CPF cpf, LocalDate birthday, Email email, CustomerContact contact, CustomerAddress address, CustomerComplementInformation complementInformation, License license, boolean status) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException("Nome do cliente inválido ou vazio!");
        }
        this.name = name;
        this.cpf = cpf;

        if (birthday == null || birthday.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento inválida!");
        }
        this.birthday = birthday;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.complementInformation = complementInformation;
        this.license = license;
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
        System.out.println(newBirthDay);
        this.birthday = newBirthDay;
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
        return birthday;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public License getLicense() {
        return license;
    }

    public String getStatus() {
        return status ? "Ativo" : "Inativo";
    }

    public LocalDate getLastPaymentDate() {
        if (payments == null || payments.isEmpty()) {
            return null;
        }
        return payments.iterator().next().getLastPayment();
    }

}
