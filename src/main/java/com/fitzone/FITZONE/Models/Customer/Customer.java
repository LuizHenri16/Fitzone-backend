package com.fitzone.FITZONE.Models.Customer;

import com.fitzone.FITZONE.Models.Finance.License;
import com.fitzone.FITZONE.Types.CPF;
import com.fitzone.FITZONE.Types.Email;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "licenseId", nullable = false)
    private License license;

    private boolean status;

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
}
