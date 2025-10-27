package com.fitzone.FITZONE.Repository;

import com.fitzone.FITZONE.DTO.BirthDayDTO;
import com.fitzone.FITZONE.Models.Customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Override
    Page<Customer> findAll(Pageable pageable);

    @NativeQuery("SELECT name FROM customer WHERE DAY(birthday) = DAY(CURDATE()) AND MONTH(birthday) = MONTH(CURDATE())")
    BirthDayDTO findAllByrthday();

    @NativeQuery("SELECT COUNT(*) FROM customer")
    Integer CountRegisteredCustomers();

    @NativeQuery("SELECT COUNT(*) FROM customer where status = 1")
    Integer CountRegisteredActiveCustomers();
}
