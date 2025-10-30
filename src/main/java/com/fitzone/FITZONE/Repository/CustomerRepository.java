package com.fitzone.FITZONE.Repository;

import com.fitzone.FITZONE.DTO.BirthDayDTO;
import com.fitzone.FITZONE.DTO.PaymentCustomerDTO;
import com.fitzone.FITZONE.Models.Customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Override
    Page<Customer> findAll(Pageable pageable);

    @Query("SELECT new com.fitzone.FITZONE.DTO.PaymentCustomerDTO(c.id, c.name, c.license) FROM Customer c")
    List<PaymentCustomerDTO> findAllCustomers();

    @NativeQuery("SELECT name FROM customer WHERE DAY(birthday) = DAY(CURDATE()) AND MONTH(birthday) = MONTH(CURDATE())")
    BirthDayDTO findAllByrthday();

    @NativeQuery("SELECT COUNT(*) FROM customer")
    Integer CountRegisteredCustomers();

    @NativeQuery("SELECT COUNT(*) FROM customer where status = 1")
    Integer CountRegisteredActiveCustomers();
}
