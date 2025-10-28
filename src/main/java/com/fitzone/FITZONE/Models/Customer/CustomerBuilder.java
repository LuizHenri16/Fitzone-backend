package com.fitzone.FITZONE.Models.Customer;

import com.fitzone.FITZONE.DTO.CustomerDTO;
import com.fitzone.FITZONE.Models.Finance.FinanceService;
import com.fitzone.FITZONE.Models.Finance.License;
import com.fitzone.FITZONE.Types.CPF;
import com.fitzone.FITZONE.Types.Email;
import com.fitzone.FITZONE.Types.Phone;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class CustomerBuilder {

    public Customer buildCustomerFromDTO(CustomerDTO customerDTO) throws ChangeSetPersister.NotFoundException {

        return new Customer(
                customerDTO.getName(),
                new CPF(customerDTO.getCpf()),
                customerDTO.getBirthday(),
                new Email(customerDTO.getEmail()),
                new CustomerContact(
                        new Phone(customerDTO.getTelephoneNumber()),
                        new Phone(customerDTO.getEmergencyTelephoneNumber())),

                new CustomerAddress(customerDTO.getAddress()),

                new CustomerComplementInformation(customerDTO.getWeight(), customerDTO.getHeight(), customerDTO.getHealthHistory()),
                null,
                true
        );
    }

}
