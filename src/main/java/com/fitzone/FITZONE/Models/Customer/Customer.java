package com.fitzone.FITZONE.Models.Customer;

import com.fitzone.FITZONE.Models.Finance.License;
import com.fitzone.FITZONE.Types.CPF;
import com.fitzone.FITZONE.Types.Email;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Name;

    @Embedded
    private CPF CPF;

    private LocalDate BirthDay;

    @Embedded
    private Email Email;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private CustomerContact Contact;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private CustomerAddress Address;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private CustomerComplementInformation ComplementInformation;

    @ManyToOne
    @JoinColumn(name = "licenseId", nullable = false)
    private License license;

    private boolean status;

    public Customer(String customerName, CPF customerCPF, LocalDate customerBirthDay, Email email, License license, CustomerContact customerContact, CustomerAddress customerAddress, CustomerComplementInformation customerComplementInformation, boolean status) {

        if (customerName == null || customerName.trim().isBlank()) {
            throw new IllegalArgumentException("Nome do cliente inválido ou vazio!");
        }
        this.Name = customerName;
        this.CPF = customerCPF;

        if (customerBirthDay == null || customerBirthDay.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento inválida!");
        }

        this.BirthDay = customerBirthDay;
        this.Email = email;
        this.license = license;
        this.Contact = customerContact;
        this.Address = customerAddress;
        this.ComplementInformation = customerComplementInformation;
        this.status = status;
    }
}
