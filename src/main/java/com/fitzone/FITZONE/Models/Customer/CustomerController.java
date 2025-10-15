package com.fitzone.FITZONE.Models.Customer;

import com.fitzone.FITZONE.DTO.CustomerDTO;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(name = "/customer")
public class CustomerController {

    private final CustomerBuilder customerBuilder;
    private final CustomerService customerService;

    public CustomerController (CustomerBuilder customerBuilder, CustomerService customerService) {
        this.customerService = customerService;
        this.customerBuilder = customerBuilder;
    }

    @PostMapping()
    public ResponseEntity<Customer> newCustomer(@RequestBody CustomerDTO customerDTO) throws ChangeSetPersister.NotFoundException {
        Customer customer = customerBuilder.buildCustomerFromDTO(customerDTO);
        Customer newCustomer = customerService.saveCustomer(customer);

        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Customer>> getAllCustomers(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        Page<Customer> paginateCustomers = customerService.findAllPaginable(pageable);
        return  ResponseEntity.ok(paginateCustomers);
    }
}
