package com.fitzone.FITZONE.Models.Customer;

import com.fitzone.FITZONE.Types.Phone;
import jakarta.persistence.*;

@Entity
public class CustomerContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "telephone"))
    })
    private Phone telephone;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "emergencyTelephone"))
    })
    private Phone emergencyTelephone;

    @OneToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public CustomerContact() {
    }

    public CustomerContact(Phone telephone, Phone emergencyTelephone) {
        this.telephone = telephone;
        this.emergencyTelephone = emergencyTelephone;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void updateTelephone(Phone telephone) {
        this.telephone = telephone;
    }

    public void updateEmergencyTelephone(Phone emergencyTelephone) {
        this.emergencyTelephone = emergencyTelephone;
    }

    public String getTelephoneValue() {
        return telephone.getValue();
    }

    public String getEmergencyTelephoneValue() {
        return emergencyTelephone.getValue();
    }
}
