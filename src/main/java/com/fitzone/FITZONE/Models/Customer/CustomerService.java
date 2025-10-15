package com.fitzone.FITZONE.Models.Customer;

import com.fitzone.FITZONE.Repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

    public Page<Customer> findAllPaginable(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }


}
