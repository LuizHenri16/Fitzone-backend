package com.fitzone.FITZONE.Models.Customer;

import com.fitzone.FITZONE.DTO.BirthDayDTO;
import com.fitzone.FITZONE.DTO.UpdateCustomerDTO;
import com.fitzone.FITZONE.Models.Finance.FinanceService;
import com.fitzone.FITZONE.Models.Finance.License;
import com.fitzone.FITZONE.Repository.CustomerRepository;
import com.fitzone.FITZONE.Types.CPF;
import com.fitzone.FITZONE.Types.Email;
import com.fitzone.FITZONE.Types.Phone;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final FinanceService financeService;

    public CustomerService(CustomerRepository customerRepository, FinanceService financeService) {
        this.customerRepository = customerRepository;
        this.financeService = financeService;
    }

    public Customer saveCustomer(Customer newCustomer) {

        newCustomer.getCustomerAddress().setCustomer(newCustomer);
        newCustomer.getCustomerContact().setCustomer(newCustomer);
        newCustomer.getCustomerComplementInformation().setCustomer(newCustomer);

        return customerRepository.save(newCustomer);
    }

    public Customer editCustomer(Long id, UpdateCustomerDTO customerDTO) throws ChangeSetPersister.NotFoundException {
        // retorna o cliente
        Customer existentCustomer = getCustomer(id);
        License license = financeService.getLicenseByName(customerDTO.getLicense()).orElseThrow(ChangeSetPersister.NotFoundException::new);

        existentCustomer.updateName(customerDTO.getCustomerName());
        existentCustomer.updateCPF(new CPF(customerDTO.getCustomerCPF()));
        existentCustomer.updateEmail(new Email(customerDTO.getEmail()));
        existentCustomer.updateBirthDay(customerDTO.getCustomerBirthDay());
        existentCustomer.updateLicenses(license);

        existentCustomer.updateContact(new Phone(customerDTO.getTelephoneNumber()), new Phone(customerDTO.getEmergencyTelephoneNumber()));
        existentCustomer.updateAddress(customerDTO.getAddress());
        existentCustomer.updateCustomerComplementInformation(customerDTO.getHealthHistory(),  customerDTO.getWeight(), customerDTO.getHeight());
        existentCustomer.updateStatus(customerDTO.getStatus());

        return customerRepository.save(existentCustomer);
    }

    public Page<Customer> findAllPaginable(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public boolean deleteByID(Long id) {

        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public BirthDayDTO getBirthdayCustomer() {
        return customerRepository.findAllByrthday();
    }

    public Integer getRegisteredCustomers() {
        return customerRepository.CountRegisteredCustomers();
    }

    public Integer getRegisteredActiveCustomers() {
        return customerRepository.CountRegisteredCustomers();
    }
}
