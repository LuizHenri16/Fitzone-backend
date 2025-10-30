package com.fitzone.FITZONE.DTO;

import com.fitzone.FITZONE.Models.Customer.Customer;
import com.fitzone.FITZONE.Models.Finance.Payment;

public class PaymentDTO {
    private Payment payment;
    private Customer customer;

    public PaymentDTO() {
    }

    public PaymentDTO(Payment payment, Customer customer) {
        this.payment = payment;
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}