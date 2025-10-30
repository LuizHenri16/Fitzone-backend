package com.fitzone.FITZONE.Models.Customer;

import com.fitzone.FITZONE.DTO.BirthDayDTO;
import com.fitzone.FITZONE.DTO.CustomerDTO;
import com.fitzone.FITZONE.DTO.PaymentCustomerDTO;
import com.fitzone.FITZONE.DTO.UpdateCustomerDTO;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> newCustomer(@RequestBody CustomerDTO customerDTO) throws ChangeSetPersister.NotFoundException {
        Customer newCustomer = customerService.saveCustomer(customerDTO);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Customer>> getAllCustomers(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        Page<Customer> paginateCustomers = customerService.findAllPaginable(pageable);
        return ResponseEntity.ok(paginateCustomers);
    }

    @GetMapping("/payment")
    public ResponseEntity<List<PaymentCustomerDTO>> getCustomersList() {
        List<PaymentCustomerDTO> customers = customerService.findCustomers();

        if (customers != null) {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);

        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> editCustomer(@PathVariable Long id, @RequestBody UpdateCustomerDTO updateCustomerDTO) throws ChangeSetPersister.NotFoundException {
        Customer updatedCustomer = customerService.editCustomer(id, updateCustomerDTO);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        boolean deletado = customerService.deleteByID(id);

        if (deletado) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/birthday")
    public ResponseEntity<BirthDayDTO> getBirthdayCustomer() {
        BirthDayDTO birthdayCustomers = customerService.getBirthdayCustomer();

        if (birthdayCustomers != null) {
            return new ResponseEntity<>(birthdayCustomers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/registeredcustomers")
    public ResponseEntity<Integer> getCountRegisteredCustomers() {
        Integer registeredCustomers = customerService.getRegisteredCustomers();

        if (registeredCustomers != null) {
            return new ResponseEntity<>(registeredCustomers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/activecustomers")
    public ResponseEntity<Integer> getCountRegisteredActiveCustomers() {
        Integer registeredActiveCustomers = customerService.getRegisteredActiveCustomers();

        if (registeredActiveCustomers != null) {
            return new ResponseEntity<>(registeredActiveCustomers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
