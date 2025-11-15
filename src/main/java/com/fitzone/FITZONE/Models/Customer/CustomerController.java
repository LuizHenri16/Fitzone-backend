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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<?> newCustomer(@RequestBody CustomerDTO customerDTO) throws ChangeSetPersister.NotFoundException {
        Customer newCustomer = customerService.saveCustomer(customerDTO);

        Map<String, Object> response = new HashMap<>();

        if (newCustomer != null) {
            response.put("status", "sucesso");
            response.put("message", "cliente cadastrado com sucesso");
            response.put("customer", response);
            return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(newCustomer, HttpStatus.BAD_REQUEST);
        }

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
    public ResponseEntity<?> getCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);

        Map<String, Object> response = new HashMap<>();

        if (customer != null) {

            response.put("status", "sucesso");
            response.put("message", "cliente encontrado");
            response.put("customer", customer);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("status", "erro");
            response.put("message", "cliente não encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> editCustomer(@PathVariable Long id, @RequestBody UpdateCustomerDTO updateCustomerDTO) throws ChangeSetPersister.NotFoundException {
        Customer updatedCustomer = customerService.editCustomer(id, updateCustomerDTO);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        boolean deletado = customerService.deleteByID(id);

        if (deletado) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/birthday")
    public ResponseEntity<?> getBirthdayCustomer() {
        BirthDayDTO birthdayCustomers = customerService.getBirthdayCustomer();

        Map<String, Object> response = new HashMap<>();

        if (birthdayCustomers != null) {
            response.put("status", "sucesso");
            response.put("message", "aniversariantes encontrados");
            response.put("customer", birthdayCustomers);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("status", "erro");
            response.put("message", "não tem aniversariantes hoje");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/registeredcustomers")
    public ResponseEntity<?> getCountRegisteredCustomers() {
        Integer registeredCustomers = customerService.getRegisteredCustomers();

        Map<String, Object> response = new HashMap<>();

        if (registeredCustomers != null) {
            response.put("registrados", registeredCustomers);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("status", "erro");
            response.put("message", "não tem clientes cadastrados");

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/activecustomers")
    public ResponseEntity<?> getCountRegisteredActiveCustomers() {
        Integer registeredActiveCustomers = customerService.getRegisteredActiveCustomers();

        Map<String, Object> response = new HashMap<>();

        if (registeredActiveCustomers != null) {
            response.put("ativos", registeredActiveCustomers);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("status", "erro");
            response.put("message", "não tem clientes cadastrados");

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
