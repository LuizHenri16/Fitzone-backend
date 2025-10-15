package com.fitzone.FITZONE.Models.Customer;

import com.fitzone.FITZONE.DTO.CustomerDTO;
import com.fitzone.FITZONE.Models.Finance.FinanceService;
import com.fitzone.FITZONE.Models.Finance.License;
import com.fitzone.FITZONE.Types.CPF;
import com.fitzone.FITZONE.Types.Email;
import com.fitzone.FITZONE.Types.Phone;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;


@Component
public class CustomerBuilder {
    private final FinanceService financeService;

    public CustomerBuilder (FinanceService financeService) {
       this.financeService = financeService;
    }

    public Customer buildCustomerFromDTO(CustomerDTO customerDTO) throws ChangeSetPersister.NotFoundException {

        License license = financeService.getLicenseByName(customerDTO.getLicense()).orElseThrow(ChangeSetPersister.NotFoundException::new);

        return new Customer(
                customerDTO.getCustomerName(),
                new CPF(customerDTO.getCustomerCPF()),
                customerDTO.getCustomerBirthDay(),
                new Email(customerDTO.getEmail()),
                license,
                new CustomerContact(
                        new Phone(customerDTO.getTelephoneNumber()),
                        new Phone(customerDTO.getEmergencyTelephoneNumber())),

                new CustomerAddress(customerDTO.getAddress()),

                new CustomerComplementInformation(customerDTO.getWeight(), customerDTO.getHeight(), customerDTO.getHealthHistory()),
                true
        );
    }

}
