package com.fitzone.FITZONE;

import com.fitzone.FITZONE.DTO.CustomerDTO;
import com.fitzone.FITZONE.Models.Customer.Customer;
import com.fitzone.FITZONE.Models.Customer.CustomerAddress;
import com.fitzone.FITZONE.Models.Customer.CustomerComplementInformation;
import com.fitzone.FITZONE.Models.Customer.CustomerContact;
import com.fitzone.FITZONE.Models.Finance.License;
import com.fitzone.FITZONE.Models.User.User;
import com.fitzone.FITZONE.Repository.UserRepository;
import com.fitzone.FITZONE.Types.CPF;
import com.fitzone.FITZONE.Types.Email;
import com.fitzone.FITZONE.Types.Phone;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.util.AssertionErrors.*;

import java.time.LocalDate;

@SpringBootTest
class FitzoneApiApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void createCustomerEntity() {
            CustomerDTO customerDTO = new CustomerDTO(
                    "luiz",
                    "599.673.510-55",
                    LocalDate.of(2002, 4, 13),
                    "email@gmail.com", "Mensal",
                    "(71) 94242-3232", "(71) 94232-3222",
                    "rua teste",
                    100.0, 1.72,
                    "nada"
                    );

        CustomerContact customerContact = new CustomerContact(new Phone(customerDTO.getTelephoneNumber()), new Phone(customerDTO.getEmergencyTelephoneNumber()));
        CustomerAddress customerAddress = new CustomerAddress(customerDTO.getAddress());
        CustomerComplementInformation customerComplementInformation = new CustomerComplementInformation(customerDTO.getWeight(), customerDTO.getHeight(), customerDTO.getHealthHistory());

        Customer customer = new Customer(customerDTO.getName(), new CPF(customerDTO.getCpf()), customerDTO.getBirthday(),new Email(customerDTO.getEmail()), customerContact, customerAddress,  customerComplementInformation, new License(), true );
        Assertions.assertNotNull(customer.getCustomerAddress());
    }


    @Test
	void saveUserTest() {
        User newUser = new User("luizTeste", passwordEncoder.encode("12345678"), "Total");

        User savedUser = userRepository.save(newUser);

        Assertions.assertNotNull(savedUser);
        Assertions.assertEquals("luizTeste",  savedUser.getUsername());

        userRepository.deleteById(savedUser.getId());
	}

}
